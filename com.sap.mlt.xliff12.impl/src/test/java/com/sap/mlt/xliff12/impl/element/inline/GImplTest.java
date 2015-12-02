package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CloneImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class GImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testGImplIdListOfQextendsTextFragment() {
		GImpl g = createDefaultG();
		assertEquals(new IdImpl("1"), g.getId());
		assertEquals(new CloneImpl(Clone.Value.YES), g.getClone());
		assertEquals(createDefaultContent(), g.getContent());
	}

	@Test
	public void testGImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "g");
		
		elem.setAttributeNS(null, "id", "1");
		List<TextFragment> fragments = createDefaultContent();
		for (TextFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}
		
		try {
			GImpl g = new GImpl(elem);
			assertEquals(new IdImpl("1"), g.getId());
			assertEquals(new CloneImpl(Clone.Value.YES), g.getClone());
			assertEquals(createDefaultContent(), g.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testGetChildren() {
		GImpl g = createDefaultG();
		assertEquals(createDefaultContent(), g.getChildren());
	}
	
	@Test
	public void testCloneAttr() {
		GImpl g = createDefaultG();
		g.setClone(new CloneImpl(Clone.Value.NO));
		assertEquals(new CloneImpl(Clone.Value.NO), g.getClone());
		g.setClone(null);
		assertEquals(new CloneImpl(Clone.Value.YES), g.getClone());
	}
	
	@Test
	public void testContent() {
		GImpl g = createDefaultG();
		assertEquals(createDefaultContent(), g.getContent());
		g.setContent(new ArrayList<TextFragment>());
		assertEquals(new ArrayList<TextFragment>(), g.getContent());
	}
	
	@Test
	public void testCtype() {
		GImpl g = createDefaultG();
		g.setCtype(new CtypeDelimImpl("139"));
		assertEquals(new CtypeDelimImpl("139"), g.getCtype());
		g.setCtype(null);
		assertNull(g.getCtype());
	}
	
	@Test
	public void testGetPlainText() {
		GImpl g = createDefaultG();
		assertEquals("cont", g.getPlainText());
	}
	
	@Test
	public void testClone() {
		GImpl g = createDefaultG();
		GImpl clone = (GImpl) g.clone();
		assertEquals(g, clone);
		assertNotSame(g, clone);
	}
	
	private GImpl createDefaultG() {
		GImpl g = new GImpl(new IdImpl("1"), createDefaultContent());
		return g;
	}
	
	private List<TextFragment> createDefaultContent() {
		List<TextFragment> content = new ArrayList<TextFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
