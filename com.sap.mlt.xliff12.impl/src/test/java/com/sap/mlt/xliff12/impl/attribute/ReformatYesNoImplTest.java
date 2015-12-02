package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReformatYesNoImplTest {

	@Test
	public void testReformatYesNo() {
		assertTrue(new ReformatYesNoImpl(true).canAllPropertiesBeReformatted());
		assertFalse(new ReformatYesNoImpl(true)
				.shouldNoPropertiesBeReformatted());
		assertTrue(new ReformatYesNoImpl(true).getEnumValues().isEmpty());
		assertTrue(new ReformatYesNoImpl(true).getXtendValues().isEmpty());

		assertFalse(new ReformatYesNoImpl(false)
				.canAllPropertiesBeReformatted());
		assertTrue(new ReformatYesNoImpl(false)
				.shouldNoPropertiesBeReformatted());
		assertTrue(new ReformatYesNoImpl(false).getEnumValues().isEmpty());
		assertTrue(new ReformatYesNoImpl(false).getXtendValues().isEmpty());
	}

}
