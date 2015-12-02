package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.State;

public class StateImplTest {

	@Test
	public void testStateImplValue() {
		StateImpl attr = new StateImpl(State.Value.NEEDS_L10N);
		assertEquals(State.Value.NEEDS_L10N, attr.getEnumValue());
	}

	@Test
	public void testStateImplString() {
		StateImpl attr = new StateImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
