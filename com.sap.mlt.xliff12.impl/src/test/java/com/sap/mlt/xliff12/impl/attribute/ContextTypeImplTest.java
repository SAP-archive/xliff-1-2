package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.ContextType;

public class ContextTypeImplTest {

	@Test
	public void testContextTypeImplValue() {
		ContextTypeImpl attr = new ContextTypeImpl(ContextType.Value.LINENUMBER);
		assertEquals(ContextType.Value.LINENUMBER, attr.getEnumValue());
	}

	@Test
	public void testContextTypeImplString() {
		ContextTypeImpl attr = new ContextTypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
