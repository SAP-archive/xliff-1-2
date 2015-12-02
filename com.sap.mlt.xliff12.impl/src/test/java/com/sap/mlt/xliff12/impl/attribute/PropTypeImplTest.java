package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropTypeImplTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testPropTypeImpl() {
		PropTypeImpl attr = new PropTypeImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
