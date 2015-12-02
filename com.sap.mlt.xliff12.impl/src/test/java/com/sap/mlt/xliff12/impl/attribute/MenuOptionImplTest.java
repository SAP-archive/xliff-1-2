package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuOptionImplTest {

	@Test
	public void testMenuOptionImpl() {
		MenuOptionImpl attr = new MenuOptionImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
