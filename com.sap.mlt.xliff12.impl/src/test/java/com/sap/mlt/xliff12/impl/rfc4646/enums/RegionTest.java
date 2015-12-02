package com.sap.mlt.xliff12.impl.rfc4646.enums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

public class RegionTest {

	@Test
	public void testGetIsDeprecated() {
		for (Region region : Region.values()) {
			if (region.isDeprecated()) {
				assertNotNull(region.getDeprecated());
			} else {
				assertNull(region.getDeprecated());
			}
		}
	}

	@Test
	public void testPreferred() {
		for (Region region : Region.values()) {
			assertNotNull(region.getPreferred());
			if (region.getPreferredValue() != null) {
				assertTrue(region.isDeprecated());
			}
		}
	}

	@Test
	public void testGetDescription() {
		for (Region region : Region.values()) {
			assertNotNull(region.getDescription());
		}
	}

	@Test
	public void testGetDescriptions() {
		for (Region region : Region.values()) {
			String[] descs = region.getDescriptions();
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
		assertNull(Region.valueOf(nullSubtag));
		for (Region region : Region.values()) {
			Subtag subtag = region.newSubtag();
			assertNotNull(subtag);
			Region r = Region.valueOf(subtag);
			assertNotNull(r);
			assertSame(region, r);
		}
		try {
			Region.valueOf(Subtag.newWildcard());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
