package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrcImplTest {

	@Test
	public void testCrcImpl() {
		CrcImpl attr = new CrcImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
