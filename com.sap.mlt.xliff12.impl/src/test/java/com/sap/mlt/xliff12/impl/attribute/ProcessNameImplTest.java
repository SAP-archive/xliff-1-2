package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProcessNameImplTest {

	@Test
	public void testProcessNameImpl() {
		ProcessNameImpl attr = new ProcessNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
