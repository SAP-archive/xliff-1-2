package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.SizeUnit;

public class SizeUnitImplTest {

	@Test
	public void testSizeUnitImplValue() {
		SizeUnitImpl attr = new SizeUnitImpl(SizeUnit.Value.COL);
		assertEquals(SizeUnit.Value.COL, attr.getEnumValue());
	}

	@Test
	public void testDataTypeImplString() {
		SizeUnitImpl attr = new SizeUnitImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
