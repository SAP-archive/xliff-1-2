package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StyleImplTest {

	@Test
	public void testStyleImpl() {
		StyleImpl attr = new StyleImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
