package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolNameImplTest {

	@Test
	public void testToolNameImpl() {
		ToolNameImpl attr = new ToolNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
