package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class CountGroupImpl extends XliffElementImpl implements CountGroup {

	public CountGroupImpl(Name name, List<Count> counts) {
		super(NAME);
		setCountGroupName(name);
		setCounts(counts);
	}

	public CountGroupImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	private ArrayList<Count> counts;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Name.NAME);
		Assert.xliffAttrRestricted(element, false, false, false, Name.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		CountGroupImpl source = (CountGroupImpl) elem;
		counts = new ArrayList<Count>();
		for (Count count : source.counts) {
			counts.add((Count) count.clone());
		}
		attach(counts);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(counts);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		counts = new ArrayList<Count>();
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		counts.add(new CountImpl(iter.getXliffElement(Count.NAME)));
		while (iter.hasNext()) {
			counts.add(new CountImpl(iter.getXliffElement(Count.NAME)));
		}
		attach(counts);
	}

	public Name getCountGroupName() {
		return (Name) getXliffAttribute(Name.NAME);
	}

	public List<Count> getCounts() {
		return Collections.unmodifiableList(counts);
	}

	public void setCountGroupName(Name name) {
		Assert.notNull(name, "name");
		setAttribute(name);
	}

	public void setCounts(List<Count> counts) {
		Assert.notNull(counts, "counts");
		if (counts.isEmpty()) {
			throw new IllegalArgumentException(
					"A count-group must contain at least one count element");
		}
		Assert.areInstances(counts, "counts", CountImpl.class);
		assertNotAttached(counts);
		detach(this.counts);
		this.counts = new ArrayList<Count>(counts);
		attach(this.counts);
	}

}
