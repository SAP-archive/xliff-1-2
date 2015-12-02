package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JobIdImplTest {

	@Test
	public void testJobIdImpl() {
		JobIdImpl attr = new JobIdImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
