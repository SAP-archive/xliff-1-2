package com.sap.mlt.xliff12.impl.rfc4646.enums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

public class VariantTest {

	@Test
	public void testGetIsDeprecated() {
		for (Variant variant : Variant.values()) {
			if (variant.isDeprecated()) {
				assertNotNull(variant.getDeprecated());
			} else {
				assertNull(variant.getDeprecated());
			}
		}
	}

	@Test
	public void testGetPreferredValue() {
		for (Variant variant : Variant.values()) {
			if (!variant.isDeprecated()) {
				assertNull(variant.getPreferredValue());
			}
		}
	}

	@Test
	public void testGetPreferred() {
		for (Variant variant : Variant.values()) {
			assertNotNull(variant.getPreferred());
		}
	}

	@Test
	public void testGetPrefix() {
		for (Variant variant : Variant.values()) {
			variant.getPrefix();
		}
	}

	@Test
	public void testGetPrefixes() {
		for (Variant variant : Variant.values()) {
			String[] prefixes = variant.getPrefixes();
			assertNotNull(prefixes);
			if (prefixes.length > 1) {
				for (String prefix : prefixes) {
					assertNotNull(prefix);
				}
			}
		}
	}

	@Test
	public void testGetDescription() {
		for (Variant variant : Variant.values()) {
			assertNotNull(variant.getDescription());
		}
	}

	@Test
	public void testGetDescriptions() {
		for (Variant variant : Variant.values()) {
			String[] descs = variant.getDescriptions();
			assertNotNull(descs);
			assertTrue(descs.length > 0);
			for (String desc : descs) {
				assertNotNull(desc);
			}
		}
	}

	@Test
	public void testValueOf() {
		Subtag nullSubtag = null;
		assertNull(Variant.valueOf(nullSubtag));
		for (Variant variant : Variant.values()) {
			Subtag subtag = variant.newSubtag();
			assertNotNull(subtag);
			Variant v = Variant.valueOf(subtag);
			assertNotNull(v);
			assertSame(variant, v);
		}
		try {
			Variant.valueOf(Subtag.newWildcard());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
