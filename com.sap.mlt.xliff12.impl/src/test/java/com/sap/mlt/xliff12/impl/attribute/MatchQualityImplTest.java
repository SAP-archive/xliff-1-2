package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatchQualityImplTest {

	@Test
	public void testJobIdImpl() {
		MatchQualityImpl attr = new MatchQualityImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
