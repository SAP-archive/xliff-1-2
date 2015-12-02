package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolImplTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testToolImpl() {
		ToolImpl attr = new ToolImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
