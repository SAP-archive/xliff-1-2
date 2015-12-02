package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.AnnotatesImpl;
import com.sap.mlt.xliff12.impl.attribute.FromImpl;
import com.sap.mlt.xliff12.impl.attribute.PriorityImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class NoteImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testNoteImplText() {
		NoteImpl note = createDefaultNote();
		assertEquals(new TextImpl("test"), note.getNote());
		assertEquals(new AnnotatesImpl(Annotates.Value.GENERAL), note.getAnnotates());
		assertNull(note.getFrom());
		assertEquals(new PriorityImpl(1), note.getPriority());
		assertNull(note.getXmlLang());
	}

	@Test
	public void testNoteImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "note");
		elem.setTextContent("test");

		try {
			NoteImpl note = new NoteImpl(elem);
			assertEquals(new TextImpl("test"), note.getNote());
			assertEquals(new AnnotatesImpl(Annotates.Value.GENERAL), note.getAnnotates());
			assertNull(note.getFrom());
			assertEquals(new PriorityImpl(1), note.getPriority());
			assertNull(note.getXmlLang());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new NoteImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.removeChild(elem.getLastChild());
		try {
			NoteImpl note = new NoteImpl(elem);
			assertEquals(new TextImpl(""), note.getNote());
			assertEquals(new AnnotatesImpl(Annotates.Value.GENERAL), note.getAnnotates());
			assertNull(note.getFrom());
			assertEquals(new PriorityImpl(1), note.getPriority());
			assertNull(note.getXmlLang());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new NoteImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
	}
	
	@Test
	public void testGetChildren() {
		NoteImpl note = createDefaultNote();
		List<? extends Node> children = note.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(new TextImpl("test"), children.get(0));
	}
	
	@Test
	public void testAnnotates() {
		NoteImpl note = createDefaultNote();
		note.setAnnotates(new AnnotatesImpl(Annotates.Value.SOURCE));
		assertEquals(new AnnotatesImpl(Annotates.Value.SOURCE), note.getAnnotates());
		note.setAnnotates(null);
		assertEquals(new AnnotatesImpl(Annotates.Value.GENERAL), note.getAnnotates());
	}
	
	@Test
	public void testFrom() {
		NoteImpl note = createDefaultNote();
		note.setFrom(new FromImpl("xyz"));
		assertEquals(new FromImpl("xyz"), note.getFrom());
		note.setFrom(null);
		assertNull(note.getFrom());
	}
	
	@Test
	public void testNote() {
		NoteImpl note = createDefaultNote();
		try {
			note.setNote(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		note.setNote(new TextImpl("notetest"));
		assertEquals(new TextImpl("notetest"), note.getNote());
	}
	
	@Test
	public void testPriority() {
		NoteImpl note = createDefaultNote();
		note.setPriority(new PriorityImpl(10));
		assertEquals(new PriorityImpl(10), note.getPriority());
		note.setPriority(null);
		assertEquals(new PriorityImpl(1), note.getPriority());
	}
	
	@Test
	public void testXmlLang() {
		NoteImpl note = createDefaultNote();
		note.setXmlLang(new XmlLangImpl(Locale.US));
		assertEquals(new XmlLangImpl(Locale.US), note.getXmlLang());
		note.setXmlLang(null);
		assertNull(note.getXmlLang());
	}
	
	@Test
	public void testClone() {
		NoteImpl note = createDefaultNote();
		NoteImpl clone = (NoteImpl) note.clone();
		assertEquals(note, clone);
		assertNotSame(note, clone);
	}
	
	private NoteImpl createDefaultNote() {
		return new NoteImpl(new TextImpl("test"));
	}

}
