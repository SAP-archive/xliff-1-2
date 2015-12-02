package com.sap.mlt.xliff12.impl.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.factory.AttributeFactory;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.factory.AttributeFactoryImpl;
import com.sap.mlt.xliff12.impl.persistence.XliffSerializerImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.XMLChar;

public abstract class ElementImpl extends NodeImpl implements Element {

	protected ElementImpl(String namespaceUri, String prefix, String name) {
		Assert.notNull(namespaceUri, "namespaceUri");
		Assert.notNull(name, "name");

		if ((prefix != null) && (prefix.length() == 0)) {
			prefix = null;
		}
		if ((prefix != null) && !XMLChar.isValidNCName(prefix)) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid XML prefix", prefix);
			throw new IllegalArgumentException(msg);
		}
		if (!XMLChar.isValidName(name)) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid element name", prefix);
			throw new IllegalArgumentException(msg);
		}

		this.namespaceUri = namespaceUri;
		this.prefix = prefix;
		this.name = name;
		setAttributeDefaults();
	}

	protected ElementImpl(String namespaceUri, String name,
			org.w3c.dom.Element xmlElement) throws ConstraintViolationException {
		if (!namespaceUri.equals(xmlElement.getNamespaceURI())) {
			throw new IllegalArgumentException(
					"The passed namespace and the namespace of the passed XML element don't match");
		}
		if (!name.equals(xmlElement.getLocalName())) {
			throw new IllegalArgumentException(
					"The passed name and the name of the passed XML element don't match");
		}
		this.namespaceUri = namespaceUri;
		this.prefix = xmlElement.getPrefix();
		if ((prefix != null) && (prefix.length() == 0)) {
			prefix = null;
		}
		this.name = name;

		setAttributeDefaults();
		assertAttributesValid(xmlElement);
		AttributeFactory attrFactory = AttributeFactoryImpl.getInstance();
		NamedNodeMap attrList = xmlElement.getAttributes();
		for (int i = 0; i < attrList.getLength(); ++i) {
			Attr attr = (Attr) attrList.item(i);
			// Special handling for namespace attributes
			if (Schemas.XMLNS_NAMESPACE.equals(attr.getNamespaceURI())) {
				String prefix = attr.getLocalName();
				if ("xmlns".equals(prefix)) {
					prefix = "";
				}
				String namespace = attr.getValue();
				namespace2Prefix.put(namespace, prefix);
				prefix2Namespace.put(prefix, namespace);
			} else {
				setAttribute(attrFactory.createAttribute(attr));
			}
		}

		ArrayList<org.w3c.dom.Node> elementsAndText = new ArrayList<org.w3c.dom.Node>();
		NodeList children = xmlElement.getChildNodes();
		for (int i = 0; i < children.getLength(); ++i) {
			org.w3c.dom.Node node = children.item(i);
			if ((node instanceof org.w3c.dom.Element)
					|| (node instanceof org.w3c.dom.Text)) {
				elementsAndText.add(node);
			}
		}
		processChildren(elementsAndText);
	}

	private String namespaceUri;

	private String prefix;

	private String name;

	private TreeMap<NSName, Attribute> attributes = new TreeMap<NSName, Attribute>();

	private TreeMap<NSName, Attribute> defaultAttributes = new TreeMap<NSName, Attribute>();

	private TreeMap<String, String> namespace2Prefix = new TreeMap<String, String>();

	private TreeMap<String, String> prefix2Namespace = new TreeMap<String, String>();

	public String getNamespaceUri() {
		return namespaceUri;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getNamespacePrefixMapping() {
		return Collections.unmodifiableMap(namespace2Prefix);
	}

	public void setNamespacePrefixMapping(Map<String, String> namespace2Prefix) {
		Assert.notNull(namespace2Prefix, "namespace2Prefix");
		HashSet<String> prefixes = new HashSet<String>();
		for (Map.Entry<String, String> entry : namespace2Prefix.entrySet()) {
			String namespace = entry.getKey();
			String prefix = entry.getValue();
			if (namespace == null) {
				throw new NullPointerException(
						"Map 'namespace2Prefix' must not contain a null key");
			}
			if (prefix == null) {
				throw new NullPointerException(
						"Map 'namespace2Prefix' must not contain null values");
			}
			if (prefixes.contains(prefix)) {
				String msg = MessageFormat
						.format(
								"Map ''namespace2Prefix'' contains the prefix ''{0}'' twice",
								prefix);
				throw new IllegalArgumentException(msg);
			}
			prefixes.add(prefix);
		}
		this.namespace2Prefix = new TreeMap<String, String>(namespace2Prefix);
		for (Map.Entry<String, String> entry : namespace2Prefix.entrySet()) {
			this.prefix2Namespace.put(entry.getValue(), entry.getKey());
		}
	}

	public Collection<? extends Attribute> getAttributes() {
		return Collections.unmodifiableCollection(attributes.values());
	}

	protected Attribute getAttribute(String namespaceUri, String name) {
		return attributes.get(new NSName(namespaceUri, name));
	}

	protected void setAttribute(Attribute attribute) {
		Assert.isInstance(attribute, "attribute", AttributeImpl.class);

		String namespace = attribute.getNamespaceUri();
		if (Schemas.XMLNS_NAMESPACE.equals(namespace)) {
			throw new IllegalArgumentException(
					"You must not set XML namespace attributes via this method");
		}

		Element owner = attribute.getOwnerElement();
		if ((owner != null) && (owner != this)) {
			String msg = MessageFormat.format(
					"Attribute {0} is already owned by element <{1}>",
					attribute, owner.getName());
			throw new IllegalArgumentException(msg);
		}

		NSName nsName = new NSName(attribute.getNamespaceUri(), attribute
				.getName());
		AttributeImpl oldAttributeImpl = (AttributeImpl) attributes.put(nsName,
				attribute);
		if (oldAttributeImpl != null) {
			oldAttributeImpl.setOwner(null);
		}
		((AttributeImpl) attribute).setOwner(this);
	}

	protected void clearAttribute(String namespaceUri, String name) {
		NSName nsn = new NSName(namespaceUri, name);
		AttributeImpl oldAttributeImpl = (AttributeImpl) attributes.remove(nsn);
		if (oldAttributeImpl != null) {
			oldAttributeImpl.setOwner(null);
		}
		Attribute defaultAttr = defaultAttributes.get(nsn);
		if (defaultAttr != null) {
			setAttribute((Attribute) defaultAttr.clone());
		}
	}

	protected void clearAttributes() {
		for (Attribute attribute : attributes.values()) {
			((AttributeImpl) attribute).setOwner(null);
		}
		attributes.clear();
		for (Attribute attr : defaultAttributes.values()) {
			setAttribute((Attribute) attr.clone());
		}
	}

	public abstract List<? extends Node> getChildren();

	public org.w3c.dom.Element asXmlNode(Document document) {
		return asXmlNode(document, null, null);
	}

	private org.w3c.dom.Element asXmlNode(Document document,
			Map<String, String> parentNamespace2Prefix,
			Map<String, String> parentPrefix2Namespace) {
		// If necessary initialize mappings
		if (parentNamespace2Prefix == null) {
			parentNamespace2Prefix = new HashMap<String, String>();
		}
		if (parentPrefix2Namespace == null) {
			parentPrefix2Namespace = new HashMap<String, String>();
		}

		// Create local mappings that are passed to children
		HashMap<String, String> localNamespace2Prefix = new HashMap<String, String>(
				parentNamespace2Prefix);
		HashMap<String, String> localPrefix2Namespace = new HashMap<String, String>(
				parentPrefix2Namespace);

		// Create prefix-namespace mapping for current element
		HashMap<String, String> currentPrefix2Namespace = new HashMap<String, String>();

		// Always add the local preferences except it is already available in
		// the parent mappings
		for (Map.Entry<String, String> entry : namespace2Prefix.entrySet()) {
			String namespace = entry.getKey();
			String prefix = entry.getValue();
			// Override the gloabl settings in either case
			localNamespace2Prefix.put(namespace, prefix);
			localPrefix2Namespace.put(prefix, namespace);
			// Add to the current mappings if not present in parent mappings
			String parentNamespace = parentPrefix2Namespace.get(prefix);
			if (!namespace.equals(parentNamespace)) {
				currentPrefix2Namespace.put(prefix, namespace);
			}
		}

		// We determine the prefix for the current element now
		if (this.prefix == null) {
			// Check if we have already a prefix for this namespace
			String elementPrefix = localNamespace2Prefix.get(this.namespaceUri);
			if (elementPrefix == null) {
				// We don't have a prefix yet
				// Check if the default namespace is used in local mapping
				// preferences
				String defaultNamespace = prefix2Namespace.get("");
				if (defaultNamespace == null) {
					// We will use the default namespace for this element
					localNamespace2Prefix.put(this.namespaceUri, "");
					localPrefix2Namespace.put("", this.namespaceUri);
					currentPrefix2Namespace.put("", this.namespaceUri);
				} else {
					// We have to generate a prefix
					elementPrefix = generatePrefix(localPrefix2Namespace,
							this.namespaceUri);
					localNamespace2Prefix.put(this.namespaceUri, elementPrefix);
					localPrefix2Namespace.put(elementPrefix, this.namespaceUri);
					currentPrefix2Namespace.put(elementPrefix,
							this.namespaceUri);
				}
			}
		} else {
			// We only need to do something if the mapping is not already
			// available
			String presentNamespace = localPrefix2Namespace.get(this.prefix);
			if (presentNamespace == null) {
				// Prefix is still free
				localNamespace2Prefix.put(this.namespaceUri, this.prefix);
				localPrefix2Namespace.put(this.prefix, this.namespaceUri);
				currentPrefix2Namespace.put(this.prefix, this.namespaceUri);
			} else if (!this.namespaceUri.equals(presentNamespace)) {
				// Check if this prefix is overriden by local preferences
				if (this.prefix2Namespace.containsKey(this.prefix)) {
					// We have to generate a prefix
					String elementPrefix = generatePrefix(
							localPrefix2Namespace, this.namespaceUri);
					localNamespace2Prefix.put(this.namespaceUri, elementPrefix);
					localPrefix2Namespace.put(elementPrefix, this.namespaceUri);
					currentPrefix2Namespace.put(elementPrefix,
							this.namespaceUri);
				} else {
					// We override the parent prefix
					localNamespace2Prefix.put(this.namespaceUri, this.prefix);
					localPrefix2Namespace.put(this.prefix, this.namespaceUri);
					currentPrefix2Namespace.put(this.prefix, this.namespaceUri);
				}
			}
		}

		// Now we will generate prefixes for attributes
		for (Attribute attr : attributes.values()) {
			// Ignore default attributes
			if (isDefaultAttribute(attr)) {
				continue;
			}
			// If namespace matches element namespace, we don't use a prefix
			String attrNamespace = attr.getNamespaceUri();
			if (attrNamespace.equals(this.namespaceUri)) {
				continue;
			}

			String attrPrefix = attr.getPrefix();
			if (attrPrefix == null) {
				// Check if we have already a prefix for this namespace
				attrPrefix = localNamespace2Prefix.get(attrNamespace);
				if (attrPrefix == null) {
					// We don't have a prefix yet and have to generate one
					attrPrefix = generatePrefix(localPrefix2Namespace,
							attrNamespace);
					localNamespace2Prefix.put(attrNamespace, attrPrefix);
					localPrefix2Namespace.put(attrPrefix, attrNamespace);
					currentPrefix2Namespace.put(attrPrefix, attrNamespace);
				}
			} else {
				// We only need to do something if the mapping is not already
				// available
				String presentNamespace = localPrefix2Namespace.get(attrPrefix);
				if (presentNamespace == null) {
					// Prefix is still free
					localNamespace2Prefix.put(attrNamespace, attrPrefix);
					localPrefix2Namespace.put(attrPrefix, attrNamespace);
					currentPrefix2Namespace.put(attrPrefix, attrNamespace);
				} else if (!attrNamespace.equals(presentNamespace)) {
					// Check if this prefix is overriden by local preferences
					if (this.prefix2Namespace.containsKey(attrPrefix)
							|| currentPrefix2Namespace.containsKey(attrPrefix)) {
						// We have to generate a prefix
						attrPrefix = generatePrefix(localPrefix2Namespace,
								attrNamespace);
						localNamespace2Prefix.put(attrNamespace, attrPrefix);
						localPrefix2Namespace.put(attrPrefix, attrNamespace);
						currentPrefix2Namespace.put(attrPrefix, attrNamespace);
					} else {
						// We override the parent prefix
						localNamespace2Prefix.put(attrNamespace, attrPrefix);
						localPrefix2Namespace.put(attrPrefix, attrNamespace);
						currentPrefix2Namespace.put(attrPrefix, attrNamespace);
					}
				}
			}
		}

		// We have determined the prefix/namespace mappings
		// Let's create the element now
		// Determine prefix first
		String elementPrefix;
		if (this.prefix == null) {
			elementPrefix = localNamespace2Prefix.get(this.namespaceUri);
		} else {
			if (this.namespaceUri
					.equals(localPrefix2Namespace.get(this.prefix))) {
				elementPrefix = this.prefix;
			} else {
				elementPrefix = localNamespace2Prefix.get(this.namespaceUri);
			}
		}
		String qualifiedName;
		if ("".equals(elementPrefix)) {
			qualifiedName = this.name;
		} else {
			qualifiedName = elementPrefix + ":" + name;
		}
		org.w3c.dom.Element element = document.createElementNS(namespaceUri,
				qualifiedName);

		// Add namespace attributes
		for (Map.Entry<String, String> entry : currentPrefix2Namespace
				.entrySet()) {
			String prefix = entry.getKey();
			String namespace = entry.getValue();
			// Add the namespace attribute
			qualifiedName = "".equals(prefix) ? "xmlns" : "xmlns:" + prefix;
			element.setAttributeNS(Schemas.XMLNS_NAMESPACE, qualifiedName,
					namespace);
		}

		// Add the attributes
		for (Attribute attr : attributes.values()) {
			// Don't add default attributes
			if (isDefaultAttribute(attr)) {
				continue;
			}

			String attrNamespace = attr.getNamespaceUri();
			String attrName = attr.getName();
			String attrValue = attr.getValue();

			// Special handling for attributes of same namespace as this element
			if (attrNamespace.equals(this.namespaceUri)) {
				element.setAttributeNS(null, attrName, attrValue);
				continue;
			}

			// Determine prefix
			String attrPrefix = attr.getPrefix();
			if (attrPrefix == null) {
				attrPrefix = localNamespace2Prefix.get(attrNamespace);
			} else {
				if (!attrNamespace
						.equals(localPrefix2Namespace.get(attrPrefix))) {
					attrPrefix = localNamespace2Prefix.get(attrNamespace);
				}
			}

			// attrPrefix will never be empty
			qualifiedName = attrPrefix + ":" + attrName;
			element.setAttributeNS(attrNamespace, qualifiedName, attrValue);
		}

		// Append children
		List<? extends Node> children = getChildren();
		for (Node child : children) {
			// Don't add empty text elements
			if (child instanceof Text) {
				Text text = (Text) child;
				if (text.getText().length() == 0) {
					continue;
				}
				element.appendChild(child.asXmlNode(document));
			} else if (child instanceof ElementImpl) {
				ElementImpl childImpl = (ElementImpl) child;
				element.appendChild(childImpl.asXmlNode(document,
						localNamespace2Prefix, localPrefix2Namespace));
			} else {
				element.appendChild(child.asXmlNode(document));
			}
		}
		return element;
	}

	private String generatePrefix(Map<String, String> prefix2Namespace,
			String namespace) {
		// Prefer 'xlf' for xlf-elements
		if (Schemas.XLIFF_12_NAMESPACE.equals(namespace)
				&& !prefix2Namespace.containsKey("xlf")) {
			return "xlf";
		}
		int counter = 0;
		while (true) {
			String prefix = "ns" + counter;
			if (!prefix2Namespace.containsKey(prefix)) {
				return prefix;
			}
			++counter;
		}
	}

	private boolean isDefaultAttribute(Attribute attr) {
		NSName nsName = new NSName(attr.getNamespaceUri(), attr.getName());
		Attribute defaultAttr = defaultAttributes.get(nsName);
		if (defaultAttr == null) {
			return false;
		}
		return attr.getValue().equals(defaultAttr.getValue());
	}

	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.emptyList();
	}

	protected final void setAttributeDefaults() {
		Collection<? extends Attribute> defaults = getDefaultAttributes();
		defaultAttributes.clear();
		for (Attribute attr : defaults) {
			defaultAttributes.put(new NSName(attr.getNamespaceUri(), attr
					.getName()), attr);
			setAttribute(attr);
		}
	}

	protected abstract void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException;

	protected abstract void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException;

	protected void assertNotAttached(Node node) {
		if (node != null) {
			Element parent = node.getParentElement();
			if ((parent != null) && (parent != this)) {
				throw new IllegalArgumentException(
						"Node is already attached to a different element");
			}
		}
	}

	protected void assertNotAttached(Collection<? extends Node> nodes) {
		if (nodes != null) {
			for (Node node : nodes) {
				assertNotAttached(node);
			}
		}
	}

	protected void detach(Node node) {
		if (node != null) {
			((NodeImpl) node).setParentElement(null);
		}
	}

	protected void detach(Collection<? extends Node> nodes) {
		if (nodes != null) {
			for (Node node : nodes) {
				detach(node);
			}
		}
	}

	protected void attach(Node node) {
		if (node != null) {
			((NodeImpl) node).setParentElement(this);
		}
	}

	protected void attach(Collection<? extends Node> nodes) {
		if (nodes != null) {
			for (Node node : nodes) {
				attach(node);
			}
		}
	}

	public Object clone() {
		ElementImpl clone = (ElementImpl) super.clone();

		// Clone attributes
		clone.attributes = new TreeMap<NSName, Attribute>();
		for (Attribute attribute : attributes.values()) {
			AttributeImpl attributeImpl = (AttributeImpl) attribute;
			clone.setAttribute((AttributeImpl) attributeImpl.clone());
		}

		// Clone prefix mapping
		clone.namespace2Prefix = new TreeMap<String, String>(namespace2Prefix);
		clone.prefix2Namespace = new TreeMap<String, String>(prefix2Namespace);

		// Clone children
		clone.cloneChildrenFrom(this);

		return clone;
	}

	protected abstract void cloneChildrenFrom(ElementImpl source);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attributes.hashCode();
		result = prime * result + name.hashCode();
		result = prime * result + namespaceUri.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ElementImpl))
			return false;
		ElementImpl other = (ElementImpl) obj;

		if (!attributes.equals(other.attributes))
			return false;
		if (!name.equals(other.name))
			return false;
		if (!namespaceUri.equals(other.namespaceUri))
			return false;

		if (!getChildren().equals(other.getChildren()))
			return false;

		return true;
	}

	private static DocumentBuilder documentBuilder;

	private static Transformer nullTransformer;

	private static Transformer prettyPrintTransformer;

	static {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			documentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			//$JL-EXC$
			documentBuilder = null;
		}

		final InputStream is = XliffSerializerImpl.class
				.getResourceAsStream("pretty_print_indent.xsl");
		Source template = new StreamSource(is);
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			tf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			nullTransformer = tf.newTransformer();
			nullTransformer.setOutputProperty(OutputKeys.INDENT, "no");
			prettyPrintTransformer = tf.newTransformer(template);
			prettyPrintTransformer.setOutputProperty(OutputKeys.INDENT, "no");
		} catch (TransformerConfigurationException e) {
			//$JL-EXC$
			documentBuilder = null;
			nullTransformer = null;
			prettyPrintTransformer = null;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// ignore exception during stream close
			}
		}
	}

	@Override
	public String toString() {
		if (documentBuilder == null) {
			return super.toString();
		}

		Document document;
		synchronized (documentBuilder) {
			document = documentBuilder.newDocument();
		}
		org.w3c.dom.Node node = asXmlNode(document);
		StringWriter writer = new StringWriter();
		DOMSource domSource = new DOMSource(node);
		DOMResult domResult = new DOMResult();
		synchronized (nullTransformer) {
			try {
				nullTransformer.transform(domSource, domResult);
			} catch (TransformerException e) {
				//$JL-EXC$
				return super.toString();
			}
		}

		domSource = new DOMSource(domResult.getNode());
		StreamResult streamResult = new StreamResult(writer);
		synchronized (prettyPrintTransformer) {
			try {
				prettyPrintTransformer.transform(domSource, streamResult);
			} catch (TransformerException e) {
				//$JL-EXC$
				return super.toString();
			}
		}
		return writer.toString();
	}

//	protected static List<? extends org.w3c.dom.Node> filterWhitespaceText(
//			List<? extends org.w3c.dom.Node> content) {
//		ArrayList<org.w3c.dom.Node> ret = new ArrayList<org.w3c.dom.Node>();
//		for (org.w3c.dom.Node node : content) {
//			if (node instanceof org.w3c.dom.Text) {
//				String s = node.getTextContent().trim();
//				if (s.length() > 0) {
//					ret.add(node);
//				}
//			} else {
//				ret.add(node);
//			}
//		}
//		return ret;
//	}

	private static class NSName implements Comparable<NSName> {

		public NSName(String namespaceUri, String name) {
			Assert.notNull(namespaceUri, "namespaceUri");
			Assert.notNull(name, "name");
			this.namespaceUri = namespaceUri;
			this.name = name;
		}

		private String namespaceUri;

		private String name;

		public int compareTo(NSName o) {
			int ret = namespaceUri.compareTo(o.namespaceUri);
			if (ret != 0) {
				if (Schemas.XLIFF_12_NAMESPACE.equals(namespaceUri)) {
					return -1;
				} else if (Schemas.XLIFF_12_NAMESPACE.equals(o.namespaceUri)) {
					return 1;
				} else {
					return ret;
				}
			}
			return name.compareTo(o.name);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + name.hashCode();
			result = prime * result + namespaceUri.hashCode();
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NSName other = (NSName) obj;
			if (!name.equals(other.name))
				return false;
			if (!namespaceUri.equals(other.namespaceUri))
				return false;
			return true;
		}
	}
}
