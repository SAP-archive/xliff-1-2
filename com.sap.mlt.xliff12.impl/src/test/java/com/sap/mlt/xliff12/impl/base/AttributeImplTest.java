package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttributeImplTest {

	@Test
	public void testHashCode() {
		ConcreteAttributeImpl attr1 = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		ConcreteAttributeImpl attr2 = new ConcreteAttributeImpl("ns", "pre2",
				"name", "value");
		assertEquals(new Integer(attr1.hashCode()), new Integer(attr2.hashCode()));
	}

	@Test
	public void testAttributeImpl() {
		new ConcreteAttributeImpl("ns", "pre", "name", "value");
		new ConcreteAttributeImpl("ns", "", "name", "value");
		new ConcreteAttributeImpl("ns", null, "name", "value");
		
		try {
			new ConcreteAttributeImpl(null, "pre", "name", "value");
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			new ConcreteAttributeImpl("ns", "pre", null, "value");
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			new ConcreteAttributeImpl("ns", "pre", "name", null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		try {
			new ConcreteAttributeImpl("ns", "pre:1", "name", "value");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			new ConcreteAttributeImpl("ns", "pre", "na\nme", "value");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			new ConcreteAttributeImpl("ns", "pre", "name", "val\fue");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetNamespaceUri() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		assertEquals("ns", attr.getNamespaceUri());
	}

	@Test
	public void testGetPrefix() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		assertEquals("pre", attr.getPrefix());
	}

	@Test
	public void testGetName() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		assertEquals("name", attr.getName());
	}

	@Test
	public void testGetValue() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		assertEquals("value", attr.getValue());
	}
	
	@Test
	public void testSetOwner() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		ConcreteElementImpl elem1 = new ConcreteElementImpl("ns", "pre", "name");
		ConcreteElementImpl elem2 = new ConcreteElementImpl("ns", "pre", "name");
		attr.setOwner(elem1);
		attr.setOwner(elem1);
		try {
			attr.setOwner(elem2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testEqualsObject() {
		ConcreteAttributeImpl attr1 = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		ConcreteAttributeImpl attr2 = new ConcreteAttributeImpl("ns", "pre2",
				"name", "value");
		ConcreteAttributeImpl attr3 = new ConcreteAttributeImpl("ns2", "pre",
				"name", "value");
		ConcreteAttributeImpl attr4 = new ConcreteAttributeImpl("ns", "pre",
				"name2", "value");
		ConcreteAttributeImpl attr5 = new ConcreteAttributeImpl("ns", "pre",
				"name", "value2");
		assertEquals(attr1, attr1);
		assertEquals(attr1, attr2);
		assertFalse(attr1.equals(attr3));
		assertFalse(attr1.equals(attr4));
		assertFalse(attr1.equals(attr5));
		assertFalse(attr1.equals(null));
		assertFalse(attr1.equals(new Object()));
	}

	@Test
	public void testToString() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		attr.toString();
	}
	
	@Test
	public void testClone() {
		ConcreteAttributeImpl attr = new ConcreteAttributeImpl("ns", "pre",
				"name", "value");
		ConcreteElementImpl elem = new ConcreteElementImpl("ns", "pre", "name");
		attr.setOwner(elem);
		
		ConcreteAttributeImpl cattr = attr.clone();
		assertNull(cattr.getOwnerElement());
		assertEquals(attr, cattr);
		assertNotSame(attr, cattr);
	}
}
