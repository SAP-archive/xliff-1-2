package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ElementImplTest {

	private final static String XMLNS_NAMESPACE = "http://www.w3.org/2000/xmlns/";

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testHashCode() {
		ConcreteElementImpl elem1 = new ConcreteElementImpl("ns", "pre", "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", "pre2",
				"name");
		elem1.setAttribute(new ConcreteAttributeImpl("ns2", "pre3", "name",
				"value"));
		elem2.setAttribute(new ConcreteAttributeImpl("ns2", "pre3", "name",
				"value"));
		HashMap<String, String> mappings = new HashMap<String, String>();
		mappings.put("ns4", "pre3");
		elem1.setNamespacePrefixMapping(mappings);

		assertEquals(new Integer(elem1.hashCode()), new Integer(elem2
				.hashCode()));
	}

	@Test
	public void testElementImplStringStringString() {
		ConcreteElementImpl elem;

		elem = new ConcreteElementImpl("ns", "pre", "name");
		assertEquals("ns", elem.getNamespaceUri());
		assertEquals("pre", elem.getPrefix());
		assertEquals("name", elem.getName());

		elem = new ConcreteElementImpl("ns", "", "name");
		assertEquals("ns", elem.getNamespaceUri());
		assertNull(elem.getPrefix());
		assertEquals("name", elem.getName());

		elem = new ConcreteElementImpl("ns", null, "name");
		assertEquals("ns", elem.getNamespaceUri());
		assertNull(elem.getPrefix());
		assertEquals("name", elem.getName());

		try {
			elem = new ConcreteElementImpl(null, "pre", "name");
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		try {
			String nullName = null;
			elem = new ConcreteElementImpl("ns", "pre", nullName);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		try {
			elem = new ConcreteElementImpl("ns", "pre:", "name");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		try {
			elem = new ConcreteElementImpl("ns", "pre", "na\nme");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

	}

	@Test
	public void testElementImplStringStringElement() {
		Document doc = Utils.createDocument();
		org.w3c.dom.Element elem = doc.createElementNS("ns", "pre:name");
		elem.setAttributeNS(XMLNS_NAMESPACE, "xmlns:xyz", "xyzns");
		elem.setAttributeNS(XMLNS_NAMESPACE, "xmlns", "ijkns");
		elem.setAttributeNS("ns", "name", "value");
		elem.appendChild(doc.createElementNS("ns", "pre:child"));
		elem.appendChild(doc.createTextNode("text"));

		ConcreteElementImpl cei = null;
		try {
			cei = new ConcreteElementImpl("ns", "name", elem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		assertEquals("ns", cei.getNamespaceUri());
		assertEquals("pre", cei.getPrefix());
		assertEquals("name", cei.getName());
		Map<String, String> mappings = cei.getNamespacePrefixMapping();
		assertEquals(new Integer(2), new Integer(mappings.size()));
		assertEquals("xyz", mappings.get("xyzns"));
		assertEquals("", mappings.get("ijkns"));

		List<? extends Node> children = cei.getChildren();
		assertEquals(new Integer(2), new Integer(children.size()));
		Element child1 = (Element) children.get(0);
		assertEquals("ns", child1.getNamespaceUri());
		assertEquals("pre", child1.getPrefix());
		assertEquals("child", child1.getName());
		Text child2 = (Text) children.get(1);
		assertEquals("text", child2.getText());

		try {
			cei = new ConcreteElementImpl("ns1", "name", elem);
			fail("Expected IllegalArgumentException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		try {
			cei = new ConcreteElementImpl("ns", "name1", elem);
			fail("Expected IllegalArgumentException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testNamespacePrefixMapping() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", null, "name");
		HashMap<String, String> mapping = new HashMap<String, String>();
		mapping.put("abcns", "abc");
		mapping.put("ns", "");
		elem.setNamespacePrefixMapping(mapping);

		mapping.put("ijk", null);
		try {
			elem.setNamespacePrefixMapping(mapping);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			//$JL-EXC$
			mapping.remove("ijk");
		}

		mapping.put(null, "ijk");
		try {
			elem.setNamespacePrefixMapping(mapping);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			//$JL-EXC$
			mapping.remove(null);
		}

		mapping.put("abc2ns", "abc");
		try {
			elem.setNamespacePrefixMapping(mapping);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//$JL-EXC$
			mapping.remove("abc2ns");
		}

	}

	@Test
	public void testAttributes() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", "pre", "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", "pre", "name");

		ConcreteAttributeImpl attr1 = new ConcreteAttributeImpl("ns", null,
				"attr1", "value1");
		ConcreteAttributeImpl attr2 = new ConcreteAttributeImpl("ns", null,
				"attr2", "value2");
		ConcreteAttributeImpl attr3 = new ConcreteAttributeImpl("ns2", "pre2",
				"attr2", "value3");
		ConcreteAttributeImpl attr4 = new ConcreteAttributeImpl(
				XMLNS_NAMESPACE, "xmlns", "abc", "value4");

		elem.setAttribute(attr1);
		elem.setAttribute(attr2);
		elem.setAttribute(attr3);
		try {
			elem.setAttribute(attr4);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			elem2.setAttribute(attr1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		Attribute gattr1 = elem.getAttribute("ns", "attr1");
		assertEquals("value1", gattr1.getValue());
		Attribute gattr2 = elem.getAttribute("ns", "attr2");
		assertEquals("value2", gattr2.getValue());
		Attribute gattr3 = elem.getAttribute("ns2", "attr2");
		assertEquals("value3", gattr3.getValue());
		assertNull(elem.getAttribute("ns2", "attr1"));

		Collection<? extends Attribute> attributes = elem.getAttributes();
		// We have one default attribute
		assertEquals(new Integer(4), new Integer(attributes.size()));

		elem.clearAttribute("ns", "attr1");
		assertNull(elem.getAttribute("ns", "attr1"));
		assertEquals(new Integer(3), new Integer(attributes.size()));

		elem.clearAttributes();
		assertEquals(new Integer(1), new Integer(attributes.size()));

		elem.clearAttribute("ns", "defaultattr");
		assertEquals(new Integer(1), new Integer(attributes.size()));
	}

	@Test
	public void testAsXmlNodeBasicXliff() {
		ConcreteElementImpl elem = new ConcreteElementImpl(XLIFF_12_NAMESPACE,
				null, "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns1", "pre", "name",
				"value1"));
		elem.setAttribute(new ConcreteAttributeImpl("ns2", "pre", "name",
				"value2"));
		elem.setAttribute(new ConcreteAttributeImpl("ns3", null, "name",
				"value3"));
		elem.setAttribute(new ConcreteAttributeImpl(XLIFF_12_NAMESPACE, null,
				"datatype", "plaintext"));

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());

		assertEquals(XLIFF_12_NAMESPACE, xmlElem.getNamespaceURI());
		assertNull(xmlElem.getPrefix());
		assertEquals("name", xmlElem.getLocalName());

		assertEquals("value1", xmlElem.getAttributeNS("ns1", "name"));
		assertEquals("value2", xmlElem.getAttributeNS("ns2", "name"));
		assertEquals("value3", xmlElem.getAttributeNS("ns3", "name"));
		assertEquals("plaintext", xmlElem.getAttributeNS(null, "datatype"));

		assertEquals(XLIFF_12_NAMESPACE, xmlElem.getAttributeNS(
				XMLNS_NAMESPACE, "xmlns"));
	}

	@Test
	public void testAsXmlNodeBasicNonXliff() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", null, "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns1", "pre", "name",
				"value1"));
		elem.setAttribute(new ConcreteAttributeImpl("ns2", "pre", "name",
				"value2"));
		elem.setAttribute(new ConcreteAttributeImpl("ns3", null, "name",
				"value3"));
		elem.setAttribute(new ConcreteAttributeImpl(XLIFF_12_NAMESPACE, null,
				"datatype", "plaintext"));

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());

		assertEquals("ns1", xmlElem.getNamespaceURI());
		assertNull(xmlElem.getPrefix());
		assertEquals("name", xmlElem.getLocalName());

		assertEquals("value1", xmlElem.getAttributeNS(null, "name"));
		assertEquals("value2", xmlElem.getAttributeNS("ns2", "name"));
		assertEquals("value3", xmlElem.getAttributeNS("ns3", "name"));
		assertEquals("plaintext", xmlElem.getAttributeNS(XLIFF_12_NAMESPACE,
				"datatype"));

		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "xmlns"));
		assertEquals("ns2", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
		assertEquals("ns3", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "ns0"));
		assertEquals(XLIFF_12_NAMESPACE, xmlElem.getAttributeNS(
				XMLNS_NAMESPACE, "xlf"));
	}

	@Test
	public void testAsXmlNodeDefaultAttributes() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", null, "name");
		assertEquals("defaultvalue", elem.getAttribute("ns", "defaultattr")
				.getValue());

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("", xmlElem.getAttributeNS(null, "defaultattr"));

		elem.setAttribute(new ConcreteAttributeImpl("ns", null, "defaultattr",
				"specificvalue"));
		assertEquals("specificvalue", elem.getAttribute("ns", "defaultattr")
				.getValue());
		xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("specificvalue", xmlElem.getAttributeNS(null,
				"defaultattr"));
	}

	@Test
	public void testAsXmlNodeAutoElemPrefix() {
		ConcreteElementImpl elem = new ConcreteElementImpl(XLIFF_12_NAMESPACE,
				null, "name");
		HashMap<String, String> namespace2Prefix = new HashMap<String, String>();
		namespace2Prefix.put("ns", "");
		elem.setNamespacePrefixMapping(namespace2Prefix);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "xmlns"));
		assertEquals(XLIFF_12_NAMESPACE, xmlElem.getAttributeNS(
				XMLNS_NAMESPACE, "xlf"));
	}

	@Test
	public void testAsXmlNodeAutoAttrPrefix() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", null, "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns2", null, "name",
				"value"));
		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "xmlns"));
		assertEquals("value", xmlElem.getAttributeNS("ns2", "name"));
	}

	@Test
	public void testAsXmlNodeNSPreferences() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", null, "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns2", null, "name",
				"value"));
		HashMap<String, String> namespace2Prefix = new HashMap<String, String>();
		namespace2Prefix.put("ns1", "ns1");
		namespace2Prefix.put("ns2", "ns2");
		elem.setNamespacePrefixMapping(namespace2Prefix);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "ns1"));
		assertEquals("ns2", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "ns2"));
	}

	@Test
	public void testAsXmlNodeNoExtraNSDeclarations() {
		HashMap<String, String> namespace2Prefix = new HashMap<String, String>();
		namespace2Prefix.put("ns1", "pre1");
		namespace2Prefix.put("ns2", "pre2");

		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", null, "name");
		elem.setNamespacePrefixMapping(namespace2Prefix);

		ConcreteElementImpl child = new ConcreteElementImpl("ns1", null, "name");
		child.setNamespacePrefixMapping(namespace2Prefix);
		child.setAttribute(new ConcreteAttributeImpl("ns2", null, "name",
				"value"));
		elem.addChild(child);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre1"));
		assertEquals("ns2", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre2"));

		org.w3c.dom.Element xmlChild = (org.w3c.dom.Element) xmlElem
				.getChildNodes().item(0);
		assertEquals("", xmlChild.getAttributeNS(XMLNS_NAMESPACE, "pre1"));
		assertEquals("", xmlChild.getAttributeNS(XMLNS_NAMESPACE, "pre2"));
	}

	@Test
	public void testAsXmlNodeOverrideElementPrefix() {
		HashMap<String, String> namespace2Prefix = new HashMap<String, String>();
		namespace2Prefix.put("ns2", "pre");

		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", "pre", "name");
		elem.setNamespacePrefixMapping(namespace2Prefix);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns2", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
	}

	@Test
	public void testAsXmlNodeOverrideParentElementPrefix() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", "pre", "name");
		ConcreteElementImpl child = new ConcreteElementImpl("ns2", "pre",
				"name");
		elem.addChild(child);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		org.w3c.dom.Element xmlChild = (org.w3c.dom.Element) xmlElem
				.getChildNodes().item(0);

		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
		assertEquals("ns2", xmlChild.getAttributeNS(XMLNS_NAMESPACE, "pre"));
	}

	@Test
	public void testAsXmlNodeOverrideAttributePrefix() {
		HashMap<String, String> namespace2Prefix = new HashMap<String, String>();
		namespace2Prefix.put("ns3", "pre");

		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", "pre", "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns2", "pre", "name",
				"value"));
		elem.setNamespacePrefixMapping(namespace2Prefix);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns3", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
		assertEquals("value", xmlElem.getAttributeNS("ns2", "name"));
	}

	@Test
	public void testAsXmlNodeOverrideParentAttributePrefix() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", "pre", "name");
		ConcreteElementImpl child = new ConcreteElementImpl("ns2", "pre2",
				"name");
		child.setAttribute(new ConcreteAttributeImpl("ns3", "pre", "name",
				"value"));
		elem.addChild(child);

		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		org.w3c.dom.Element xmlChild = (org.w3c.dom.Element) xmlElem
				.getChildNodes().item(0);

		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
		assertEquals("ns3", xmlChild.getAttributeNS(XMLNS_NAMESPACE, "pre"));
	}

	@Test
	public void testAsXmlNodeAttributePrefixDoesNotOverrideElementPrefix() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns1", "pre", "name");
		elem.setAttribute(new ConcreteAttributeImpl("ns2", "pre", "name",
				"value"));
		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals("ns1", xmlElem.getAttributeNS(XMLNS_NAMESPACE, "pre"));
	}

	@Test
	public void textAsXmlNodeNonEmptyText() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", "pre", "name");
		elem.addChild(new TextImpl("abc"));
		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		org.w3c.dom.Text text = (org.w3c.dom.Text) xmlElem.getChildNodes()
				.item(0);
		assertEquals("abc", text.getTextContent());
	}

	@Test
	public void textAsXmlNodeEmptyText() {
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", "pre", "name");
		elem.addChild(new TextImpl(""));
		org.w3c.dom.Element xmlElem = elem.asXmlNode(Utils.createDocument());
		assertEquals(new Integer(0), new Integer(xmlElem.getChildNodes()
				.getLength()));
	}

	@Test
	public void testEqualsObjectSimple() {
		ConcreteElementImpl elem1 = new ConcreteElementImpl("ns", "pre", "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", "pre2",
				"name");
		ConcreteElementImpl elem3 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem4 = new ConcreteElementImpl("ns2", "pre2",
				"name");
		ConcreteElementImpl elem5 = new ConcreteElementImpl("ns", "pre2",
				"name2");
		assertEquals(elem1, elem1);
		assertEquals(elem1, elem2);
		assertEquals(elem1, elem3);
		assertFalse(elem1.equals(elem4));
		assertFalse(elem1.equals(elem5));
		assertFalse(elem1.equals(null));
		assertFalse(elem1.equals(new Object()));
	}

	@Test
	public void testEqualsObjectAttributes() {
		ConcreteElementImpl elem1 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem3 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem4 = new ConcreteElementImpl("ns", null, "name");

		elem1.setAttribute(new ConcreteAttributeImpl("ns", "pre", "name",
				"value"));
		elem2.setAttribute(new ConcreteAttributeImpl("ns", "pre", "name",
				"value"));
		elem3.setAttribute(new ConcreteAttributeImpl("ns", "pre", "name",
				"value"));
		elem3.setAttribute(new ConcreteAttributeImpl("ns2", "pre", "name",
				"value"));

		assertEquals(elem1, elem2);
		assertFalse(elem1.equals(elem3));
		assertFalse(elem1.equals(elem4));
	}

	@Test
	public void testEqualsObjectChildren() {
		ConcreteElementImpl elem1 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem3 = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem4 = new ConcreteElementImpl("ns", null, "name");

		elem1.addChild(new ConcreteElementImpl("ns", null, "name"));
		elem2.addChild(new ConcreteElementImpl("ns", null, "name"));
		elem3.addChild(new ConcreteElementImpl("ns", null, "name"));
		elem3.addChild(new ConcreteElementImpl("ns", null, "name"));
		elem4.addChild(new TextImpl("abc"));

		assertEquals(elem1, elem2);
		assertFalse(elem1.equals(elem3));
		assertFalse(elem1.equals(elem4));
	}

	@Test
	public void testToString() {
		Document doc = Utils.createDocument();
		org.w3c.dom.Element elem = doc.createElementNS("ns", "pre:name");
		elem.setAttributeNS(XMLNS_NAMESPACE, "xmlns:xyz", "xyzns");
		elem.setAttributeNS(XMLNS_NAMESPACE, "xmlns", "ijkns");
		elem.setAttributeNS("ns", "name", "value");
		elem.appendChild(doc.createElementNS("ns", "pre:child"));
		elem.appendChild(doc.createTextNode("text"));

		ConcreteElementImpl cei = null;
		try {
			cei = new ConcreteElementImpl("ns", "name", elem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		cei.toString();
	}

	@Test
	public void testClone() {
		ConcreteElementImpl parent = new ConcreteElementImpl("ns", null, "name");
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", null, "name");
		parent.addChild(elem);

		ConcreteElementImpl celem = elem.clone();
		assertNull(celem.getParentElement());
		assertEquals(elem, celem);
		assertNotSame(elem, celem);

	}
}
