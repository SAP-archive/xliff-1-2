package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactPhoneImplTest {

	@Test
	public void testCotactPhoneImpl() {
		ContactPhoneImpl attr = new ContactPhoneImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
