package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelpIdImplTest {

	@Test
	public void testHelpIdImpl() {
		HelpIdImpl attr = new HelpIdImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
