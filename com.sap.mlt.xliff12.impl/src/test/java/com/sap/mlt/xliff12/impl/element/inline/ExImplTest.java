package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.EquivTextImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ExImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testExImplId() {
		ExImpl ex = createDefaultEx();
		assertEquals(new IdImpl("1"), ex.getId());
	}

	@Test
	public void testBxImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ex");
		
		elem.setAttributeNS(null, "id", "1");
		try {
			ExImpl ex = new ExImpl(elem);
			assertEquals(new IdImpl("1"), ex.getId());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.setTextContent("abc");
		try {
			new ExImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}
	
	@Test
	public void testGetChildren() {
		ExImpl ex = createDefaultEx();
		assertEquals(new ArrayList<Node>(), ex.getChildren());
	}
	
	@Test
	public void testGetPlainText() {
		ExImpl ex = createDefaultEx();
		ex.setEquivText(new EquivTextImpl("something"));
		assertEquals("something", ex.getPlainText());
		ex.setEquivText(null);
		assertEquals("", ex.getPlainText());
	}
	
	@Test
	public void testRid() {
		ExImpl ex = createDefaultEx();
		ex.setRid(new RidImpl("rid"));
		assertEquals(new RidImpl("rid"), ex.getRid());
		ex.setRid(null);
		assertNull(ex.getRid());
	}
	
	@Test
	public void testClone() {
		ExImpl ex = createDefaultEx();
		ExImpl clone = (ExImpl) ex.clone();
		assertEquals(ex, clone);
		assertNotSame(ex, clone);
	}
	
	private ExImpl createDefaultEx() {
		ExImpl ex = new ExImpl(new IdImpl("1"));
		return ex;
	}

}
