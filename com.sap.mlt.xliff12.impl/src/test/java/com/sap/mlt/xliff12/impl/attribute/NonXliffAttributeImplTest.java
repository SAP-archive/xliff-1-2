package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonXliffAttributeImplTest {

	static private final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
	
	static private final String XMLNS_NAMESPACE = "http://www.w3.org/2000/xmlns/";

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testNonXliffAttributeImpl() {
		NonXliffAttributeImpl attr = new NonXliffAttributeImpl("ns", "pre", "name", "value");
		assertEquals("ns", attr.getNamespaceUri());
		assertEquals("pre", attr.getPrefix());
		assertEquals("name", attr.getName());
		assertEquals("value", attr.getValue());
		
		attr = new NonXliffAttributeImpl("ns", null, "name", "value");
		assertEquals("ns", attr.getNamespaceUri());
		assertNull(attr.getPrefix());
		assertEquals("name", attr.getName());
		assertEquals("value", attr.getValue());

		try {
			attr = new NonXliffAttributeImpl(XML_NAMESPACE, "pre", "name", "value");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		try {
			attr = new NonXliffAttributeImpl(XMLNS_NAMESPACE, "pre", "name", "value");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		try {
			attr = new NonXliffAttributeImpl(XLIFF_12_NAMESPACE, "pre", "name", "value");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
