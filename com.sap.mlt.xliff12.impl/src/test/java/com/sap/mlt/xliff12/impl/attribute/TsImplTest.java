package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TsImplTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testTsImpl() {
		TsImpl attr = new TsImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
