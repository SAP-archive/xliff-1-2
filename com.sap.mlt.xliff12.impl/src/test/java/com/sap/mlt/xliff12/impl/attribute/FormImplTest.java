package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FormImplTest {

	@Test
	public void testFormImpl() {
		FormImpl attr = new FormImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
