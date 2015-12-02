package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FromImplTest {

	@Test
	public void testFormImpl() {
		FromImpl attr = new FromImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
