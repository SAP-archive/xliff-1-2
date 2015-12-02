package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.CtypeDelim;

public class CtypeDelimImplTest {

	@Test
	public void testCtypeDelimImplValue() {
		CtypeDelimImpl attr = new CtypeDelimImpl(CtypeDelim.Value.LINK);
		assertEquals(CtypeDelim.Value.LINK, attr.getEnumValue());
	}

	@Test
	public void testCtypeDelimImplString() {
		CtypeDelimImpl attr = new CtypeDelimImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
