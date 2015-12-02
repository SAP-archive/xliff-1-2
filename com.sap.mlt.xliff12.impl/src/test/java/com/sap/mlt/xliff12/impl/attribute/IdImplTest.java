package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IdImplTest {

	@Test
	public void testIdImpl() {
		IdImpl attr = new IdImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
