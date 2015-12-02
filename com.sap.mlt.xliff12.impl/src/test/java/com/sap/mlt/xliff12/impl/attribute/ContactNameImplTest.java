package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactNameImplTest {

	@Test
	public void testCotactNameImpl() {
		ContactNameImpl attr = new ContactNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
