package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinHeightImplTest {

	@Test
	public void testMinWidthImpl() {
		MinWidthImpl attr = new MinWidthImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
