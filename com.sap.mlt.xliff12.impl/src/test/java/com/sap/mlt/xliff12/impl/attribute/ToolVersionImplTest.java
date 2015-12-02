package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolVersionImplTest {

	@Test
	public void testToolVersionImpl() {
		ToolVersionImpl attr = new ToolVersionImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
