package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Test;

public class XmlLangImplTest {

	@Test
	public void testXmlLangImplString() {
		XmlLangImpl attr = new XmlLangImpl("en");
		assertEquals("en", attr.getValue());

		try {
			attr = new XmlLangImpl("abcd");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testXmlLangImplLocale() {
		XmlLangImpl attr = new XmlLangImpl(Locale.US);
		assertEquals("en-US", attr.getValue());
		assertEquals(Locale.US, attr.getLocale());

		try {
			attr = new XmlLangImpl(new Locale("abcd"));
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
