package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CategoryImplTest {

	@Test
	public void testCategoryImpl() {
		CategoryImpl attr = new CategoryImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
