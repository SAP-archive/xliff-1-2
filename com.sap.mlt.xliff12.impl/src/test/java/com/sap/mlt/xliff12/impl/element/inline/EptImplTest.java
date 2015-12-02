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
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class EptImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testEptImplIdListOfQextendsCodeFragment() {
		EptImpl ept = createDefaultEpt();
		assertEquals(new IdImpl("1"), ept.getId());
		assertEquals(createDefaultContent(), ept.getContent());
	}

	@Test
	public void testEptImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ept");
		
		elem.setAttributeNS(null, "id", "1");
		List<CodeFragment> fragments = createDefaultContent();
		for (CodeFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}
		
		try {
			EptImpl ept = new EptImpl(elem);
			assertEquals(new IdImpl("1"), ept.getId());
			assertEquals(createDefaultContent(), ept.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testGetChildren() {
		EptImpl ept = createDefaultEpt();
		assertEquals(createDefaultContent(), ept.getChildren());
	}
	
	@Test
	public void testContent() {
		EptImpl ept = createDefaultEpt();
		assertEquals(createDefaultContent(), ept.getContent());
		ept.setContent(new ArrayList<CodeFragment>());
		assertEquals(new ArrayList<CodeFragment>(), ept.getContent());
	}
	
	@Test
	public void testCrc() {
		EptImpl ept = createDefaultEpt();
		ept.setCrc(new CrcImpl("139"));
		assertEquals(new CrcImpl("139"), ept.getCrc());
		ept.setCrc(null);
		assertNull(ept.getCrc());
	}
	
	@Test
	public void testGetPlainText() {
		EptImpl ept = createDefaultEpt();
		assertEquals("cont", ept.getPlainText());
	}
	
	@Test
	public void testRid() {
		EptImpl ept = createDefaultEpt();
		ept.setRid(new RidImpl("rid"));
		assertEquals(new RidImpl("rid"), ept.getRid());
		ept.setRid(null);
		assertNull(ept.getRid());
	}
	
	@Test
	public void testClone() {
		EptImpl ept = createDefaultEpt();
		EptImpl clone = (EptImpl) ept.clone();
		assertEquals(ept, clone);
		assertNotSame(ept, clone);
	}
	
	private EptImpl createDefaultEpt() {
		EptImpl ept = new EptImpl(new IdImpl("1"), createDefaultContent());
		return ept;
	}
	
	private List<CodeFragment> createDefaultContent() {
		List<CodeFragment> content = new ArrayList<CodeFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
