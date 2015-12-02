package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.AltTransType;

public class AltTransTypeImplTest {

	@Test
	public void testAltTransTypeImplValue() {
		AltTransTypeImpl attr = new AltTransTypeImpl(AltTransType.Value.PROPOSAL);
		assertEquals(AltTransType.Value.PROPOSAL, attr.getEnumValue());
	}

	@Test
	public void testAltTransTypeImplString() {
		AltTransTypeImpl attr = new AltTransTypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
