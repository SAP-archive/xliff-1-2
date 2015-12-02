package com.sap.mlt.xliff12.impl.rfc4646;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag.Type;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Language;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Region;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Script;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Singleton;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Variant;

public class SubTagTest {

	@Test
	public void testHashCode() {
		Subtag langSubtag1 = new Subtag(Language.DE);
		Subtag langSubtag2 = new Subtag(Language.DE);
		assertEquals(new Integer(langSubtag1.hashCode()), new Integer(
				langSubtag2.hashCode()));
		Subtag nullSubtag = new Subtag(null, null);
		nullSubtag.hashCode();
	}

	@Test
	public void testSubtagLanguage() {
		Subtag subtag = new Subtag(Language.DE);
		assertEquals(Type.PRIMARY, subtag.getType());
		assertEquals("de", subtag.getName());
	}

	@Test
	public void testSubtagScript() {
		Subtag subtag = new Subtag(Script.LATN);
		assertEquals(Type.SCRIPT, subtag.getType());
		assertEquals("Latn", subtag.getName());
	}

	@Test
	public void testSubtagRegion() {
		Subtag subtag = new Subtag(Region.DE);
		assertEquals(Type.REGION, subtag.getType());
		assertEquals("DE", subtag.getName());
	}

	@Test
	public void testSubtagVariant() {
		Subtag subtag = new Subtag(Variant.FONIPA);
		assertEquals(Type.VARIANT, subtag.getType());
		assertEquals("fonipa", subtag.getName());
	}

	@Test
	public void testSubtagSingleton() {
		Subtag subtag = new Subtag(Singleton.X);
		assertEquals(Type.SINGLETON, subtag.getType());
		assertEquals("x", subtag.getName());
	}

	@Test
	public void testSubtag() {
		Subtag subtag = new Subtag();
		assertEquals(Type.WILDCARD, subtag.getType());
		assertEquals("*", subtag.getName());
	}

	@Test
	public void testSubtagTypeStringSubtag() {
		Subtag langSubtag = new Subtag(Language.DE);
		Subtag regionSubtag = new Subtag(Type.REGION, "DE", langSubtag);
		assertSame(langSubtag, regionSubtag.getPrevious());
	}

	@Test
	public void testSubtagTypeStringSubtagSubtag() {
		Subtag langSubtag = new Subtag(Language.DE);
		Subtag scriptSubtag = new Subtag(Script.LATN);
		Subtag regionSubtag = new Subtag(Type.REGION, "DE", langSubtag,
				scriptSubtag);
		assertSame(langSubtag, regionSubtag.getPrevious());
		assertSame(scriptSubtag, regionSubtag.getNext());
	}

	@Test
	public void testPreviousNext() {
		Subtag langSubtag = new Subtag(Language.DE);
		Subtag regionSubtag = new Subtag(Region.DE);
		langSubtag.setNext(regionSubtag);
		assertSame(langSubtag, regionSubtag.getPrevious());
		assertSame(regionSubtag, langSubtag.getNext());
	}

	@Test
	public void testEqualsObject() {
		Subtag langSubtag1 = new Subtag(Language.DE);
		Subtag langSubtag2 = new Subtag(Language.DE);
		Subtag langSubtag3 = new Subtag(Language.EN);
		Subtag regionSubtag = new Subtag(Region.DE);
		Subtag wildcardSubtag = new Subtag();
		Subtag nullSubtag = new Subtag(null, null);
		Subtag nullTypeSubtag = new Subtag(null, "de");
		Subtag simpleSubtag = new Subtag(Type.SIMPLE, "de");

		assertFalse(langSubtag1.equals(null));
		assertFalse(langSubtag1.equals(new Object()));
		assertEquals(langSubtag1, langSubtag1);
		assertEquals(langSubtag1, langSubtag2);
		assertFalse(langSubtag1.equals(langSubtag3));
		assertFalse(langSubtag1.equals(regionSubtag));
		assertEquals(langSubtag1, wildcardSubtag);
		assertFalse(nullSubtag.equals(langSubtag1));
		assertFalse(nullTypeSubtag.equals(langSubtag1));
		assertEquals(langSubtag1, simpleSubtag);
	}

	@Test
	public void testClone() {
		Subtag langSubtag = new Subtag(Language.DE);
		Subtag regionSubtag = new Subtag(Region.DE);
		langSubtag.setNext(regionSubtag);
		Subtag clone = langSubtag.clone();
		assertEquals(langSubtag, clone);
		assertNotSame(langSubtag, clone);
		assertEquals(regionSubtag, clone.getNext());
		assertNotSame(regionSubtag, clone.getNext());
	}

	@Test
	public void testIsDeprecated() {
		assertFalse(new Subtag().isDeprecated());
		for (Language lang : Language.values()) {
			Subtag subtag = lang.newSubtag();
			assertEquals(subtag.isDeprecated(), lang.isDeprecated());
		}
		for (Script script : Script.values()) {
			Subtag subtag = script.newSubtag();
			assertEquals(subtag.isDeprecated(), script.isDeprecated());
		}
		for (Region region : Region.values()) {
			Subtag subtag = region.newSubtag();
			assertEquals(subtag.isDeprecated(), region.isDeprecated());
		}
		for (Variant variant : Variant.values()) {
			Subtag subtag = variant.newSubtag();
			assertEquals(subtag.isDeprecated(), variant.isDeprecated());
		}
		for (Singleton singleton : Singleton.values()) {
			Subtag subtag = singleton.newSubtag();
			assertEquals(subtag.isDeprecated(), singleton.isDeprecated());
		}
	}

	@Test
	public void testGetEnum() {
		assertNull(new Subtag().getEnum());
	}

	@Test
	public void testIsValid() {
		Subtag validLang = new Subtag(Language.DE);
		Subtag invalidLang = new Subtag(Type.PRIMARY, "abcd");
		assertTrue(validLang.isValid());
		assertFalse(invalidLang.isValid());

		Subtag validExtension = new Subtag(Type.EXTENSION, "abc");
		Subtag invalidExtension = new Subtag(Type.EXTENSION, "a");
		assertTrue(validExtension.isValid());
		assertFalse(invalidExtension.isValid());

		Subtag validGrandfathered = new Subtag(Type.GRANDFATHERED, "abc-AZ");
		Subtag invalidGrandfathered = new Subtag(Type.GRANDFATHERED, "a");
		assertTrue(validGrandfathered.isValid());
		assertFalse(invalidGrandfathered.isValid());

		Subtag validPrivateUse = new Subtag(Type.PRIVATEUSE, "a2c");
		Subtag invalidPrivateUse = new Subtag(Type.PRIVATEUSE, "a-c");
		assertTrue(validPrivateUse.isValid());
		assertFalse(invalidPrivateUse.isValid());

		Subtag validSingleton = new Subtag(Type.SINGLETON, "a");
		Subtag invalidSingleton = new Subtag(Type.SINGLETON, "ab");
		assertTrue(validSingleton.isValid());
		assertFalse(invalidSingleton.isValid());

		Subtag validWildcard = new Subtag(Type.WILDCARD, "*");
		Subtag invalidWildcard = new Subtag(Type.WILDCARD, "?");
		assertTrue(validWildcard.isValid());
		assertFalse(invalidWildcard.isValid());

		Subtag validSimple = new Subtag(Type.SIMPLE, "abc");
		Subtag invalidSimple = new Subtag(Type.SIMPLE, "abc$");
		assertTrue(validSimple.isValid());
		assertFalse(invalidSimple.isValid());
	}

	@Test
	public void testCanonicalize() {
		Subtag region = new Subtag(Region.DE);
		Subtag lang = new Subtag(Language.IW);
		Subtag script = new Subtag(Script.LATN);
		Subtag variant = new Subtag(Variant.FONIPA);
		Subtag extension = new Subtag(Type.EXTENSION, "abc");

		assertNotNull(region.canonicalize());
		assertNotNull(lang.canonicalize());
		assertNotNull(script.canonicalize());
		assertNotNull(variant.canonicalize());
		assertNotNull(extension.canonicalize());
	}

	@Test
	public void testCompareTo() {
		Subtag lang1 = new Subtag(Language.DE);
		Subtag lang2 = new Subtag(Language.DE);
		Subtag lang3 = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.DE);

		assertTrue(0 == lang1.compareTo(lang1));
		assertTrue(0 == lang1.compareTo(lang2));
		assertTrue(lang1.compareTo(lang3) > 0);
		assertTrue(lang3.compareTo(lang1) < 0);
		assertTrue(lang1.compareTo(region) > 0);
		assertTrue(region.compareTo(lang1) < 0);
	}

}
