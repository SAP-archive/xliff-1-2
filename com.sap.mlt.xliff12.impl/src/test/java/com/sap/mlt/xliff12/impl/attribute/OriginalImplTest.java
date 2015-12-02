package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OriginalImplTest {

	@Test
	public void testOriginalImpl() {
		OriginalImpl attr = new OriginalImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
