package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class XliffElementImplTest {

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testXliffElementImplString() {
		ConcreteXliffElementImpl elem = new ConcreteXliffElementImpl("name");
		assertEquals("name", elem.getName());	
		assertEquals(XLIFF_12_NAMESPACE, elem.getNamespaceUri());	
	}

	@Test
	public void testXliffElementImplStringElement() {
		ConcreteXliffElementImpl elem;
		Element xmlElem;
		Document doc = Utils.createDocument();

		xmlElem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		try {
			elem = new ConcreteXliffElementImpl("name", xmlElem);
			assertEquals("name", elem.getName());	
			assertEquals(XLIFF_12_NAMESPACE, elem.getNamespaceUri());	
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		xmlElem = doc.createElementNS("ns", "name");
		try {
			elem = new ConcreteXliffElementImpl("name", xmlElem);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
	}

	@Test
	public void testGetClearXliffAttribute() {
		ConcreteXliffElementImpl elem = new ConcreteXliffElementImpl("name");
		elem.setAttribute(new ConcreteAttributeImpl("ns", null, "name", "value"));
		elem.setAttribute(new ConcreteXliffAttributeImpl("datatype", "plaintext"));
		
		assertEquals("plaintext", elem.getXliffAttribute("datatype").getValue());
		assertNull(elem.getXliffAttribute("name"));
		
		elem.clearXliffAttribute("datatype");
		assertNull(elem.getXliffAttribute("datatype"));
		assertEquals("value", elem.getAttribute("ns", "name").getValue());		
	}

	@Test
	public void testGetNonXliffAttributes() {
		ConcreteXliffElementImpl elem = new ConcreteXliffElementImpl("name");
		elem.setAttribute(new NonXliffAttributeImpl("ns", null, "name", "value"));
		elem.setAttribute(new ConcreteXliffAttributeImpl("datatype", "plaintext"));
		
		Collection<NonXliffAttribute> nonXliffAttributes = elem.getNonXliffAttributes();
		assertEquals(new Integer(1), new Integer(nonXliffAttributes.size()));
		NonXliffAttribute attr = nonXliffAttributes.iterator().next();
		assertEquals("value", attr.getValue());
	}

	@Test
	public void testIsXliffElementNode() {
		Document doc = Utils.createDocument();
		Text text = doc.createTextNode("abc");
		Element xliffElem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		Element nonXliffElem = doc.createElementNS("ns", "name");
		assertFalse(XliffElementImpl.isXliffElement(text));
		assertTrue(XliffElementImpl.isXliffElement(xliffElem));
		assertFalse(XliffElementImpl.isXliffElement(nonXliffElem));
	}

	@Test
	public void testIsNonXliffElement() {
		Document doc = Utils.createDocument();
		Text text = doc.createTextNode("abc");
		Element xliffElem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		Element nonXliffElem = doc.createElementNS("ns", "name");
		assertFalse(XliffElementImpl.isNonXliffElement(text));
		assertFalse(XliffElementImpl.isNonXliffElement(xliffElem));
		assertTrue(XliffElementImpl.isNonXliffElement(nonXliffElem));
	}

	@Test
	public void testIsXliffElementNodeString() {
		Document doc = Utils.createDocument();
		Text text = doc.createTextNode("abc");
		Element xliffElem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		Element xliffElem2 = doc.createElementNS(XLIFF_12_NAMESPACE, "name2");
		Element nonXliffElem = doc.createElementNS("ns", "name");
		assertFalse(XliffElementImpl.isXliffElement(text, "name"));
		assertTrue(XliffElementImpl.isXliffElement(xliffElem, "name"));
		assertFalse(XliffElementImpl.isXliffElement(xliffElem2, "name"));
		assertFalse(XliffElementImpl.isXliffElement(nonXliffElem, "name"));
	}

}
