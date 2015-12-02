package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.EquivTrans;

public class EquivTransImplTest {

	@Test
	public void testEquivTransImpl() {
		EquivTransImpl attr = new EquivTransImpl(EquivTrans.Value.YES);
		assertEquals(EquivTrans.Value.YES, attr.getEnumValue());
	}

}
