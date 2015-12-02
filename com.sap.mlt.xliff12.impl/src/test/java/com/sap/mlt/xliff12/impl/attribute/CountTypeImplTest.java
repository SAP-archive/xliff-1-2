package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.CountType;

public class CountTypeImplTest {

	@Test
	public void testCountTypeImplValue() {
		CountTypeImpl attr = new CountTypeImpl(CountType.Value.CAPTION);
		assertEquals(CountType.Value.CAPTION, attr.getEnumValue());
	}

	@Test
	public void testCountTypeImplString() {
		CountTypeImpl attr = new CountTypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
