package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RidImplTest {

	@Test
	public void testRidImpl() {
		RidImpl attr = new RidImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
