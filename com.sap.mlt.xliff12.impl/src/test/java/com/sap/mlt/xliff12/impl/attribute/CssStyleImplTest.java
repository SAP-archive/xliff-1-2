package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CssStyleImplTest {

	@Test
	public void testCssStyleImpl() {
		CssStyleImpl attr = new CssStyleImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
