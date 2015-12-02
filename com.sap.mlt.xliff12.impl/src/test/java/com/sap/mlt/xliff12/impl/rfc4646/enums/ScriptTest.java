package com.sap.mlt.xliff12.impl.rfc4646.enums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag;

public class ScriptTest {

	@Test
	public void testIsGetDeprecated() {
		for (Script script : Script.values()) {
			if (script.isDeprecated()) {
				assertNotNull(script.getDeprecated());
			} else {
				assertNull(script.getDeprecated());
			}
		}
	}

	@Test
	public void testGetPreferredValue() {
		for (Script script : Script.values()) {
			if (!script.isDeprecated()) {
				assertNull(script.getPreferredValue());
			}
		}
	}

	@Test
	public void testGetPreferred() {
		for (Script script : Script.values()) {
			assertNotNull(script.getPreferred());
		}
	}

	@Test
	public void testGetDescription() {
		for (Script script : Script.values()) {
			assertNotNull(script.getDescription());
		}
	}

	@Test
	public void testGetDescriptions() {
		for (Script script : Script.values()) {
			String[] descs = script.getDescriptions();
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
		assertNull(Script.valueOf(nullSubtag));
		for (Script script : Script.values()) {
			Subtag subtag = script.newSubtag();
			assertNotNull(subtag);
			Script s = Script.valueOf(subtag);
			assertNotNull(s);
			assertSame(script, s);
		}
		try {
			Script.valueOf(Subtag.newWildcard());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
