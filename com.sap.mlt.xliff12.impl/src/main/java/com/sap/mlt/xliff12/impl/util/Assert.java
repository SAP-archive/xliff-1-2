package com.sap.mlt.xliff12.impl.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public final class Assert {

	private Assert() {
	}

	public static void notNull(Object param, String paramName) {
		if (param == null) {
			String msg = MessageFormat.format(
					"Parameter ''{0}'' must not be null", paramName);
			throw new NullPointerException(msg);
		}
	}

	public static void validXMLChars(String s, String paramName) {
		Assert.notNull(s, paramName);
		TreeMap<Character, ArrayList<Integer>> invalidCharacters = new TreeMap<Character, ArrayList<Integer>>();
		int len = s.length();
		for (int i = 0; i < len; ++i) {
			char ch = s.charAt(i);
			if (XMLChar.isInvalid(ch)) {
				ArrayList<Integer> positions = invalidCharacters.get(ch);
				if (positions == null) {
					positions = new ArrayList<Integer>();
					invalidCharacters.put(ch, positions);
				}
				positions.add(i);
			}
		}
		if (invalidCharacters.isEmpty()) {
			return;
		}

		StringBuffer sb = new StringBuffer();
		sb
				.append(MessageFormat
						.format(
								"The string \"{0}\" contains the following characters that are invalid in XML:",
								s));

		String sep = System.getProperty("line.separator");
		for (Map.Entry<Character, ArrayList<Integer>> entry : invalidCharacters
				.entrySet()) {
			char ch = entry.getKey();
			ArrayList<Integer> positions = entry.getValue();
			sb.append(sep);
			sb.append(MessageFormat.format(
					"Character ''{0}'' (U+{1}) at {2}", ch, to4Hex(ch),
					createPositionsString(positions)));
		}

		throw new IllegalArgumentException(sb.toString());
	}

	public static void isNmtoken(String token, String paramName) {
		if (!XMLChar.isValidNmtoken(token)) {
			String msg = MessageFormat
					.format(
							"Parameter ''{0}'' with value ''{1}'' is not a valid NMTOKEN",
							paramName, token);
			throw new IllegalArgumentException(msg);
		}
	}

	public static void xliffAttrAvailable(Element elem, String... attrNames)
			throws ConstraintViolationException {
		HashSet<String> avail = new HashSet<String>();
		String elemNS = elem.getNamespaceURI();
		NamedNodeMap nodeMap = elem.getAttributes();
		for (int i = 0; i < nodeMap.getLength(); ++i) {
			Attr attr = (Attr) nodeMap.item(i);
			String ns = attr.getNamespaceURI();
			if (ns == null) {
				ns = elemNS;
			}
			if ((ns == null) || ns.equals(Schemas.XLIFF_12_NAMESPACE)) {
				avail.add(attr.getLocalName());
			}
		}
		for (String name : attrNames) {
			if (!avail.contains(name)) {
				String msg = MessageFormat
						.format(
								"Element ''{0}'' does not specify required attribute ''{1}''",
								elem.getLocalName(), name);
				throw new ConstraintViolationException(msg);
			}
		}
	}

	public static void xliffAttrRestricted(Element elem,
			boolean nonXliffAllowed, boolean xmlSpaceAllowed,
			boolean xmlLangAllowed, String... xliffAttrNames)
			throws ConstraintViolationException {
		HashSet<String> restriction = new HashSet<String>();
		for (String name : xliffAttrNames) {
			restriction.add(name);
		}
		String elemNS = elem.getNamespaceURI();
		NamedNodeMap nodeMap = elem.getAttributes();
		for (int i = 0; i < nodeMap.getLength(); ++i) {
			Attr attr = (Attr) nodeMap.item(i);
			String ns = attr.getNamespaceURI();
			String name = attr.getLocalName();
			if (ns == null) {
				ns = elemNS;
			}

			// Ignore namespace attributes
			if (Schemas.XMLNS_NAMESPACE.equals(ns)) {
				continue;
			}

			if ((ns == null) || ns.equals(Schemas.XLIFF_12_NAMESPACE)) {
				if (!restriction.contains(name)) {
					String msg = MessageFormat
							.format(
									"Element ''{0}'' specifies attribute ''{1}'' that is not allowed here",
									elem.getLocalName(), name);
					throw new ConstraintViolationException(msg);
				}
			} else if (ns.equals(Schemas.XML_NAMESPACE)) {
				if (!xmlSpaceAllowed && XmlSpace.NAME.equals(name)) {
					String msg = MessageFormat
							.format(
									"Element ''{0}'' specifies XML-attribute ''{1}'' that is not allowed here",
									elem.getLocalName(), name);
					throw new ConstraintViolationException(msg);
				} else if (!xmlLangAllowed && XmlLang.NAME.equals(name)) {
					String msg = MessageFormat
							.format(
									"Element ''{0}'' specifies XML-attribute ''{1}'' that is not allowed here",
									elem.getLocalName(), name);
					throw new ConstraintViolationException(msg);
				}
			} else if (!nonXliffAllowed) {
				String msg = MessageFormat
						.format(
								"Element ''{0}'' specifies Non-XLIFF-attribute ''{1}'' that is not allowed here",
								elem.getLocalName(), name);
				throw new ConstraintViolationException(msg);
			}
		}
	}

	public static void isXliffElement(org.w3c.dom.Node node)
			throws ConstraintViolationException {
		org.w3c.dom.Node parent = node.getParentNode();
		if (!(node instanceof org.w3c.dom.Element)) {
			String msg;
			if (node instanceof org.w3c.dom.Text) {
				if (parent != null) {
					msg = MessageFormat
							.format(
									"Expected XLIFF element in element <{0}>, but found text ''{1}''",
									parent.getLocalName(), node
											.getTextContent());
				} else {
					msg = MessageFormat.format(
							"Expected XLIFF element, but found text ''{0}''",
							node.getTextContent());
				}
			} else {
				msg = MessageFormat.format(
						"Expected XLIFF element, but found a node of type {0}",
						node.getClass().getName());
			}
			throw new ConstraintViolationException(msg);
		}

		org.w3c.dom.Element element = (Element) node;
		if (!Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI())) {
			String msg;
			if (parent != null) {
				msg = MessageFormat
						.format(
								"Expected an XLIFF element in element <{0}>, but found a element of namespace ''{1}''",
								parent.getLocalName(), element
										.getNamespaceURI());
			} else {
				msg = MessageFormat
						.format(
								"Expected an XLIFF element, but found a element of namespace ''{0}''",
								element.getNamespaceURI());
			}
			throw new ConstraintViolationException(msg);
		}
	}

	public static void isXliffElement(org.w3c.dom.Node node, String name)
			throws ConstraintViolationException {
		org.w3c.dom.Node parent = node.getParentNode();
		if (!(node instanceof org.w3c.dom.Element)) {
			String msg;
			if (node instanceof org.w3c.dom.Text) {
				if (parent != null) {
					msg = MessageFormat
							.format(
									"Expected XLIFF element in element <{0}>, but found text ''{1}''",
									parent.getLocalName(), node
											.getTextContent());
				} else {
					msg = MessageFormat.format(
							"Expected XLIFF element, but found text ''{0}''",
							node.getTextContent());
				}
			} else {
				msg = MessageFormat.format(
						"Expected XLIFF element, but found a node of type {0}",
						node.getClass().getName());
			}
			throw new ConstraintViolationException(msg);
		}

		org.w3c.dom.Element element = (Element) node;
		if (!Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI())) {
			String msg;
			if (parent != null) {
				msg = MessageFormat
						.format(
								"Expected an XLIFF element in element <{0}>, but found a element of namespace ''{1}''",
								parent.getLocalName(), element
										.getNamespaceURI());
			} else {
				msg = MessageFormat
						.format(
								"Expected an XLIFF element, but found a element of namespace ''{0}''",
								element.getNamespaceURI());
			}
			throw new ConstraintViolationException(msg);
		}

		if (!name.equals(element.getLocalName())) {
			String msg;
			if (parent != null) {
				msg = MessageFormat
						.format(
								"Expected XLIFF element <{0}> in element <{1}>, but found element <{2}> of namespace ''{3}''",
								name, parent.getLocalName(), element
										.getLocalName(), element
										.getNamespaceURI());
			} else {
				msg = MessageFormat
						.format(
								"Expected XLIFF element <{0}>, but found element <{1}> of namespace ''{2}''",
								name, element.getLocalName(), element
										.getNamespaceURI());
			}
			throw new ConstraintViolationException(msg);
		}
	}

	public static void isElement(Node node) throws ConstraintViolationException {
		org.w3c.dom.Node parent = node.getParentNode();
		if (!(node instanceof org.w3c.dom.Element)) {
			String msg;
			if (node instanceof org.w3c.dom.Text) {
				if (parent != null) {
					msg = MessageFormat
							.format(
									"Expected XLIFF element in element <{0}>, but found text ''{1}''",
									parent.getLocalName(), node
											.getTextContent());
				} else {
					msg = MessageFormat.format(
							"Expected XLIFF element, but found text ''{0}''",
							node.getTextContent());
				}
			} else {
				msg = MessageFormat.format(
						"Expected XLIFF element, but found a node of type {0}",
						node.getClass().getName());
			}
			throw new ConstraintViolationException(msg);
		}
	}

	public static void isNonXliffElement(org.w3c.dom.Node node)
			throws ConstraintViolationException {
		org.w3c.dom.Node parent = node.getParentNode();
		if (!(node instanceof org.w3c.dom.Element)) {
			String msg;
			if (node instanceof org.w3c.dom.Text) {
				if (parent != null) {
					msg = MessageFormat
							.format(
									"Expected non-XLIFF element in element <{0}>, but found text ''{1}''",
									parent.getLocalName(), node
											.getTextContent());
				} else {
					msg = MessageFormat
							.format(
									"Expected non-XLIFF element, but found text ''{0}''",
									node.getTextContent());
				}
			} else {
				msg = MessageFormat
						.format(
								"Expected non-XLIFF element, but found a node of type {0}",
								node.getClass().getName());
			}
			throw new ConstraintViolationException(msg);
		}

		org.w3c.dom.Element element = (Element) node;
		if (Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI())) {
			String msg;
			if (parent != null) {
				msg = MessageFormat
						.format(
								"Expected a non-XLIFF element in element <{0}>, but found XLIFF-element <{1}>",
								parent.getLocalName(), element.getLocalName());
			} else {
				msg = MessageFormat
						.format(
								"Expected a non-XLIFF element, but found XLIFF-element <{0}>",
								element.getLocalName());
			}
			throw new ConstraintViolationException(msg);
		}
	}

	public static void isInstance(Object object, String name,
			Class<?>... classes) {
		if (object == null) {
			return;
		}
		for (Class<?> clazz : classes) {
			if (clazz.isInstance(object)) {
				return;
			}
		}
		String msg = MessageFormat
				.format(
						"Parameter ''{0}'' is not an instance of a class of this implementation",
						name);
		throw new IllegalArgumentException(msg);
	}

	public static void areInstances(Collection<?> objects, String name,
			Class<?>... classes) {
		if (objects != null) {
			for (Object object : objects) {
				isInstance(object, name, classes);
			}
		}
	}

	private static String to4Hex(char ch) {
		String ret = Integer.toHexString((int) ch);
		while (ret.length() < 4)
			ret = '0' + ret;
		return ret;
	}

	private static String createPositionsString(List<Integer> positions) {
		int n = positions.size();
		if (n == 1) {
			return MessageFormat.format("position {0}", positions.get(0));
		} else {
			StringBuffer sb = new StringBuffer("positions ");
			for (int i = 0; i < n - 1; ++i) {
				sb.append(positions.get(i));
				if (i != n - 2) {
					sb.append(", ");
				}
			}
			sb.append(" and ");
			sb.append(positions.get(n - 1));
			return sb.toString();
		}
	}
}
