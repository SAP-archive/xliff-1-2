package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class BptImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBptImplIdListOfQextendsCodeFragment() {
		BptImpl bpt = createDefaultBpt();
		assertEquals(new IdImpl("1"), bpt.getId());
		assertEquals(createDefaultContent(), bpt.getContent());
	}

	@Test
	public void testBptImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bpt");
		
		elem.setAttributeNS(null, "id", "1");
		List<CodeFragment> fragments = createDefaultContent();
		for (CodeFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}
		
		try {
			BptImpl bpt = new BptImpl(elem);
			assertEquals(new IdImpl("1"), bpt.getId());
			assertEquals(createDefaultContent(), bpt.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testGetChildren() {
		BptImpl bpt = createDefaultBpt();
		assertEquals(createDefaultContent(), bpt.getChildren());
	}
	
	@Test
	public void testContent() {
		BptImpl bpt = createDefaultBpt();
		assertEquals(createDefaultContent(), bpt.getContent());
		bpt.setContent(new ArrayList<CodeFragment>());
		assertEquals(new ArrayList<CodeFragment>(), bpt.getContent());
	}
	
	@Test
	public void testCrc() {
		BptImpl bpt = createDefaultBpt();
		bpt.setCrc(new CrcImpl("139"));
		assertEquals(new CrcImpl("139"), bpt.getCrc());
		bpt.setCrc(null);
		assertNull(bpt.getCrc());
	}
	
	@Test
	public void testCtype() {
		BptImpl bpt = createDefaultBpt();
		bpt.setCtype(new CtypeDelimImpl("139"));
		assertEquals(new CtypeDelimImpl("139"), bpt.getCtype());
		bpt.setCtype(null);
		assertNull(bpt.getCtype());
	}
	
	@Test
	public void testGetPlainText() {
		BptImpl bpt = createDefaultBpt();
		assertEquals("cont", bpt.getPlainText());
	}
	
	@Test
	public void testRid() {
		BptImpl bpt = createDefaultBpt();
		bpt.setRid(new RidImpl("rid"));
		assertEquals(new RidImpl("rid"), bpt.getRid());
		bpt.setRid(null);
		assertNull(bpt.getRid());
	}
	
	@Test
	public void testClone() {
		BptImpl bpt = createDefaultBpt();
		BptImpl clone = (BptImpl) bpt.clone();
		assertEquals(bpt, clone);
		assertNotSame(bpt, clone);
	}

	private BptImpl createDefaultBpt() {
		BptImpl bpt = new BptImpl(new IdImpl("1"), createDefaultContent());
		return bpt;
	}
	
	private List<CodeFragment> createDefaultContent() {
		List<CodeFragment> content = new ArrayList<CodeFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
