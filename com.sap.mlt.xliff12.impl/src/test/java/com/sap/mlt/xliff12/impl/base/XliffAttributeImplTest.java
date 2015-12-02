package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class XliffAttributeImplTest {

	private static final String XLIFF_NS = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testXliffAttributeImpl() {
		ConcreteXliffAttributeImpl attr = new ConcreteXliffAttributeImpl("name", "value");
		assertEquals(XLIFF_NS, attr.getNamespaceUri());
		assertNull(attr.getPrefix());
		assertEquals("name", attr.getName());
		assertEquals("value", attr.getValue());
	}
	
	private class ConcreteXliffAttributeImpl extends XliffAttributeImpl {
		public ConcreteXliffAttributeImpl(String name, String value) {
			super(name, value);
		}
	}

}
