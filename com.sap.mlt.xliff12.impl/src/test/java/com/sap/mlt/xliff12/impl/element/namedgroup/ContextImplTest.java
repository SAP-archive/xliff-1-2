package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.MatchMandatoryImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ContextImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testContextImplContextTypeText() {
		ContextImpl context = createDefaultContext();
		assertEquals(new ContextTypeImpl(ContextType.Value.LINENUMBER), context
				.getContextType());
		assertEquals(new TextImpl("cont"), context.getContent());
		assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.NO), context
				.getMatchMandatory());
	}

	@Test
	public void testContextImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "context");
		elem.setAttributeNS(null, "context-type", "linenumber");

		try {
			ContextImpl context = new ContextImpl(elem);
			assertEquals(new ContextTypeImpl(ContextType.Value.LINENUMBER),
					context.getContextType());
			assertEquals(new TextImpl(""), context.getContent());
			assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.NO),
					context.getMatchMandatory());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not Expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new ContextImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}
		
		elem.appendChild(doc.createTextNode("cont"));
		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new ContextImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
			elem.removeChild(elem.getFirstChild());
		}

		elem.appendChild(doc.createTextNode("cont"));
		try {
			ContextImpl context = new ContextImpl(elem);
			assertEquals(new ContextTypeImpl(ContextType.Value.LINENUMBER), context
					.getContextType());
			assertEquals(new TextImpl("cont"), context.getContent());
			assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.NO), context
					.getMatchMandatory());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not Expect ConstraintViolationException");
		}
		
	}

	@Test
	public void testGetChildren() {
		ContextImpl context = createDefaultContext();
		ArrayList<TextImpl> expected = new ArrayList<TextImpl>();
		expected.add(new TextImpl("cont"));
		assertEquals(expected, context.getChildren());
	}

	@Test
	public void testContent() {
		ContextImpl context = createDefaultContext();
		try {
			context.setContent(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new TextImpl("cont"), context.getContent());
		
		context.setContent(new TextImpl("abc"));
		assertEquals(new TextImpl("abc"), context.getContent());
	}

	@Test
	public void testContextType() {
		ContextImpl context = createDefaultContext();
		try {
			context.setContextType(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new ContextTypeImpl(ContextType.Value.LINENUMBER), context
				.getContextType());
		
		context.setContextType(new ContextTypeImpl("abc"));
		assertEquals(new ContextTypeImpl("abc"), context
				.getContextType());
	}

	@Test
	public void testCrc() {
		ContextImpl context = createDefaultContext();
		context.setCrc(new CrcImpl("12345"));
		assertEquals(new CrcImpl("12345"), context.getCrc());
		context.setCrc(null);
		assertNull(context.getCrc());
	}

	@Test
	public void testMatchMandatory() {
		ContextImpl context = createDefaultContext();
		context.setMatchMandatory(new MatchMandatoryImpl(MatchMandatory.Value.YES));
		assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.YES), context
				.getMatchMandatory());
		context.setMatchMandatory(null);
		assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.NO), context
				.getMatchMandatory());
	}
	
	@Test
	public void testClone() {
		ContextImpl context = createDefaultContext();
		ContextImpl clone = (ContextImpl) context.clone();
		assertEquals(context, clone);
		assertNotSame(context, clone);
	}

	private ContextImpl createDefaultContext() {
		ContextImpl context = new ContextImpl(new ContextTypeImpl(
				ContextType.Value.LINENUMBER), new TextImpl("cont"));
		return context;
	}

}
