package com.sap.mlt.xliff12.impl.rfc4646;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag.Type;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Language;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Region;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Script;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Variant;

public class LangTest {

	@Test
	public void testLang() {
		Lang lang = new Lang();
		assertEquals(lang.getLocale(), Locale.getDefault());
	}

	@Test
	public void testLangLocale() {
		Lang lang = new Lang(new Locale("fr", "CA"));
		assertEquals(lang.getLocale(), new Locale("fr", "CA"));

		lang = new Lang(new Locale("ab", "CDEFGHIJKLMNOPQ"));
		assertFalse(lang.isValid());
	}

	@Test
	public void testLangString() {
		Lang lang = new Lang("en-US");
		assertEquals("en", lang.getLanguage().toString());
		assertEquals("US", lang.getRegion().toString());
	}

	@Test
	public void testLangSubtag() {
		Subtag lang = new Subtag(Language.EN);

		Subtag langRegion = new Subtag(Language.EN);
		langRegion.setNext(new Subtag(Region.US));

		Subtag langRegionVariant = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		langRegionVariant.setNext(region);
		region.setNext(new Subtag(Variant.FONIPA));

		Lang lang1 = new Lang(lang);
		assertEquals("en", lang1.getLanguage().toString());

		Lang lang2 = new Lang(langRegion);
		assertEquals("en", lang2.getLanguage().toString());
		assertEquals("US", lang2.getRegion().toString());

		Lang lang3 = new Lang(langRegionVariant);
		assertEquals("en", lang3.getLanguage().toString());
		assertEquals("US", lang3.getRegion().toString());
		assertEquals("fonipa", lang3.getVariant().toString());
	}

	@Test
	public void testGetLanguage() {
		Lang lang = new Lang("de");
		assertEquals(new Subtag(Language.DE), lang.getLanguage());
	}

	@Test
	public void testGetLocale() {
		Lang lang = new Lang("en-US");
		assertEquals(Locale.US, lang.getLocale());
	}

	@Test
	public void testGetExtLang() {
		Lang lang = new Lang("en-US");
		assertNull(lang.getExtLang());
		lang = new Lang("en");
		assertNull(lang.getExtLang());
	}

	@Test
	public void testGetScript() {
		Lang lang = new Lang("en");
		assertNull(lang.getScript());
		lang = new Lang("en-US");
		assertNull(lang.getScript());
		lang = new Lang("en-Latn");
		assertEquals(new Subtag(Script.LATN), lang.getScript());
	}

	@Test
	public void testGetRegion() {
		Lang lang = new Lang("en");
		assertNull(lang.getRegion());
		lang = new Lang("en-US");
		assertEquals(new Subtag(Region.US), lang.getRegion());
		lang = new Lang("en-fonipa");
		assertNull(lang.getRegion());
	}

	@Test
	public void testGetVariant() {
		Lang lang = new Lang("en");
		assertNull(lang.getVariant());
		lang = new Lang("en-fonipa");
		assertEquals(new Subtag(Variant.FONIPA), lang.getVariant());
		lang = new Lang(new Subtag(Type.EXTENSION, "AB"));
		assertNull(lang.getVariant());
	}

	@Test
	public void testGetExtension() {
		Lang lang = new Lang("en");
		assertNull(lang.getExtension());
		lang.getLanguage().setNext(new Subtag(Type.EXTENSION, "AB"));
		assertEquals(new Subtag(Language.EN), lang.getExtension());
	}

	// @Test
	// public void testGetPrivateUse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testAsRange() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testClone() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testCanonicalize() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testIsDeprecated() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetParent() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testIsChildOf() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testIsParentOf() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testParse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFromLocale() {
	// fail("Not yet implemented");
	// }

}
