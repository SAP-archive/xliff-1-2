package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameImplTest {

	@Test
	public void testNameImpl() {
		NameImpl attr = new NameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
