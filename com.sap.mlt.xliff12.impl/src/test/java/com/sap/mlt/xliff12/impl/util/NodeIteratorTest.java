package com.sap.mlt.xliff12.impl.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.test.util.Utils;

public class NodeIteratorTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testHasNext() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.hasNext());
		
		nodes.add(doc.createTextNode("  \r\n"));
		ni = new NodeIterator(nodes, false);
		assertTrue(ni.hasNext());
		ni.getText();
		assertFalse(ni.hasNext());
		
		ni = new NodeIterator(nodes, true);
		assertFalse(ni.hasNext());
	}

	@Test
	public void testNextIsText() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsText());
		
		nodes.add(doc.createTextNode("abc"));
		nodes.add(doc.createElementNS("ns", "name"));
		ni = new NodeIterator(nodes, false);
		assertTrue(ni.nextIsText());
		ni.getText();
		assertFalse(ni.nextIsText());
	}

	@Test
	public void testNextIsElement() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsElement());
		
		nodes.add(doc.createElementNS("ns", "name"));
		nodes.add(doc.createTextNode("abc"));
		ni = new NodeIterator(nodes, false);
		assertTrue(ni.nextIsElement());
		ni.getElement();
		assertFalse(ni.nextIsElement());
	}

	@Test
	public void testNextIsXliffElement() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsXliffElement());
		
		nodes.add(doc.createElementNS("ns", "name"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "name"));
		nodes.add(doc.createTextNode("abc"));
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsXliffElement());
		ni.getElement();
		assertTrue(ni.nextIsXliffElement());
		ni.getElement();
		assertFalse(ni.nextIsXliffElement());
	}

	@Test
	public void testNextIsXliffElementString() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsXliffElement("name"));
		
		nodes.add(doc.createElementNS("ns", "name"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "name"));
		nodes.add(doc.createTextNode("abc"));
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsXliffElement("name"));
		ni.getElement();
		assertTrue(ni.nextIsXliffElement("name"));
		assertFalse(ni.nextIsXliffElement("name2"));
		ni.getElement();
		assertFalse(ni.nextIsXliffElement("abc"));
	}

	@Test
	public void testNextIsNonXliffElement() throws ConstraintViolationException {
		NodeIterator ni;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		ni = new NodeIterator(nodes, false);
		assertFalse(ni.nextIsNonXliffElement());
		
		nodes.add(doc.createElementNS("ns", "name"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "name"));
		nodes.add(doc.createTextNode("abc"));
		ni = new NodeIterator(nodes, false);
		assertTrue(ni.nextIsNonXliffElement());
		ni.getElement();
		assertFalse(ni.nextIsNonXliffElement());
		ni.getElement();
		assertFalse(ni.nextIsNonXliffElement());
	}

	@Test
	public void testGetText() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createTextNode("abc"));
		nodes.add(doc.createElementNS("ns", "abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);
		try {
			String text = ni.getText();
			assertEquals("abc", text);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getText();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getText();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetElement() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetXliffElement() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);

		try {
			ni.getXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetNonXliffElement() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "abc"));
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);

		try {
			ni.getNonXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getNonXliffElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getNonXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getNonXliffElement();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetXliffElementString() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);

		try {
			ni.getXliffElement("abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement("abcd");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getXliffElement("abc");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getXliffElement("abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement("abc");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testAssertNoMoreNodes() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);
		try {
			ni.assertNoMoreNodes();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.assertNoMoreNodes();
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.assertNoMoreNodes();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
	}

	@Test
	public void testGetXliffElementStringArray() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Document doc = Utils.createDocument();
		
		nodes.add(doc.createElementNS("ns", "abc"));
		nodes.add(doc.createElementNS(XLIFF_12_NAMESPACE, "abc"));
		nodes.add(doc.createTextNode("abc"));
		
		NodeIterator ni = new NodeIterator(nodes, false);

		try {
			ni.getXliffElement("abc", "ns");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getElement();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement("abcd", "ns");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getXliffElement("abc", "abcd");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		try {
			ni.getXliffElement("abc", "ns");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		try {
			ni.getText();
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		try {
			ni.getXliffElement("abc", "ns");
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

}
