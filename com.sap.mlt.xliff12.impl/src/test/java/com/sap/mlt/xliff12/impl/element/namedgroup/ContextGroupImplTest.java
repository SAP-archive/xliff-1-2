package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.PurposeImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ContextGroupImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testContextGroupImplListOfContext() {
		ContextGroupImpl cg = createDefaultContextGroup();
		assertEquals(createDefaultContexts(), cg.getContexts());
	}

	@Test
	public void testContextGroupImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "context-group");

		try {
			new ContextGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultContext().asXmlNode(doc));
		try {
			ContextGroupImpl cg = new ContextGroupImpl(elem);
			assertEquals(createDefaultContexts(), cg.getContexts());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new ContextGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		ContextGroupImpl cg = createDefaultContextGroup();
		assertEquals(createDefaultContexts(), cg.getChildren());
	}

	@Test
	public void testContextGroupName() {
		ContextGroupImpl cg = createDefaultContextGroup();
		cg.setContextGroupName(new NameImpl("abc"));
		assertEquals(new NameImpl("abc"), cg.getContextGroupName());
		cg.setContextGroupName(null);
		assertNull(cg.getContextGroupName());
	}

	@Test
	public void testContexts() {
		ContextGroupImpl cg = createDefaultContextGroup();
		try {
			cg.setContexts(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			cg.setContexts(new ArrayList<Context>());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultContexts(), cg.getContexts());
		
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts.add(createDefaultContext());
		contexts.add(createDefaultContext());
		cg.setContexts(contexts);
		assertEquals(contexts, cg.getContexts());
	}

	@Test
	public void testCrc() {
		ContextGroupImpl cg = createDefaultContextGroup();
		cg.setCrc(new CrcImpl("12345"));
		assertEquals(new CrcImpl("12345"), cg.getCrc());
		cg.setCrc(null);
		assertNull(cg.getCrc());
	}

	@Test
	public void testPurpose() {
		ContextGroupImpl cg = createDefaultContextGroup();
		ArrayList<Purpose.Value> purposes = new ArrayList<Purpose.Value>();
		purposes.add(Purpose.Value.LOCATION);
		ArrayList<String> xtends = new ArrayList<String>();
		cg.setPurpose(new PurposeImpl(purposes, xtends));
		assertEquals(new PurposeImpl(purposes, xtends), cg.getPurpose());
		cg.setPurpose(null);
		assertNull(cg.getPurpose());
	}
	
	@Test
	public void testClone() {
		ContextGroupImpl cg = createDefaultContextGroup();
		ContextGroupImpl clone = (ContextGroupImpl) cg.clone();
		assertEquals(cg, clone);
		assertNotSame(cg, clone);
	}

	private ContextGroupImpl createDefaultContextGroup() {
		ContextGroupImpl contextGroup = new ContextGroupImpl(
				createDefaultContexts());
		return contextGroup;
	}

	private ArrayList<Context> createDefaultContexts() {
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts.add(createDefaultContext());
		return contexts;
	}

	private ContextImpl createDefaultContext() {
		ContextImpl context = new ContextImpl(new ContextTypeImpl(
				ContextType.Value.ELEMENT), new TextImpl("context"));
		return context;
	}

}
