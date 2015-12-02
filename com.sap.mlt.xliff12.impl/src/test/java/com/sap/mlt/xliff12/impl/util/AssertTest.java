package com.sap.mlt.xliff12.impl.util;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.test.util.Utils;

public class AssertTest {

	private static final String XLIFF_NS = "urn:oasis:names:tc:xliff:document:1.2";

	private static final String XML_NS = "http://www.w3.org/XML/1998/namespace";

	@Test
	public void testNotNull() {
		try {
			Assert.notNull(null, "test");
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		Assert.notNull(new Object(), "test");
	}

	@Test
	public void testIsNmtoken() {
		try {
			Assert.isNmtoken("$", "test");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		Assert.isNmtoken("abc", "test");
	}

	@Test
	public void testXliffAttrAvailable() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_NS, "test");
		elem.setAttributeNS(XLIFF_NS, "a", "abc");
		elem.setAttributeNS(XLIFF_NS, "b", "abc");
		elem.setAttributeNS(XLIFF_NS, "c", "abc");
		elem.setAttributeNS(XML_NS, "xml:lang", "en");

		try {
			Assert.xliffAttrAvailable(elem, "a");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.xliffAttrAvailable(elem, "a", "b", "c");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.xliffAttrAvailable(elem, "lang");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrAvailable(elem, "d");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrAvailable(elem, "a", "b", "c", "d");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrAvailable(elem, "b", "c", "d", "lang");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testXliffAttrRestricted() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_NS, "test");
		elem.setAttributeNS(XLIFF_NS, "a", "abc");
		elem.setAttributeNS(XLIFF_NS, "b", "abc");
		elem.setAttributeNS(XLIFF_NS, "c", "abc");
		elem.setAttributeNS(XML_NS, "xml:lang", "en");
		elem.setAttributeNS(XML_NS, "xml:space", "preserve");
		elem.setAttributeNS("xyz", "a", "abc");

		try {
			Assert.xliffAttrRestricted(elem, true, true, true, "a", "b", "c");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.xliffAttrRestricted(elem, true, true, true, "a", "b", "c", "d");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.xliffAttrRestricted(elem, true, true, true, "b", "c", "d");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrRestricted(elem, false, true, true, "a", "b", "c");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrRestricted(elem, true, false, true, "a", "b", "c");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.xliffAttrRestricted(elem, true, true, false, "a", "b", "c");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testIsXliffElementNode() {
		Document doc = Utils.createDocument();
		Element parent = doc.createElementNS("xyz", "ijk");
		Node attr = doc.createAttribute("abc");
		Node text = doc.createTextNode("abc");
		Node nonXliffElem = doc.createElementNS("xyz", "abc");
		Node xliffElem = doc.createElementNS(XLIFF_NS, "abc");
		
		try {
			Assert.isXliffElement(attr);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(nonXliffElem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(xliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		parent.appendChild(text);
		parent.appendChild(nonXliffElem);
		parent.appendChild(xliffElem);

		try {
			Assert.isXliffElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(nonXliffElem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		try {
			Assert.isXliffElement(xliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testIsXliffElementNodeString() {
		Document doc = Utils.createDocument();
		Element parent = doc.createElementNS("xyz", "ijk");
		Node attr = doc.createAttribute("abc");
		Node text = doc.createTextNode("abc");
		Node nonXliffElem = doc.createElementNS("xyz", "abc");
		Node xliffElem = doc.createElementNS(XLIFF_NS, "abc");

		try {
			Assert.isXliffElement(attr, "abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(text, "abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(nonXliffElem, "abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(xliffElem, "abc");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isXliffElement(xliffElem, "xyz");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		parent.appendChild(text);
		parent.appendChild(nonXliffElem);
		parent.appendChild(xliffElem);

		try {
			Assert.isXliffElement(text, "abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(nonXliffElem, "abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isXliffElement(xliffElem, "abc");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isXliffElement(xliffElem, "xyz");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testIsElement() {
		Document doc = Utils.createDocument();
		Element parent = doc.createElementNS("xyz", "ijk");
		Node attr = doc.createAttribute("abc");
		Node text = doc.createTextNode("abc");
		Node nonXliffElem = doc.createElementNS("xyz", "abc");
		Node xliffElem = doc.createElementNS(XLIFF_NS, "abc");

		try {
			Assert.isElement(attr);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isElement(nonXliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isElement(xliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		parent.appendChild(text);
		parent.appendChild(nonXliffElem);
		parent.appendChild(xliffElem);

		try {
			Assert.isElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isElement(nonXliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isElement(xliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testIsNonXliffElement() {
		Document doc = Utils.createDocument();
		Element parent = doc.createElementNS("xyz", "ijk");
		Node attr = doc.createAttribute("abc");
		Node text = doc.createTextNode("abc");
		Node nonXliffElem = doc.createElementNS("xyz", "abc");
		Node xliffElem = doc.createElementNS(XLIFF_NS, "abc");
		
		try {
			Assert.isNonXliffElement(attr);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isNonXliffElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isNonXliffElement(nonXliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isNonXliffElement(xliffElem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		parent.appendChild(text);
		parent.appendChild(nonXliffElem);
		parent.appendChild(xliffElem);

		try {
			Assert.isNonXliffElement(text);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			Assert.isNonXliffElement(nonXliffElem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		try {
			Assert.isNonXliffElement(xliffElem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}
	
	@Test
	public void testIsInstance() {
		Integer anInteger = new Integer(5);
		Assert.isInstance(null, "anInteger", Integer.class);
		Assert.isInstance(anInteger, "anInteger", Object.class);
		Assert.isInstance(anInteger, "anInteger", Integer.class);
		try {
			Assert.isInstance(anInteger, "anInteger", Double.class);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}
	
	@Test
	public void testAreInstances() {
		ArrayList<Object> objects = new ArrayList<Object>();
		objects.add(new Integer(5));
		objects.add(new Double(3.0));
		Assert.areInstances(objects, "objects", Integer.class, Double.class);
		Assert.areInstances(objects, "objects", Object.class);
		try {
			Assert.areInstances(objects, "objects", Double.class);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		
	}

}
