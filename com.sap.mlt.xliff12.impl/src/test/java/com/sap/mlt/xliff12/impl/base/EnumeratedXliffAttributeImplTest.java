package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumeratedXliffAttributeImplTest {

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testEnumeratedXliffAttributeImpl() {
		ConcreteEnumeratedXliffAttributeImpl attr = new ConcreteEnumeratedXliffAttributeImpl(
				"name", ConcreteEnumeratedXliffAttributeImpl.Value.ENUM1);
		assertEquals(XLIFF_12_NAMESPACE, attr.getNamespaceUri());
		assertEquals("name", attr.getName());
		assertEquals("enum1", attr.getValue());
		assertEquals(ConcreteEnumeratedXliffAttributeImpl.Value.ENUM1, attr.getEnumValue());
	}

}
