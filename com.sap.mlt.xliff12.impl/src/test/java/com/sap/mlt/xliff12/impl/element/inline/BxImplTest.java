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
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.EquivTextImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class BxImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBxImplId() {
		BxImpl bx = createDefaultBx();
		assertEquals(new IdImpl("1"), bx.getId());
		assertEquals(new CloneImpl(Clone.Value.YES), bx.getClone());
	}

	@Test
	public void testBxImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bx");
		
		elem.setAttributeNS(null, "id", "1");
		try {
			BxImpl bx = new BxImpl(elem);
			assertEquals(new IdImpl("1"), bx.getId());
			assertEquals(new CloneImpl(Clone.Value.YES), bx.getClone());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.setTextContent("abc");
		try {
			new BxImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}
	
	@Test
	public void testGetChildren() {
		BxImpl bx = createDefaultBx();
		assertEquals(new ArrayList<Node>(), bx.getChildren());
	}
	
	@Test
	public void testCloneAttr() {
		BxImpl bx = createDefaultBx();
		bx.setClone(new CloneImpl(Clone.Value.NO));
		assertEquals(new CloneImpl(Clone.Value.NO), bx.getClone());
		bx.setClone(null);
		assertEquals(new CloneImpl(Clone.Value.YES), bx.getClone());
	}
	
	@Test
	public void testCtype() {
		BxImpl bx = createDefaultBx();
		bx.setCtype(new CtypeDelimImpl("139"));
		assertEquals(new CtypeDelimImpl("139"), bx.getCtype());
		bx.setCtype(null);
		assertNull(bx.getCtype());
	}
	
	@Test
	public void testGetPlainText() {
		BxImpl bx = createDefaultBx();
		bx.setEquivText(new EquivTextImpl("something"));
		assertEquals("something", bx.getPlainText());
		bx.setEquivText(null);
		assertEquals("", bx.getPlainText());
	}
	
	@Test
	public void testRid() {
		BxImpl bx = createDefaultBx();
		bx.setRid(new RidImpl("rid"));
		assertEquals(new RidImpl("rid"), bx.getRid());
		bx.setRid(null);
		assertNull(bx.getRid());
	}
	
	@Test
	public void testClone() {
		BxImpl bx = createDefaultBx();
		BxImpl clone = (BxImpl) bx.clone();
		assertEquals(bx, clone);
		assertNotSame(bx, clone);
	}
	
	private BxImpl createDefaultBx() {
		BxImpl bx = new BxImpl(new IdImpl("1"));
		return bx;
	}

}
