package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompanyNameImplTest {

	@Test
	public void testCompanyNameImpl() {
		CompanyNameImpl attr = new CompanyNameImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
