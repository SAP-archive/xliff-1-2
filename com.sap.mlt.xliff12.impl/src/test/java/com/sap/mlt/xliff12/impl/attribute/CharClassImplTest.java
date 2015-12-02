package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharClassImplTest {

	@Test
	public void testCharClassImpl() {
		CharClassImpl attr = new CharClassImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
