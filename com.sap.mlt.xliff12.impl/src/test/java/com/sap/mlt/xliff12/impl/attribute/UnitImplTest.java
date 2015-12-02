package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Unit;

public class UnitImplTest {

	@Test
	public void testUnitImplValue() {
		UnitImpl attr = new UnitImpl(Unit.Value.GLYPH);
		assertEquals(Unit.Value.GLYPH, attr.getEnumValue());
	}

	@Test
	public void testUnitImplString() {
		UnitImpl attr = new UnitImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
