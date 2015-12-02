package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Approved;

public class ApprovedImplTest {

	@Test
	public void testApprovedImpl() {
		ApprovedImpl attr = new ApprovedImpl(Approved.Value.NO);
		assertEquals(Approved.Value.NO, attr.getEnumValue());
	}

}
