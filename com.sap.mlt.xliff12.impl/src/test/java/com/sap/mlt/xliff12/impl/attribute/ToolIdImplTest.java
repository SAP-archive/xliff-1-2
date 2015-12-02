package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolIdImplTest {

	@Test
	public void testToolIdImpl() {
		ToolIdImpl attr = new ToolIdImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
