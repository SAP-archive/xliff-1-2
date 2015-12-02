package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MimeTypeImplTest {

	@Test
	public void testMimeTypeImpl() {
		MimeTypeImpl attr = new MimeTypeImpl("text/xml");
		assertEquals("text/xml", attr.getValue());
	}

}
