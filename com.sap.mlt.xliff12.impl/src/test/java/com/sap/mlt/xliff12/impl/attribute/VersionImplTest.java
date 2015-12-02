package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Version;

public class VersionImplTest {

	@Test
	public void testVersionImpl() {
		VersionImpl attr = new VersionImpl(Version.Value.V1_2);
		assertEquals(Version.Value.V1_2, attr.getEnumValue());
	}

}
