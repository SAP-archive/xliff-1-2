package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhaseNameImplTest {

	@Test
	public void testPhaseNameImpl() {
		PhaseNameImpl attr = new PhaseNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
