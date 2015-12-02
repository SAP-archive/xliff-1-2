package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuImplTest {

	@Test
	public void testMenuImpl() {
		MenuImpl attr = new MenuImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
