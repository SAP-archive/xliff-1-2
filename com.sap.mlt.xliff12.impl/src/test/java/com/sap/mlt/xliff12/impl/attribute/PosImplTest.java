package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Pos;

public class PosImplTest {

	@Test
	public void testPosImplValue() {
		PosImpl attr = new PosImpl(Pos.Value.OPEN);
		assertEquals(Pos.Value.OPEN, attr.getEnumValue());
	}


}
