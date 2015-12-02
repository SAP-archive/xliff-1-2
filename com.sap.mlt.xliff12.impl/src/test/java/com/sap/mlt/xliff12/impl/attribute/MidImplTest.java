package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MidImplTest {

	@Test
	public void testMidImpl() {
		MidImpl attr = new MidImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
