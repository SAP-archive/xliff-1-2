package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PriorityImplTest {

	@Test
	public void testPriorityImpl() {
		PriorityImpl attr = new PriorityImpl(4);
		assertEquals(new Integer(4), new Integer(attr.getPriority()));
		
		try {
			attr = new PriorityImpl(0);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		try {
			attr = new PriorityImpl(11);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
