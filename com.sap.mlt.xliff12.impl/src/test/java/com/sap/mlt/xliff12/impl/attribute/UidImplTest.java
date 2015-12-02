package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UidImplTest {

	@Test
	public void testUidImpl() {
		UidImpl attr = new UidImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
