package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Translate;

public class TranslateImplTest {

	@Test
	public void testTranslateImpl() {
		TranslateImpl attr = new TranslateImpl(Translate.Value.NO);
		assertEquals(Translate.Value.NO, attr.getEnumValue());
	}

}
