package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Mtype;

public class MtypeImplTest {

	@Test
	public void testMtypeImplValue() {
		MtypeImpl attr = new MtypeImpl(Mtype.Value.ACRONYM);
		assertEquals(Mtype.Value.ACRONYM, attr.getEnumValue());
	}

	@Test
	public void testMtypeImplString() {
		MtypeImpl attr = new MtypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
