package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProcessNameImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class PhaseGroupImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testPhaseGroupImplListOfPhase() {
		PhaseGroupImpl pg = createDefaultPhaseGroup();
		assertEquals(createDefaultPhases(), pg.getPhases());
	}

	@Test
	public void testPhaseGroupImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "phase-group");
		Element phase = doc.createElementNS(XLIFF_12_NAMESPACE, "phase");
		phase.setAttributeNS(null, "phase-name", "phaseName");
		phase.setAttributeNS(null, "process-name", "processName");
		elem.appendChild(phase);
		try {
			PhaseGroupImpl pg = new PhaseGroupImpl(elem);
			assertEquals(createDefaultPhases(), pg.getPhases());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		try {
			new PhaseGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new PhaseGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		PhaseGroupImpl pg = createDefaultPhaseGroup();
		List<? extends Node> children = pg.getChildren();
		assertEquals(createDefaultPhases(), children);
	}

	@Test
	public void testPhases() {
		PhaseGroupImpl pg = createDefaultPhaseGroup();
		try {
			ArrayList<Phase> phases = new ArrayList<Phase>();
			pg.setPhases(phases);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		ArrayList<Phase> phases = new ArrayList<Phase>();
		phases.add(new PhaseImpl(new PhaseNameImpl("phase1"),
				new ProcessNameImpl("process1")));
		phases.add(new PhaseImpl(new PhaseNameImpl("phase2"),
				new ProcessNameImpl("process2")));
		pg.setPhases(phases);
		assertEquals(phases, pg.getPhases());
	}
	
	@Test
	public void testClone() {
		PhaseGroupImpl pg = createDefaultPhaseGroup();
		PhaseGroupImpl clone = (PhaseGroupImpl) pg.clone();
		assertEquals(pg, clone);
		assertNotSame(pg, clone);
	}

	private PhaseGroupImpl createDefaultPhaseGroup() {
		return new PhaseGroupImpl(createDefaultPhases());
	}

	private List<Phase> createDefaultPhases() {
		PhaseImpl phase = new PhaseImpl(new PhaseNameImpl("phaseName"),
				new ProcessNameImpl("processName"));
		ArrayList<Phase> phases = new ArrayList<Phase>();
		phases.add(phase);
		return phases;
	}

}
