package com.sap.mlt.xliff12.impl.element.structural;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.structural.BinSource;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class BinSourceImpl extends XliffElementImpl implements BinSource {

	public BinSourceImpl(Child child) {
		super(NAME);
		setChild(child);
	}

	public BinSourceImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private Child child;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, false, false, Ts.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		BinSourceImpl source = (BinSourceImpl) elem;
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

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public Ts getTs() {
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

	public void setTs(Ts ts) {
		if (ts == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

}
