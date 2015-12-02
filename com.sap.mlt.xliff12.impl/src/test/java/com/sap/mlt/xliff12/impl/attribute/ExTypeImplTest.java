package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExTypeImplTest {

	@Test
	public void testExTypeImpl() {
		ExTypeImpl attr = new ExTypeImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
