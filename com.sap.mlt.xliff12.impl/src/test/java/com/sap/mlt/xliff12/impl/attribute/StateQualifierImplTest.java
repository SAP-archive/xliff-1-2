package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.StateQualifier;

public class StateQualifierImplTest {

	@Test
	public void testStateQualifierImplValue() {
		StateQualifierImpl attr = new StateQualifierImpl(
				StateQualifier.Value.LEVERAGED_MT);
		assertEquals(StateQualifier.Value.LEVERAGED_MT, attr.getEnumValue());
	}

	@Test
	public void testStateQualifierImplString() {
		StateQualifierImpl attr = new StateQualifierImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
