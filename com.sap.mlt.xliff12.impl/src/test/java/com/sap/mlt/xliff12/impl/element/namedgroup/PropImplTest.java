package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class PropImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testPropImplPropTypeText() {
		PropImpl prop = createDefaultProp();
		assertEquals(new PropTypeImpl("ptype"), prop.getPropType());
		assertEquals(new TextImpl("prpty"), prop.getContent());
	}

	@Test
	public void testPropImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "prop");
		elem.setAttributeNS(null, "prop-type", "ptype");

		try {
			PropImpl prop = new PropImpl(elem);
			assertEquals(new PropTypeImpl("ptype"), prop.getPropType());
			assertEquals(new TextImpl(""), prop.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new PropImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		elem.appendChild(doc.createTextNode("test"));
		try {
			new PropImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
			elem.removeChild(elem.getFirstChild());
		}

		elem.setTextContent("prpty");
		try {
			PropImpl prop = new PropImpl(elem);
			assertEquals(new PropTypeImpl("ptype"), prop.getPropType());
			assertEquals(new TextImpl("prpty"), prop.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		PropImpl prop = createDefaultProp();
		ArrayList<TextImpl> expected = new ArrayList<TextImpl>();
		expected.add(new TextImpl("prpty"));
		assertEquals(expected, prop.getChildren());
	}

	@Test
	public void testPropType() {
		PropImpl prop = createDefaultProp();
		try {
			prop.setPropType(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new PropTypeImpl("ptype"), prop.getPropType());
		prop.setPropType(new PropTypeImpl("abc"));
		assertEquals(new PropTypeImpl("abc"), prop.getPropType());
	}

	@Test
	public void testContent() {
		PropImpl prop = createDefaultProp();
		try {
			prop.setContent(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new TextImpl("prpty"), prop.getContent());

		prop.setContent(new TextImpl("abc"));
		assertEquals(new TextImpl("abc"), prop.getContent());
	}

	@Test
	public void testXmlLang() {
		PropImpl prop = createDefaultProp();
		prop.setXmlLang(new XmlLangImpl("de-AT"));
		assertEquals(new XmlLangImpl("de-AT"), prop.getXmlLang());
		prop.setXmlLang(null);
		assertNull(prop.getXmlLang());
	}
	
	@Test
	public void testClone() {
		PropImpl prop = createDefaultProp();
		PropImpl clone = (PropImpl) prop.clone();
		assertEquals(prop, clone);
		assertNotSame(prop, clone);
	}

	private PropImpl createDefaultProp() {
		PropImpl prop = new PropImpl(new PropTypeImpl("ptype"), new TextImpl(
				"prpty"));
		return prop;
	}

}
