package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.UidImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ExternalFileImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testExternalFileImplHref() {
		ExternalFileImpl ef = createDefaultExternalFile();
		assertEquals(new HrefImpl("http://www.sap.com/"), ef.getHref());
		assertNull(ef.getCrc());
		assertNull(ef.getUid());
	}

	@Test
	public void testExternalFileImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "external-file");
		elem.setAttributeNS(null, "href", "http://www.sap.com/");
		try {
			ExternalFileImpl ef = new ExternalFileImpl(elem);
			assertEquals(new HrefImpl("http://www.sap.com/"), ef.getHref());
			assertNull(ef.getCrc());
			assertNull(ef.getUid());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createTextNode("test"));
		try {
			new ExternalFileImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}
	
	@Test
	public void testGetChildren() {
		ExternalFileImpl ef = createDefaultExternalFile();
		assertTrue(ef.getChildren().isEmpty());
	}
	
	@Test
	public void testCrc() {
		ExternalFileImpl ef = createDefaultExternalFile();
		ef.setCrc(new CrcImpl("abc"));
		assertEquals(new CrcImpl("abc"), ef.getCrc());
		ef.setCrc(null);
		assertNull(ef.getCrc());
	}
	
	@Test
	public void testUid() {
		ExternalFileImpl ef = createDefaultExternalFile();
		ef.setUid(new UidImpl("abc"));
		assertEquals(new UidImpl("abc"), ef.getUid());
		ef.setUid(null);
		assertNull(ef.getUid());
	}
	
	@Test
	public void testHref() {
		ExternalFileImpl ef = createDefaultExternalFile();
		try {
			ef.setHref(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		ef.setHref(new HrefImpl("abcd"));
		assertEquals(new HrefImpl("abcd"), ef.getHref());
	}
	
	@Test
	public void testClone() {
		ExternalFileImpl ef = createDefaultExternalFile();
		ExternalFileImpl clone = (ExternalFileImpl) ef.clone();
		assertEquals(ef, clone);
		assertNotSame(ef, clone);
	}

	private ExternalFileImpl createDefaultExternalFile() {
		return new ExternalFileImpl(new HrefImpl("http://www.sap.com/"));
	}

}
