package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuildNumImplTest  {

	@Test
	public void testBuildNumImpl() {
		BuildNumImpl buildNum = new BuildNumImpl("3456");
		assertEquals("3456", buildNum.getValue());
	}

}
