package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.CtypePh;

public class CtypePhImplTest {

	@Test
	public void testCtypePhImplValue() {
		CtypePhImpl attr = new CtypePhImpl(CtypePh.Value.LB);
		assertEquals(CtypePh.Value.LB, attr.getEnumValue());
	}

	@Test
	public void testCtypePhImplString() {
		CtypePhImpl attr = new CtypePhImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
