package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.XidImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class SubImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testSubImplIdListOfQextendsTextFragment() {
		SubImpl sub = createDefaultSub();
		assertEquals(createDefaultContent(), sub.getContent());
	}

	@Test
	public void testSubImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "sub");
		
		List<TextFragment> fragments = createDefaultContent();
		for (TextFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}
		
		try {
			SubImpl sub = new SubImpl(elem);
			assertEquals(createDefaultContent(), sub.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testGetChildren() {
		SubImpl sub = createDefaultSub();
		assertEquals(createDefaultContent(), sub.getChildren());
	}
	
	@Test
	public void testContent() {
		SubImpl sub = createDefaultSub();
		assertEquals(createDefaultContent(), sub.getContent());
		sub.setContent(new ArrayList<TextFragment>());
		assertEquals(new ArrayList<TextFragment>(), sub.getContent());
	}
	
	@Test
	public void testCtype() {
		SubImpl sub = createDefaultSub();
		sub.setCtype(new CtypeDelimImpl("139"));
		assertEquals(new CtypeDelimImpl("139"), sub.getCtype());
		sub.setCtype(null);
		assertNull(sub.getCtype());
	}
	
	@Test
	public void testDataType() {
		SubImpl sub = createDefaultSub();
		sub.setDataType(new DataTypeImpl("dt"));
		assertEquals(new DataTypeImpl("dt"), sub.getDataType());
		sub.setDataType(null);
		assertNull(sub.getDataType());
	}
	
	@Test
	public void testGetPlainText() {
		SubImpl sub = createDefaultSub();
		assertEquals("cont", sub.getPlainText());
	}
	
	@Test
	public void testXid() {
		SubImpl sub = createDefaultSub();
		sub.setXid(new XidImpl("dt"));
		assertEquals(new XidImpl("dt"), sub.getXid());
		sub.setXid(null);
		assertNull(sub.getXid());
	}
	
	@Test
	public void testClone() {
		SubImpl sub = createDefaultSub();
		SubImpl clone = (SubImpl) sub.clone();
		assertEquals(sub, clone);
		assertNotSame(sub, clone);
	}
	
	private SubImpl createDefaultSub() {
		SubImpl sub = new SubImpl(createDefaultContent());
		return sub;
	}
	
	private List<TextFragment> createDefaultContent() {
		List<TextFragment> content = new ArrayList<TextFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
