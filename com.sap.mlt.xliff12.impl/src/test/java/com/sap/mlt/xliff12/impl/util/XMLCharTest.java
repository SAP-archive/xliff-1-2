package com.sap.mlt.xliff12.impl.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLCharTest {

	@Test
	public void testIsSupplemental() {
		assertTrue(XMLChar.isSupplemental(0x10004));
		assertFalse(XMLChar.isSupplemental(0x32));
	}

	@Test
	public void testSupplemental() {
		char h = (char)0xD801;
		char l = (char)0xDC02;
		int supplemental = 0x400 + 2 + 0x10000;
		assertEquals(new Integer(supplemental), new Integer(XMLChar.supplemental(h, l)));
		assertEquals(new Character(h), new Character(XMLChar.highSurrogate(supplemental)));
		assertEquals(new Character(l), new Character(XMLChar.lowSurrogate(supplemental)));
	}

	@Test
	public void testIsHighSurrogate() {
		assertTrue(XMLChar.isHighSurrogate(0xD800));
		assertFalse(XMLChar.isHighSurrogate(0xD7FF));
	}

	@Test
	public void testIsLowSurrogate() {
		assertTrue(XMLChar.isLowSurrogate(0xDC00));
		assertFalse(XMLChar.isLowSurrogate(0xD800));
	}

	@Test
	public void testIsValid() {
		assertFalse(XMLChar.isValid(0));
		assertTrue(XMLChar.isValid('a'));
		assertTrue(XMLChar.isValid(0x10000));
		assertFalse(XMLChar.isValid(0x110000));
	}

	@Test
	public void testIsInvalid() {
		assertTrue(XMLChar.isInvalid(0));
		assertFalse(XMLChar.isInvalid('a'));
	}

	@Test
	public void testIsContent() {
		assertFalse(XMLChar.isContent('\n'));
		assertTrue(XMLChar.isContent('a'));
		assertTrue(XMLChar.isContent(0x10000));
		assertFalse(XMLChar.isContent(0x110000));
	}

	@Test
	public void testIsMarkup() {
		assertTrue(XMLChar.isMarkup('<'));
		assertTrue(XMLChar.isMarkup('&'));
		assertTrue(XMLChar.isMarkup('%'));
		assertFalse(XMLChar.isMarkup('a'));
	}

	@Test
	public void testIsSpace() {
		assertTrue(XMLChar.isSpace(' '));
		assertFalse(XMLChar.isSpace('a'));
	}

	@Test
	public void testIsNameStart() {
		assertTrue(XMLChar.isNameStart('a'));
		assertFalse(XMLChar.isNameStart(' '));
	}

	@Test
	public void testIsName() {
		assertTrue(XMLChar.isName('a'));
		assertFalse(XMLChar.isName(' '));
	}

	@Test
	public void testIsNCNameStart() {
		assertTrue(XMLChar.isNCNameStart('a'));
		assertFalse(XMLChar.isNCNameStart(' '));
	}

	@Test
	public void testIsNCName() {
		assertTrue(XMLChar.isNCName('a'));
		assertFalse(XMLChar.isNCName(' '));
	}

	@Test
	public void testIsPubid() {
		assertTrue(XMLChar.isPubid('a'));
		assertFalse(XMLChar.isPubid('"'));
	}

	@Test
	public void testIsValidName() {
		assertFalse(XMLChar.isValidName(""));
		assertFalse(XMLChar.isValidName("df sdf"));
		assertFalse(XMLChar.isValidName(" dfsdf"));
		assertTrue(XMLChar.isValidName("dfsdf"));
	}

	@Test
	public void testIsValidNCName() {
		assertFalse(XMLChar.isValidNCName(""));
		assertFalse(XMLChar.isValidNCName("df:sdf"));
		assertFalse(XMLChar.isValidNCName(" dfsdf"));
		assertTrue(XMLChar.isValidNCName("dfsdf"));
	}

	@Test
	public void testIsValidNmtoken() {
		assertFalse(XMLChar.isValidNmtoken(""));
		assertFalse(XMLChar.isValidNmtoken("asdf adf"));
		assertTrue(XMLChar.isValidNmtoken("asdfadf"));
	}

}
