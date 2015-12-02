package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Reformat;

public class ReformatImplTest {

	@Test
	public void testReformatImpl() {
		ArrayList<Reformat.Value> values = new ArrayList<Reformat.Value>();
		values.add(Reformat.Value.FONT);
		ReformatImpl attr = new ReformatImpl(values, new ArrayList<String>());
		assertEquals(values, attr.getEnumValues());
		assertFalse(attr.canAllPropertiesBeReformatted());
		assertFalse(attr.shouldNoPropertiesBeReformatted());
	}

}
