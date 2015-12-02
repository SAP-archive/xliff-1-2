package com.sap.mlt.xliff12.impl.rfc4646.enums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

public class SingletonTest {

	@Test
	public void testGetDescription() {
		for (Singleton singleton : Singleton.values()) {
			assertNotNull(singleton.getDescription());
		}
	}

	@Test
	public void testGetRFC() {
		for (Singleton singleton : Singleton.values()) {
			singleton.getRFC();
		}
	}

	@Test
	public void testIsGetDeprecated() {
		for (Singleton singleton : Singleton.values()) {
			if (singleton.isDeprecated()) {
				assertNotNull(singleton.getDeprecated());
			} else {
				assertNull(singleton.getDeprecated());
			}
		}
	}

	@Test
	public void testGetPreferredValue() {
		for (Singleton singleton : Singleton.values()) {
			if (singleton.getPreferredValue() != null) {
				assertTrue(singleton.isDeprecated());
			}
		}
	}

	@Test
	public void testGetPreferred() {
		for (Singleton singleton : Singleton.values()) {
			assertNotNull(singleton.getPreferred());
		}
	}


	@Test
	public void testValueOf() {
		Subtag nullSubtag = null;
		assertNull(Singleton.valueOf(nullSubtag));
		for (Singleton singleton : Singleton.values()) {
			Subtag subtag = singleton.newSubtag();
			assertNotNull(subtag);
			Singleton s = Singleton.valueOf(subtag);
			assertNotNull(s);
			assertSame(singleton, s);
		}
		try {
			Singleton.valueOf(Subtag.newWildcard());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
