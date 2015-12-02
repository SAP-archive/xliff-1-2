package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExtraDataImplTest {

	@Test
	public void testExtraDataImpl() {
		ExtraDataImpl attr = new ExtraDataImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
