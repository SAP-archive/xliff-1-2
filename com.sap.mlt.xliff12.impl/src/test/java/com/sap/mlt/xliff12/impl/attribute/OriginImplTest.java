package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OriginImplTest {

	@Test
	public void testOriginImpl() {
		OriginImpl attr = new OriginImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
