package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class XidImplTest {

	@Test
	public void testXidImpl() {
		XidImpl attr = new XidImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
