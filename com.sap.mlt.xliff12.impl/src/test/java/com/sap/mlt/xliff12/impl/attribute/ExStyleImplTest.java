package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExStyleImplTest {

	@Test
	public void testExStyleImpl() {
		ExStyleImpl attr = new ExStyleImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
