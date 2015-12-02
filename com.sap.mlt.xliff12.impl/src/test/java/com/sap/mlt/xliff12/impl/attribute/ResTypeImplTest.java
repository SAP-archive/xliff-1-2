package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.ResType;

public class ResTypeImplTest {

	@Test
	public void testResTypeImplValue() {
		ResTypeImpl attr = new ResTypeImpl(ResType.Value.CAPTION);
		assertEquals(ResType.Value.CAPTION, attr.getEnumValue());
	}

	@Test
	public void testDataTypeImplString() {
		ResTypeImpl attr = new ResTypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
