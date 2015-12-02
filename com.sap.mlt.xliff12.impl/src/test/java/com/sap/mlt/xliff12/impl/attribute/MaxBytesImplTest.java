package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxBytesImplTest {

	@Test
	public void testMaxBytesImpl() {
		MaxBytesImpl attr = new MaxBytesImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
