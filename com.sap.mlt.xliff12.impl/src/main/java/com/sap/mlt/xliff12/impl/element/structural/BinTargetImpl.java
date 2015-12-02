package com.sap.mlt.xliff12.impl.element.structural;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class BinTargetImpl extends XliffElementImpl implements BinTarget {

	public BinTargetImpl(Child child) {
		super(NAME);
		setChild(child);
	}

	public BinTargetImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private Child child;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, false, false, MimeType.NAME,
				Ts.NAME, State.NAME, PhaseName.NAME, ResType.NAME,
				ResName.NAME, StateQualifier.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		BinTargetImpl source = (BinTargetImpl) elem;
		child = (Child) source.child.clone();
		attach(child);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(child);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		org.w3c.dom.Element element = iter.getXliffElement(InternalFile.NAME,
				ExternalFile.NAME);
		String name = element.getLocalName();
		if (InternalFile.NAME.equals(name)) {
			child = new InternalFileImpl(element);
		} else {
			child = new ExternalFileImpl(element);
		}
		iter.assertNoMoreNodes();
		attach(child);
	}

	public Child getChild() {
		return child;
	}


	public MimeType getMimeType() {
		return (MimeType) getXliffAttribute(MimeType.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public ResName getResName() {
		return (ResName) getXliffAttribute(ResName.NAME);
	}

	public ResType getResType() {
		return (ResType) getXliffAttribute(ResType.NAME);
	}

	public State getState() {
		return (State) getXliffAttribute(State.NAME);
	}

	public StateQualifier getStateQualifier() {
		return (StateQualifier) getXliffAttribute(StateQualifier.NAME);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public void setChild(Child child) {
		Assert.notNull(child, "child");
		Assert.isInstance(child, "child", InternalFileImpl.class,
				ExternalFileImpl.class);
		assertNotAttached(child);
		detach(this.child);
		this.child = child;
		attach(this.child);
	}

	public void setMimeType(MimeType mimeType) {
		if (mimeType == null) {
			clearXliffAttribute(MimeType.NAME);
		} else {
			setAttribute(mimeType);
		}
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Assert.notNull(nonXliffAttributes, "nonXliffAttributes");
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	public void setPhaseName(PhaseName phaseName) {
		if (phaseName == null) {
			clearXliffAttribute(PhaseName.NAME);
		} else {
			setAttribute(phaseName);
		}
	}

	public void setResName(ResName resName) {
		if (resName == null) {
			clearXliffAttribute(ResName.NAME);
		} else {
			setAttribute(resName);
		}
	}

	public void setResType(ResType resType) {
		if (resType == null) {
			clearXliffAttribute(ResType.NAME);
		} else {
			setAttribute(resType);
		}
	}

	public void setState(State state) {
		if (state == null) {
			clearXliffAttribute(State.NAME);
		} else {
			setAttribute(state);
		}
	}

	public void setStateQualifier(StateQualifier stateQualifier) {
		if (stateQualifier == null) {
			clearXliffAttribute(StateQualifier.NAME);
		} else {
			setAttribute(stateQualifier);
		}
	}

	/**
	 * @deprecated
	 */
	public void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts) {
		if (ts == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

}
