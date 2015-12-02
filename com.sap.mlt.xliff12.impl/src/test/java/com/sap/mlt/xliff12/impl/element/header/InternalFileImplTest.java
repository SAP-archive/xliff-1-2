package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.FormImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class InternalFileImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testInternalFileImplText() {
		InternalFileImpl intf = createDefaultInternalFile();
		assertEquals(new TextImpl("test"), intf.getEmbeddedFile());
		assertNull(intf.getCrc());
		assertNull(intf.getForm());
	}

	@Test
	public void testInternalFileImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "internal-file");
		elem.setTextContent("test");

		try {
			InternalFileImpl intf = new InternalFileImpl(elem);
			assertEquals(new TextImpl("test"), intf.getEmbeddedFile());
			assertNull(intf.getCrc());
			assertNull(intf.getForm());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new InternalFileImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.removeChild(elem.getLastChild());
		try {
			InternalFileImpl intf = new InternalFileImpl(elem);
			assertEquals(new TextImpl(""), intf.getEmbeddedFile());
			assertNull(intf.getCrc());
			assertNull(intf.getForm());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new InternalFileImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
	}

	@Test
	public void testGetChildren() {
		InternalFileImpl intf = createDefaultInternalFile();
		List<? extends Node> children = intf.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(new TextImpl("test"), children.get(0));
	}

	@Test
	public void testEmbeddedFile() {
		InternalFileImpl intf = createDefaultInternalFile();
		try {
			intf.setEmbeddedFile(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		intf.setEmbeddedFile(new TextImpl("other"));
		assertEquals(new TextImpl("other"), intf.getEmbeddedFile());
	}

	@Test
	public void testCrc() {
		InternalFileImpl intf = createDefaultInternalFile();
		intf.setCrc(new CrcImpl("1234"));
		assertEquals(new CrcImpl("1234"), intf.getCrc());
		intf.setCrc(null);
		assertNull(intf.getCrc());
	}

	@Test
	public void testForm() {
		InternalFileImpl intf = createDefaultInternalFile();
		intf.setForm(new FormImpl("xyz"));
		assertEquals(new FormImpl("xyz"), intf.getForm());
		intf.setForm(null);
		assertNull(intf.getForm());
	}
	
	@Test
	public void testClone() {
		InternalFileImpl intf = createDefaultInternalFile();
		InternalFileImpl clone = (InternalFileImpl) intf.clone();
		assertEquals(intf, clone);
		assertNotSame(intf, clone);
	}

	private InternalFileImpl createDefaultInternalFile() {
		return new InternalFileImpl(new TextImpl("test"));
	}

}
