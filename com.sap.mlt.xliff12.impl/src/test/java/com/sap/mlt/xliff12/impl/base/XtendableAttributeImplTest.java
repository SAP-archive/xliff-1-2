package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class XtendableAttributeImplTest {

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testXTendableAttributeImplStringEnumOfQ() {
		ConcreteXTendableAttributeImpl attr = new ConcreteXTendableAttributeImpl(
				"name", ConcreteXTendableAttributeImpl.Value.ENUM1);
		assertEquals(XLIFF_12_NAMESPACE, attr.getNamespaceUri());
		assertEquals("name", attr.getName());
		assertEquals("enum1", attr.getValue());
		assertFalse(attr.isXTended());
		assertEquals(attr.getEnumValue(), ConcreteXTendableAttributeImpl.Value.ENUM1);
		assertNull(attr.getXtendValue());
	}

	@Test
	public void testXTendableAttributeImplStringString() {
		ConcreteXTendableAttributeImpl attr = new ConcreteXTendableAttributeImpl(
				"name", "xtend");
		assertEquals(XLIFF_12_NAMESPACE, attr.getNamespaceUri());
		assertEquals("name", attr.getName());
		assertEquals("x-xtend", attr.getValue());
		assertTrue(attr.isXTended());
		assertNull(attr.getEnumValue());
		assertEquals("xtend", attr.getXtendValue());
	}

}
