package com.sap.mlt.xliff12.impl.element.structural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Body;
import com.sap.mlt.xliff12.api.element.structural.Group;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class BodyImpl extends XliffElementImpl implements Body {

	public BodyImpl(List<? extends StructuralUnit> children) {
		super(NAME);
		setStructuralUnits(children);
	}

	public BodyImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<StructuralUnit> children;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		BodyImpl source = (BodyImpl) elem;
		children = new ArrayList<StructuralUnit>();
		for (StructuralUnit su : source.children) {
			children.add((StructuralUnit) su.clone());
		}
		attach(children);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(children);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		children = new ArrayList<StructuralUnit>();
		
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.hasNext()) {
			org.w3c.dom.Element element = iter.getXliffElement(Group.NAME, TransUnit.NAME, BinUnit.NAME);
			String name = element.getLocalName();
			if (Group.NAME.equals(name)) {
				children.add(new GroupImpl(element));
			} else if (TransUnit.NAME.equals(name)) {
				children.add(new TransUnitImpl(element));
			} else {
				children.add(new BinUnitImpl(element));
			}
		}
		attach(children);
	}

	public List<? extends StructuralUnit> getStructuralUnits() {
		return Collections.unmodifiableList(children);
	}

	public void setStructuralUnits(List<? extends StructuralUnit> children) {
		Assert.notNull(children, "children");
		Assert.areInstances(children, "children", GroupImpl.class,
				TransUnitImpl.class, BinUnitImpl.class);
		assertNotAttached(children);
		detach(this.children);
		this.children = new ArrayList<StructuralUnit>(children);
		attach(this.children);
	}

}
