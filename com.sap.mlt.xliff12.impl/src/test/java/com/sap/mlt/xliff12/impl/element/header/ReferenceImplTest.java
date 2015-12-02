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

public class ReferenceImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testReferenceImplChild() {
		ReferenceImpl ref = createDefaultReference();
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				ref.getChild());
	}

	@Test
	public void testReferenceImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "reference");
		try {
			new ReferenceImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(new ExternalFileImpl(
				new HrefImpl("http://www.sap.com")).asXmlNode(doc));
		try {
			ReferenceImpl ref = new ReferenceImpl(elem);
			assertEquals(new ExternalFileImpl(
					new HrefImpl("http://www.sap.com")), ref.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(new InternalFileImpl(new TextImpl("abc"))
				.asXmlNode(doc));
		try {
			ReferenceImpl ref = new ReferenceImpl(elem);
			assertEquals(new InternalFileImpl(new TextImpl("abc")), ref
					.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new ReferenceImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		ReferenceImpl ref = createDefaultReference();
		List<? extends com.sap.mlt.xliff12.api.base.Element> children = ref
				.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				children.get(0));
	}

	@Test
	public void testChild() {
		ReferenceImpl ref = createDefaultReference();

		try {
			ref.setChild(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		ref.setChild(new InternalFileImpl(new TextImpl("abc")));
		assertEquals(new InternalFileImpl(new TextImpl("abc")), ref
				.getChild());

		ref.setChild(new ExternalFileImpl(new HrefImpl(
				"http://www.sap.com")));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com")),
				ref.getChild());
	}
	
	@Test
	public void testClone() {
		ReferenceImpl reference = createDefaultReference();
		ReferenceImpl clone = (ReferenceImpl) reference.clone();
		assertEquals(reference, clone);
		assertNotSame(reference, clone);
	}

	private ReferenceImpl createDefaultReference() {
		return new ReferenceImpl(new ExternalFileImpl(new HrefImpl(
				"http://www.sap.com/")));
	}

}
