package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Purpose;

public class PurposeImplTest {

	@Test
	public void testPurposeImpl() {
		ArrayList<Purpose.Value> values = new ArrayList<Purpose.Value>();
		values.add(Purpose.Value.LOCATION);
		PurposeImpl attr = new PurposeImpl(values, new ArrayList<String>());
		assertEquals(values, attr.getEnumValues());
	}

}
