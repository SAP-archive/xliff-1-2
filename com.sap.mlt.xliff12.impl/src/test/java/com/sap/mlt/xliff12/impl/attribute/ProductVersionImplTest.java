package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductVersionImplTest {

	@Test
	public void testProductVersionImpl() {
		ProductVersionImpl attr = new ProductVersionImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
