package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquivTextImplTest {

	@Test
	public void testEquivTextImpl() {
		EquivTextImpl attr = new EquivTextImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
