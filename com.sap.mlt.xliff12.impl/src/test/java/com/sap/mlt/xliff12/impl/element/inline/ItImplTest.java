package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.PosImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ItImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testItImplIdListOfQextendsCodeFragment() {
		ItImpl it = createDefaultIt();
		assertEquals(new IdImpl("1"), it.getId());
		assertEquals(new PosImpl(Pos.Value.OPEN), it.getPos());
		assertEquals(createDefaultContent(), it.getContent());
	}

	@Test
	public void testItImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "it");

		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "pos", "open");
		List<CodeFragment> fragments = createDefaultContent();
		for (CodeFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}

		try {
			ItImpl it = new ItImpl(elem);
			assertEquals(new IdImpl("1"), it.getId());
			assertEquals(new PosImpl(Pos.Value.OPEN), it.getPos());
			assertEquals(createDefaultContent(), it.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		ItImpl it = createDefaultIt();
		assertEquals(createDefaultContent(), it.getChildren());
	}

	@Test
	public void testContent() {
		ItImpl it = createDefaultIt();
		assertEquals(createDefaultContent(), it.getContent());
		it.setContent(new ArrayList<CodeFragment>());
		assertEquals(new ArrayList<CodeFragment>(), it.getContent());
	}

	@Test
	public void testCrc() {
		ItImpl it = createDefaultIt();
		it.setCrc(new CrcImpl("139"));
		assertEquals(new CrcImpl("139"), it.getCrc());
		it.setCrc(null);
		assertNull(it.getCrc());
	}

	@Test
	public void testCtype() {
		ItImpl it = createDefaultIt();
		it.setCtype(new CtypeDelimImpl("139"));
		assertEquals(new CtypeDelimImpl("139"), it.getCtype());
		it.setCtype(null);
		assertNull(it.getCtype());
	}

	@Test
	public void testGetPlainText() {
		ItImpl it = createDefaultIt();
		assertEquals("cont", it.getPlainText());
	}

	@Test
	public void testPos() {
		ItImpl it = createDefaultIt();
		try {
			it.setPos(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new PosImpl(Pos.Value.OPEN), it.getPos());
		it.setPos(new PosImpl(Pos.Value.CLOSE));
		assertEquals(new PosImpl(Pos.Value.CLOSE), it.getPos());
	}

	@Test
	public void testRid() {
		ItImpl it = createDefaultIt();
		it.setRid(new RidImpl("rid"));
		assertEquals(new RidImpl("rid"), it.getRid());
		it.setRid(null);
		assertNull(it.getRid());
	}
	
	@Test
	public void testClone() {
		ItImpl it = createDefaultIt();
		ItImpl clone = (ItImpl) it.clone();
		assertEquals(it, clone);
		assertNotSame(it, clone);
	}

	private ItImpl createDefaultIt() {
		ItImpl it = new ItImpl(new IdImpl("1"), new PosImpl(Pos.Value.OPEN),
				createDefaultContent());
		return it;
	}

	private List<CodeFragment> createDefaultContent() {
		List<CodeFragment> content = new ArrayList<CodeFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
