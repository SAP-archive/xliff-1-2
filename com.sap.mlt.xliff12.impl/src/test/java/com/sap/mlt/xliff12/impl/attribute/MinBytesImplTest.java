package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinBytesImplTest {

	@Test
	public void testMinBytesImpl() {
		MinBytesImpl attr = new MinBytesImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
