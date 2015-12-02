package com.sap.mlt.xliff12.impl.rfc4646.enums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

public class LanguageTest {

	@Test
	public void testGetIsDeprecatedAndPreferredValue() {
		for (Language lang : Language.values()) {
			if (lang.isDeprecated()) {
				assertNotNull(lang.getDeprecated());
			} else {
				assertNull(lang.getDeprecated());
				assertNull(lang.getPreferredValue());
			}
		}
	}
	
	@Test
	public void testGetPreferred() {
		for (Language lang : Language.values()) {
			assertNotNull(lang.getPreferred());
		}
	}

	@Test
	public void testGetSuppressScript() {
		for (Language lang : Language.values()) {
			assertNull(lang.getSuppressScript());
		}
	}

	@Test
	public void testGetDescription() {
		for (Language lang : Language.values()) {
			assertNotNull(lang.getDescription());
		}
	}

	@Test
	public void testGetDescriptions() {
		for (Language lang : Language.values()) {
			String[] descs = lang.getDescriptions();
			assertNotNull(descs);
			assertTrue(descs.length > 0);
			for (String desc : descs) {
				assertNotNull(desc);
			}
		}
	}

	@Test
	public void testNewSubtagAndValueOf() {
		Subtag nullSubtag = null;
		assertNull(Language.valueOf(nullSubtag));
		for (Language lang : Language.values()) {
			Subtag subtag = lang.newSubtag();
			assertNotNull(subtag);
			Language l = Language.valueOf(subtag);
			assertNotNull(l);
			assertSame(lang, l);
		}
		try {
			Language.valueOf(Subtag.newWildcard());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
