package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolCompanyImplTest {

	@Test
	public void testToolCompanyImpl() {
		ToolCompanyImpl attr = new ToolCompanyImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
