package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxWidthImplTest {

	@Test
	public void testMaxWidthImpl() {
		MaxWidthImpl attr = new MaxWidthImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
