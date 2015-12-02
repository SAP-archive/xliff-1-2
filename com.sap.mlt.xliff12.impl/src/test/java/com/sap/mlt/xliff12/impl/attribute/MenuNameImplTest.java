package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuNameImplTest {

	@Test
	public void testMenuNameImpl() {
		MenuNameImpl attr = new MenuNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
