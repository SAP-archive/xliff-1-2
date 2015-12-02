package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HrefImplTest {

	@Test
	public void testHrefImpl() {
		HrefImpl attr = new HrefImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
