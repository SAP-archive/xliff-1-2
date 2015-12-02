package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.MatchMandatory;

public class MatchMandatoryImplTest {

	@Test
	public void testMatchMandatoryImpl() {
		MatchMandatoryImpl attr = new MatchMandatoryImpl(
				MatchMandatory.Value.YES);
		assertEquals(MatchMandatory.Value.YES, attr.getEnumValue());
	}

}
