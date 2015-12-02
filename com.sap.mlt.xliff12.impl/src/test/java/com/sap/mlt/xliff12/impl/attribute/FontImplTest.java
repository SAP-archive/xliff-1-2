package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FontImplTest {

	@Test
	public void testFontImpl() {
		FontImpl attr = new FontImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
