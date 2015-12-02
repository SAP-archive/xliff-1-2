package com.sap.mlt.xliff12.impl.element.inline;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.AssocImpl;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypePhImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class PhImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testPhImplIdListOfQextendsCodeFragment() {
		PhImpl ph = createDefaultPh();
		assertEquals(new IdImpl("1"), ph.getId());
		assertEquals(createDefaultContent(), ph.getContent());
	}

	@Test
	public void testPhImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ph");

		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "ctype", "x-abc");
		List<CodeFragment> fragments = createDefaultContent();
		for (CodeFragment fragment : fragments) {
			elem.appendChild(fragment.asXmlNode(doc));
		}

		try {
			PhImpl ph = new PhImpl(elem);
			assertEquals(new IdImpl("1"), ph.getId());
			assertEquals(new CtypePhImpl("abc"), ph.getCtype());
			assertEquals(createDefaultContent(), ph.getContent());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.setAttributeNS(null, "ctype", "bold");
		try {
			new PhImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		elem.setAttributeNS(null, "ctype", "image");
		try {
			new PhImpl(elem);
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		PhImpl ph = createDefaultPh();
		assertEquals(createDefaultContent(), ph.getChildren());
	}

	@Test
	public void testAssoc() {
		PhImpl ph = createDefaultPh();
		ph.setAssoc(new AssocImpl(Assoc.Value.FOLLOWING));
		assertEquals(new AssocImpl(Assoc.Value.FOLLOWING), ph.getAssoc());
		ph.setAssoc(null);
		assertNull(ph.getAssoc());
	}

	@Test
	public void testContent() {
		PhImpl ph = createDefaultPh();
		assertEquals(createDefaultContent(), ph.getContent());
		ph.setContent(new ArrayList<CodeFragment>());
		assertEquals(new ArrayList<CodeFragment>(), ph.getContent());
	}

	@Test
	public void testCrc() {
		PhImpl ph = createDefaultPh();
		ph.setCrc(new CrcImpl("139"));
		assertEquals(new CrcImpl("139"), ph.getCrc());
		ph.setCrc(null);
		assertNull(ph.getCrc());
	}

	@Test
	public void testCtype() {
		PhImpl ph = createDefaultPh();
		ph.setCtype(new CtypePhImpl("139"));
		assertEquals(new CtypePhImpl("139"), ph.getCtype());
		ph.setCtype(null);
		assertNull(ph.getCtype());
	}

	@Test
	public void testGetPlainText() {
		PhImpl ph = createDefaultPh();
		assertEquals("cont", ph.getPlainText());
	}
	
	@Test
	public void testClone() {
		PhImpl ph = createDefaultPh();
		PhImpl clone = (PhImpl) ph.clone();
		assertEquals(ph, clone);
		assertNotSame(ph, clone);
	}

	private PhImpl createDefaultPh() {
		PhImpl ph = new PhImpl(new IdImpl("1"), createDefaultContent());
		return ph;
	}

	private List<CodeFragment> createDefaultContent() {
		List<CodeFragment> content = new ArrayList<CodeFragment>();
		content.add(new TextImpl("cont"));
		return content;
	}

}
