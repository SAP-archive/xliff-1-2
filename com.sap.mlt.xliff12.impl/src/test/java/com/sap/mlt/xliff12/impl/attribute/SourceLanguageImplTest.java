package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Test;

public class SourceLanguageImplTest {

	@Test
	public void testSourceLanguageImplString() {
		SourceLanguageImpl attr = new SourceLanguageImpl("en");
		assertEquals("en", attr.getValue());

		try {
			attr = new SourceLanguageImpl("abcd");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testSourceLanguageImplLocale() {
		SourceLanguageImpl attr = new SourceLanguageImpl(Locale.US);
		assertEquals("en-US", attr.getValue());
		assertEquals(Locale.US, attr.getLocale());

		try {
			attr = new SourceLanguageImpl(new Locale("abcd"));
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
