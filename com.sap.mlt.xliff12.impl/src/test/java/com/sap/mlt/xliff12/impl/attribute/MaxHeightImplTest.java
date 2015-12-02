package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxHeightImplTest {

	@Test
	public void testMaxHeightImpl() {
		MaxHeightImpl attr = new MaxHeightImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
