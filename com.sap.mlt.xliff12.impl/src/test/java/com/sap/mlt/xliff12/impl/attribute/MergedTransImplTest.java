package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.MergedTrans;

public class MergedTransImplTest {

	@Test
	public void testMergedTransImpl() {
		MergedTransImpl attr = new MergedTransImpl(MergedTrans.Value.YES);
		assertEquals(MergedTrans.Value.YES, attr.getEnumValue());
	}

}
