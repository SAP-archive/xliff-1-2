package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactEmailImplTest {

	@Test
	public void testCotactEmailImpl() {
		ContactEmailImpl attr = new ContactEmailImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
