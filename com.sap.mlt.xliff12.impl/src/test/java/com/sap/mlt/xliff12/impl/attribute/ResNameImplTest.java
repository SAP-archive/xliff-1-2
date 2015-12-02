package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResNameImplTest {

	@Test
	public void testResNameImpl() {
		ResNameImpl attr = new ResNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
