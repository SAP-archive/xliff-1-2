package com.sap.mlt.xliff12.impl.element.header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.element.header.PhaseGroup;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class PhaseGroupImpl extends XliffElementImpl implements PhaseGroup {

	public PhaseGroupImpl(List<Phase> phases) {
		super(NAME);
		setPhases(phases);
	}

	public PhaseGroupImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<Phase> phases;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		PhaseGroupImpl source = (PhaseGroupImpl) elem;
		phases = new ArrayList<Phase>();
		for (Phase phase : source.phases) {
			phases.add((Phase) phase.clone());
		}
		attach(phases);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(phases);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		phases = new ArrayList<Phase>();
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		phases.add(new PhaseImpl(iter.getXliffElement(Phase.NAME)));
		while (iter.hasNext()) {
			phases.add(new PhaseImpl(iter.getXliffElement(Phase.NAME)));
		}
		attach(phases);
	}

	public List<Phase> getPhases() {
		return Collections.unmodifiableList(phases);
	}

	public void setPhases(List<Phase> phases) {
		Assert.notNull(phases, "phases");
		if (phases.isEmpty()) {
			throw new IllegalArgumentException(
					"A phase-group must contain at least one phase");
		}
		Assert.areInstances(phases, "phases", PhaseImpl.class);
		assertNotAttached(phases);
		detach(this.phases);
		this.phases = new ArrayList<Phase>(phases);
		attach(this.phases);
	}

}
