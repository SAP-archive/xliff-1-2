package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CloneImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypePhImpl;
import com.sap.mlt.xliff12.impl.attribute.EquivTextImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class XImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testXImplIdListOfQextendsCodeFragment() {
		XImpl x = createDefaultX();
		assertEquals(new IdImpl("1"), x.getId());
		assertEquals(new CloneImpl(Clone.Value.YES), x.getClone());
	}

	@Test
	public void testXImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "x");
		
		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "ctype", "x-abc");
		try {
			XImpl x = new XImpl(elem);
			assertEquals(new IdImpl("1"), x.getId());
			assertEquals(new CloneImpl(Clone.Value.YES), x.getClone());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.setTextContent("abc");
		try {
			new XImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}
		
		elem.setAttributeNS(null, "ctype", "bold");
		try {
			new XImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		elem.setAttributeNS(null, "ctype", "image");
		try {
			new XImpl(elem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		XImpl x = createDefaultX();
		assertEquals(new ArrayList<Node>(), x.getChildren());
	}
	
	@Test
	public void testCloneAttr() {
		XImpl x = createDefaultX();
		x.setClone(new CloneImpl(Clone.Value.NO));
		assertEquals(new CloneImpl(Clone.Value.NO), x.getClone());
		x.setClone(null);
		assertEquals(new CloneImpl(Clone.Value.YES), x.getClone());
	}

	@Test
	public void testCtype() {
		XImpl x = createDefaultX();
		x.setCtype(new CtypePhImpl("139"));
		assertEquals(new CtypePhImpl("139"), x.getCtype());
		x.setCtype(null);
		assertNull(x.getCtype());
	}

	@Test
	public void testGetPlainText() {
		XImpl x = createDefaultX();
		x.setEquivText(new EquivTextImpl("something"));
		assertEquals("something", x.getPlainText());
		x.setEquivText(null);
		assertEquals("", x.getPlainText());
	}
	
	@Test
	public void testClone() {
		XImpl x = createDefaultX();
		XImpl clone = (XImpl) x.clone();
		assertEquals(x, clone);
		assertNotSame(x, clone);
	}

	private XImpl createDefaultX() {
		XImpl x = new XImpl(new IdImpl("1"));
		return x;
	}


}
