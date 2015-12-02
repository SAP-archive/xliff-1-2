package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Test;

public class TargetLanguageImplTest {

	@Test
	public void testTargetLanguageImplString() {
		TargetLanguageImpl attr = new TargetLanguageImpl("en");
		assertEquals("en", attr.getValue());

		try {
			attr = new TargetLanguageImpl("abcd");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testTargetLanguageImplLocale() {
		TargetLanguageImpl attr = new TargetLanguageImpl(Locale.US);
		assertEquals("en-US", attr.getValue());
		assertEquals(Locale.US, attr.getLocale());

		try {
			attr = new TargetLanguageImpl(new Locale("abcd"));
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
