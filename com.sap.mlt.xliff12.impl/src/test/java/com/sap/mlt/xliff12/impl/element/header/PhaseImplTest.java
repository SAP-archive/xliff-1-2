package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CompanyNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactEmailImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactPhoneImpl;
import com.sap.mlt.xliff12.impl.attribute.DateImpl;
import com.sap.mlt.xliff12.impl.attribute.JobIdImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProcessNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.DateTime;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class PhaseImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testPhaseImplPhaseNameProcessName() {
		PhaseImpl phase = createDefaultPhase();
		assertEquals(new PhaseNameImpl("phaseName"), phase.getPhaseName());
		assertEquals(new ProcessNameImpl("processName"), phase.getProcessName());
	}

	@Test
	public void testPhaseImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "phase");
		elem.setAttributeNS(null, "phase-name", "phaseName");
		elem.setAttributeNS(null, "process-name", "processName");
		
		try {
			PhaseImpl phase = new PhaseImpl(elem);
			assertEquals(new PhaseNameImpl("phaseName"), phase.getPhaseName());
			assertEquals(new ProcessNameImpl("processName"), phase.getProcessName());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(new NoteImpl(new TextImpl("note")).asXmlNode(doc));
		try {
			PhaseImpl phase = new PhaseImpl(elem);
			assertEquals(new PhaseNameImpl("phaseName"), phase.getPhaseName());
			assertEquals(new ProcessNameImpl("processName"), phase.getProcessName());
			List<Note> notes = phase.getNotes();
			assertEquals(new Integer(1), new Integer(notes.size()));
			assertEquals(new NoteImpl(new TextImpl("note")), notes.get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new PhaseImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
	}

	@Test
	public void testGetChildren() {
		PhaseImpl phase = createDefaultPhase();
		assertTrue(phase.getChildren().isEmpty());
		phase.setNotes(createDefaultNotes());
		assertEquals(createDefaultNotes(), phase.getNotes());
	}

	@Test
	public void testCompanyName() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getCompanyName());
		phase.setCompanyName(new CompanyNameImpl("abc"));
		assertEquals(new CompanyNameImpl("abc"), phase.getCompanyName());
		phase.setCompanyName(null);
		assertNull(phase.getCompanyName());
	}

	@Test
	public void testContactEmail() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getContactEmail());
		phase.setContactEmail(new ContactEmailImpl("a@b.c"));
		assertEquals(new ContactEmailImpl("a@b.c"), phase.getContactEmail());
		phase.setContactEmail(null);
		assertNull(phase.getContactEmail());
	}

	@Test
	public void testContactName() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getContactName());
		phase.setContactName(new ContactNameImpl("abc"));
		assertEquals(new ContactNameImpl("abc"), phase.getContactName());
		phase.setContactName(null);
		assertNull(phase.getContactName());
	}

	@Test
	public void testContactPhone() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getContactPhone());
		phase.setContactPhone(new ContactPhoneImpl("abc"));
		assertEquals(new ContactPhoneImpl("abc"), phase.getContactPhone());
		phase.setContactPhone(null);
		assertNull(phase.getContactPhone());
	}

	@Test
	public void testDate() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getDate());
		Date date = DateTime.parseDate("2010-01-01T12:00:00Z");
		phase.setDate(new DateImpl(date));
		assertEquals(new DateImpl(date), phase.getDate());
		phase.setDate(null);
		assertNull(phase.getDate());
	}

	@Test
	public void testJobId() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getJobId());
		phase.setJobId(new JobIdImpl("abc"));
		assertEquals(new JobIdImpl("abc"), phase.getJobId());
		phase.setJobId(null);
		assertNull(phase.getJobId());
	}

	@Test
	public void testNotes() {
		PhaseImpl phase = createDefaultPhase();
		assertTrue(phase.getNotes().isEmpty());
		phase.setNotes(createDefaultNotes());
		assertEquals(createDefaultNotes(), phase.getNotes());
		phase.setNotes(new ArrayList<Note>());
		assertTrue(phase.getNotes().isEmpty());
	}

	@Test
	public void testPhaseName() {
		PhaseImpl phase = createDefaultPhase();
		try {
			phase.setPhaseName(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		phase.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), phase.getPhaseName());
	}

	@Test
	public void testProcessName() {
		PhaseImpl phase = createDefaultPhase();
		try {
			phase.setProcessName(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		phase.setProcessName(new ProcessNameImpl("abc"));
		assertEquals(new ProcessNameImpl("abc"), phase.getProcessName());
	}

	@Test
	public void testTool() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getTool());
		phase.setTool(new ToolImpl("abc"));
		assertEquals(new ToolImpl("abc"), phase.getTool());
		phase.setTool(null);
		assertNull(phase.getTool());
	}

	@Test
	public void testToolId() {
		PhaseImpl phase = createDefaultPhase();
		assertNull(phase.getToolId());
		phase.setToolId(new ToolIdImpl("abc"));
		assertEquals(new ToolIdImpl("abc"), phase.getToolId());
		phase.setToolId(null);
		assertNull(phase.getToolId());
	}
	
	@Test
	public void testClone() {
		PhaseImpl phase = createDefaultPhase();
		phase.setNotes(createDefaultNotes());
		PhaseImpl clone = (PhaseImpl) phase.clone();
		assertEquals(phase, clone);
		assertNotSame(phase, clone);
	}

	private PhaseImpl createDefaultPhase() {
		return new PhaseImpl(new PhaseNameImpl("phaseName"),
				new ProcessNameImpl("processName"));
	}
	
	private List<Note> createDefaultNotes() {
		ArrayList<Note> notes = new ArrayList<Note>();
		notes.add(new NoteImpl(new TextImpl("note")));
		notes.add(new NoteImpl(new TextImpl("note2")));
		return notes;
	}
}
