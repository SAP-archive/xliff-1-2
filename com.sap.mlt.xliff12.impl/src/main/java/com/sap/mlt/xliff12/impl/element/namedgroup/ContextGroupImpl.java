package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class ContextGroupImpl extends XliffElementImpl implements ContextGroup {

	public ContextGroupImpl(List<Context> contexts) {
		super(NAME);
		setContexts(contexts);
	}

	public ContextGroupImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<Context> contexts;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false, Crc.NAME,
				Name.NAME, Purpose.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		ContextGroupImpl source = (ContextGroupImpl) elem;
		contexts = new ArrayList<Context>();
		for (Context context : source.contexts) {
			contexts.add((Context) context.clone());
		}
		attach(contexts);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(contexts);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		contexts = new ArrayList<Context>();
		
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		contexts.add(new ContextImpl(iter.getXliffElement(Context.NAME)));
		while (iter.hasNext()) {
			contexts.add(new ContextImpl(iter.getXliffElement(Context.NAME)));
		}
		
		attach(contexts);
	}

	public Name getContextGroupName() {
		return (Name) getXliffAttribute(Name.NAME);
	}

	public List<Context> getContexts() {
		return Collections.unmodifiableList(contexts);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public Purpose getPurpose() {
		return (Purpose) getXliffAttribute(Purpose.NAME);
	}

	public void setContextGroupName(Name name) {
		if (name == null) {
			clearXliffAttribute(Name.NAME);
		} else {
			setAttribute(name);
		}
	}

	public void setContexts(List<Context> contexts) {
		Assert.notNull(contexts, "contexts");
		if (contexts.isEmpty()) {
			throw new IllegalArgumentException(
					"A context-group must contain at least one context");
		}
		Assert.areInstances(contexts, "contexts", ContextImpl.class);
		assertNotAttached(contexts);
		detach(this.contexts);
		this.contexts = new ArrayList<Context>(contexts);
		attach(this.contexts);
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setPurpose(Purpose purpose) {
		if (purpose == null) {
			clearXliffAttribute(Purpose.NAME);
		} else {
			setAttribute(purpose);
		}
	}

}
