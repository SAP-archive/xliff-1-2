package com.sap.mlt.xliff12.impl.element;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.inline.Bpt;
import com.sap.mlt.xliff12.api.element.inline.Bx;
import com.sap.mlt.xliff12.api.element.inline.Ept;
import com.sap.mlt.xliff12.api.element.inline.Ex;
import com.sap.mlt.xliff12.api.element.inline.G;
import com.sap.mlt.xliff12.api.element.inline.It;
import com.sap.mlt.xliff12.api.element.inline.Ph;
import com.sap.mlt.xliff12.api.element.inline.Sub;
import com.sap.mlt.xliff12.api.element.inline.X;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.test.util.Utils;

public class CommonsParserTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testParseTextFragments() {
		Document doc = Utils.createDocument();
		ArrayList<Node> list = new ArrayList<Node>();
		
		// Test g, bpt, ept and text
		Element g = doc.createElementNS(XLIFF_12_NAMESPACE, "g");
		g.setAttributeNS(null, "id", "1");
		g.setTextContent("text1");
		list.add(g);
		
		Element bpt = doc.createElementNS(XLIFF_12_NAMESPACE, "bpt");
		bpt.setAttributeNS(null, "id", "2");
		bpt.setTextContent("text2");
		list.add(bpt);
		
		list.add(doc.createTextNode("text3"));
		
		Element ept = doc.createElementNS(XLIFF_12_NAMESPACE, "ept");
		ept.setAttributeNS(null, "id", "2");
		ept.setTextContent("text4");
		list.add(ept);
		
		try {
			ArrayList<TextFragment> fragments = CommonsParser.parseTextFragments(list);
			assertEquals(new Integer(4), new Integer(fragments.size()));
			assertTrue(fragments.get(0) instanceof G);
			assertTrue(fragments.get(1) instanceof Bpt);
			assertTrue(fragments.get(2) instanceof Text);
			assertTrue(fragments.get(3) instanceof Ept);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		// Test x, bx, ex
		list.clear();
		
		Element x = doc.createElementNS(XLIFF_12_NAMESPACE, "x");
		x.setAttributeNS(null, "id", "1");
		list.add(x);
		
		Element bx = doc.createElementNS(XLIFF_12_NAMESPACE, "bx");
		bx.setAttributeNS(null, "id", "2");
		list.add(bx);
		
		Element ex = doc.createElementNS(XLIFF_12_NAMESPACE, "ex");
		ex.setAttributeNS(null, "id", "2");
		list.add(ex);
		
		try {
			ArrayList<TextFragment> fragments = CommonsParser.parseTextFragments(list);
			assertEquals(new Integer(3), new Integer(fragments.size()));
			assertTrue(fragments.get(0) instanceof X);
			assertTrue(fragments.get(1) instanceof Bx);
			assertTrue(fragments.get(2) instanceof Ex);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		// Test ph, it, mrk
		list.clear();
		
		Element ph = doc.createElementNS(XLIFF_12_NAMESPACE, "ph");
		ph.setAttributeNS(null, "id", "1");
		ph.setTextContent("text1");
		list.add(ph);
		
		Element it = doc.createElementNS(XLIFF_12_NAMESPACE, "it");
		it.setAttributeNS(null, "id", "2");
		it.setAttributeNS(null, "pos", "open");
		list.add(it);
		
		Element mrk = doc.createElementNS(XLIFF_12_NAMESPACE, "mrk");
		mrk.setAttributeNS(XLIFF_12_NAMESPACE, "mtype", "name");
		mrk.setTextContent("text2");
		list.add(mrk);
		
		try {
			ArrayList<TextFragment> fragments = CommonsParser.parseTextFragments(list);
			assertEquals(new Integer(3), new Integer(fragments.size()));
			assertTrue(fragments.get(0) instanceof Ph);
			assertTrue(fragments.get(1) instanceof It);
			assertTrue(fragments.get(2) instanceof Mrk);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		// Test invalid elements
		list.clear();
		Element invalid = doc.createElementNS(XLIFF_12_NAMESPACE, "invalid");
		list.add(invalid);
		try {
			CommonsParser.parseTextFragments(list);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		Element invalidParent = doc.createElementNS(XLIFF_12_NAMESPACE, "parent");
		invalidParent.appendChild(invalid);
		try {
			CommonsParser.parseTextFragments(list);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
	}

	@Test
	public void testParseCodeFragments() {
		Document doc = Utils.createDocument();
		ArrayList<Node> list = new ArrayList<Node>();
		
		list.add(doc.createTextNode("text1"));
		
		Element sub = doc.createElementNS(XLIFF_12_NAMESPACE, "sub");
		sub.setTextContent("text2");
		list.add(sub);
				
		try {
			ArrayList<CodeFragment> fragments = CommonsParser.parseCodeFragments(list);
			assertEquals(new Integer(2), new Integer(fragments.size()));
			assertTrue(fragments.get(0) instanceof Text);
			assertTrue(fragments.get(1) instanceof Sub);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		// Test invalid elements
		list.clear();
		Element invalid = doc.createElementNS(XLIFF_12_NAMESPACE, "invalid");
		list.add(invalid);
		try {
			CommonsParser.parseCodeFragments(list);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		Element invalidParent = doc.createElementNS(XLIFF_12_NAMESPACE, "parent");
		invalidParent.appendChild(invalid);
		try {
			CommonsParser.parseCodeFragments(list);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

}
