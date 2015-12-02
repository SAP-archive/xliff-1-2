package com.sap.mlt.xliff12.impl.rfc4646;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.sap.mlt.xliff12.impl.rfc4646.Subtag.Type;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Language;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Region;
import com.sap.mlt.xliff12.impl.rfc4646.enums.Script;

public class SubtagSetTest {

	@Test
	public void testHashCode() {
		Subtag lang1 = new Subtag(Language.DE);
		Subtag region1 = new Subtag(Region.DE);
		lang1.setNext(region1);
		ConcreteSubtagSet set1 = new ConcreteSubtagSet(lang1);
		
		Subtag lang2 = new Subtag(Language.DE);
		Subtag region2 = new Subtag(Region.DE);
		lang1.setNext(region2);
		ConcreteSubtagSet set2 = new ConcreteSubtagSet(lang2);
		
		assertEquals(new Integer(set1.hashCode()), new Integer(set1.hashCode()));
		assertEquals(new Integer(set2.hashCode()), new Integer(set2.hashCode()));
	}

	@Test
	public void testSubtagSet() {
		Subtag lang = new Subtag(Language.DE);
		Subtag region = new Subtag(Region.DE);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		Iterator<Subtag> i = set.iterator();
		assertTrue(i.hasNext());
		assertEquals(lang, i.next());
		assertTrue(i.hasNext());
		assertEquals(region, i.next());
		assertFalse(i.hasNext());
	}

	@Test
	public void testToString() {
		Subtag lang = new Subtag(Language.DE);
		Subtag region = new Subtag(Region.DE);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		assertEquals("de-DE", set.toString());
	}

	@Test
	public void testIterator() {
		Subtag lang = new Subtag(Language.DE);
		Subtag region = new Subtag(Region.DE);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		Iterator<Subtag> i = set.iterator();
		try {
			i.remove();
			fail("Expected exception");
		} catch (Exception e) {
			// $JL-EXC$
		}
		assertTrue(i.hasNext());
		assertEquals(lang, i.next());
		assertTrue(i.hasNext());
		assertEquals(region, i.next());
		assertFalse(i.hasNext());
	}

	@Test
	public void testContainsSubtag() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		assertTrue(set.contains(lang));
		assertTrue(set.contains(region));
		assertTrue(set.contains(new Subtag(Language.EN)));
		assertTrue(set.contains(new Subtag(Region.US)));
		assertFalse(set.contains(new Subtag(Script.LATN)));
	}

	@Test
	public void testContainsString() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		assertTrue(set.contains("EN"));
		assertTrue(set.contains("US"));
		assertFalse(set.contains("DE"));
	}

	@Test
	public void testContainsStringType() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		assertTrue(set.contains("en", Type.PRIMARY));
		assertTrue(set.contains("US", Type.REGION));
		assertFalse(set.contains("DE", Type.REGION));
	}

	@Test
	public void testLength() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		assertEquals(new Integer(5), new Integer(set.length()));
	}

	@Test
	public void testIsValid() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet validSet = new ConcreteSubtagSet(lang);
		
		Subtag lang2 = new Subtag(Language.EN);
		Subtag invalidSubtag = new Subtag(Type.REGION, "ABCD");
		lang2.setNext(invalidSubtag);
		ConcreteSubtagSet invalidSet = new ConcreteSubtagSet(lang2);
		
		assertTrue(validSet.isValid());
		assertFalse(invalidSet.isValid());
	}

	@Test
	public void testCount() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		assertEquals(new Integer(2), new Integer(set.count()));
	}

	@Test
	public void testGet() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		assertEquals(lang, set.get(0));
		assertEquals(region, set.get(1));
		try {
			set.get(-1);
			fail("Expected exception");
		} catch (Exception e) {
			// $JL-EXC$
		}
		try {
			set.get(2);
			fail("Expected exception");
		} catch (Exception e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testEqualsObject() {
		Subtag lang1 = new Subtag(Language.EN);
		Subtag region1 = new Subtag(Region.US);
		lang1.setNext(region1);
		ConcreteSubtagSet set1 = new ConcreteSubtagSet(lang1);

		Subtag lang2 = new Subtag(Language.EN);
		Subtag region2 = new Subtag(Region.US);
		lang2.setNext(region2);
		ConcreteSubtagSet set2 = new ConcreteSubtagSet(lang2);

		Subtag lang3 = new Subtag(Language.DE);
		Subtag region3 = new Subtag(Region.DE);
		lang3.setNext(region3);
		ConcreteSubtagSet set3 = new ConcreteSubtagSet(lang3);
		
		Subtag lang4 = new Subtag(Language.EN);
		Subtag region4 = new Subtag(Region.US);
		Subtag script4 = new Subtag(Script.LATN);
		lang4.setNext(region4);
		region4.setNext(script4);
		ConcreteSubtagSet set4 = new ConcreteSubtagSet(lang4);

		assertEquals(set1, set1);
		assertEquals(set1, set2);
		assertFalse(set1.equals(set3));
		assertFalse(set1.equals(set4));
		assertFalse(set1.equals(null));
		assertFalse(set1.equals(new Object()));
	}

	@Test
	public void testToArray() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		Subtag[] array = set.toArray();
		assertEquals(new Integer(2), new Integer(array.length));
		assertEquals(lang, array[0]);
		assertEquals(region, array[1]);
	}

	@Test
	public void testAsList() {
		Subtag lang = new Subtag(Language.EN);
		Subtag region = new Subtag(Region.US);
		lang.setNext(region);
		ConcreteSubtagSet set = new ConcreteSubtagSet(lang);
		
		List<Subtag> list = set.asList();
		assertEquals(new Integer(2), new Integer(list.size()));
		assertEquals(lang, list.get(0));
		assertEquals(region, list.get(1));
	}

	@Test
	public void testCompareTo() {
		Subtag lang1 = new Subtag(Language.EN);
		Subtag region1 = new Subtag(Region.US);
		lang1.setNext(region1);
		ConcreteSubtagSet set1 = new ConcreteSubtagSet(lang1);

		Subtag lang2 = new Subtag(Language.EN);
		Subtag region2 = new Subtag(Region.US);
		lang2.setNext(region2);
		ConcreteSubtagSet set2 = new ConcreteSubtagSet(lang2);

		Subtag lang3 = new Subtag(Language.DE);
		Subtag region3 = new Subtag(Region.DE);
		lang3.setNext(region3);
		ConcreteSubtagSet set3 = new ConcreteSubtagSet(lang3);
		
		Subtag lang4 = new Subtag(Language.EN);
		Subtag region4 = new Subtag(Region.US);
		Subtag script4 = new Subtag(Script.LATN);
		lang4.setNext(region4);
		region4.setNext(script4);
		ConcreteSubtagSet set4 = new ConcreteSubtagSet(lang4);
		
		assertTrue(0 == set1.compareTo(set1));
		assertTrue(0 == set1.compareTo(set2));
		assertFalse(set1.compareTo(set3) == 0);
		assertFalse(set1.compareTo(set4) == 0);
		assertFalse(set4.compareTo(set1) == 0);
	}

}
