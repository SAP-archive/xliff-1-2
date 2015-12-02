package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductNameImplTest {

	@Test
	public void testProductNameImpl() {
		ProductNameImpl attr = new ProductNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
