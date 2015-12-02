package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class GlossaryImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testGlossaryImplChild() {
		GlossaryImpl glossary = createDefaultGlossary();
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				glossary.getChild());
	}

	@Test
	public void testGlossaryImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "glossary");
		try {
			new GlossaryImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(new ExternalFileImpl(
				new HrefImpl("http://www.sap.com")).asXmlNode(doc));
		try {
			GlossaryImpl glossary = new GlossaryImpl(elem);
			assertEquals(new ExternalFileImpl(
					new HrefImpl("http://www.sap.com")), glossary.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(new InternalFileImpl(new TextImpl("abc"))
				.asXmlNode(doc));
		try {
			GlossaryImpl glossary = new GlossaryImpl(elem);
			assertEquals(new InternalFileImpl(new TextImpl("abc")), glossary
					.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new GlossaryImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		GlossaryImpl glossary = createDefaultGlossary();
		List<? extends com.sap.mlt.xliff12.api.base.Element> children = glossary
				.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				children.get(0));
	}

	@Test
	public void testChild() {
		GlossaryImpl glossary = createDefaultGlossary();

		try {
			glossary.setChild(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		glossary.setChild(new InternalFileImpl(new TextImpl("abc")));
		assertEquals(new InternalFileImpl(new TextImpl("abc")), glossary
				.getChild());

		glossary.setChild(new ExternalFileImpl(new HrefImpl(
				"http://www.sap.com")));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com")),
				glossary.getChild());
	}
	
	@Test
	public void testClone() {
		GlossaryImpl glossary = createDefaultGlossary();
		GlossaryImpl clone = (GlossaryImpl) glossary.clone();
		assertEquals(glossary, clone);
		assertNotSame(glossary, clone);
	}

	private GlossaryImpl createDefaultGlossary() {
		return new GlossaryImpl(new ExternalFileImpl(new HrefImpl(
				"http://www.sap.com/")));
	}

}
