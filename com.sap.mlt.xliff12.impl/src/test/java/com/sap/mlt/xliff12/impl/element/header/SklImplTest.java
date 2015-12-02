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

public class SklImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testSklImplChild() {
		SklImpl ref = createDefaultSkl();
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				ref.getChild());
	}

	@Test
	public void testSklImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "skl");
		try {
			new SklImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(new ExternalFileImpl(
				new HrefImpl("http://www.sap.com")).asXmlNode(doc));
		try {
			SklImpl ref = new SklImpl(elem);
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
			SklImpl ref = new SklImpl(elem);
			assertEquals(new InternalFileImpl(new TextImpl("abc")), ref
					.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new SklImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		SklImpl skl = createDefaultSkl();
		List<? extends com.sap.mlt.xliff12.api.base.Element> children = skl
				.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com/")),
				children.get(0));
	}

	@Test
	public void testChild() {
		SklImpl skl = createDefaultSkl();

		try {
			skl.setChild(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		skl.setChild(new InternalFileImpl(new TextImpl("abc")));
		assertEquals(new InternalFileImpl(new TextImpl("abc")), skl.getChild());

		skl.setChild(new ExternalFileImpl(new HrefImpl("http://www.sap.com")));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com")),
				skl.getChild());
	}
	
	@Test
	public void testClone() {
		SklImpl skl = createDefaultSkl();
		SklImpl clone = (SklImpl) skl.clone();
		assertEquals(skl, clone);
		assertNotSame(skl, clone);
	}

	private SklImpl createDefaultSkl() {
		return new SklImpl(new ExternalFileImpl(new HrefImpl(
				"http://www.sap.com/")));
	}

}
