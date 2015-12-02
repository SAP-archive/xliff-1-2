package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.attribute.UnitImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class CountImpl extends XliffElementImpl implements Count {

	public CountImpl(CountType countType, Text number) {
		super(NAME);
		setCountType(countType);
		setNumber(number);
	}

	public CountImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private Text number;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, CountType.NAME);
		Assert.xliffAttrRestricted(element, false, false, false,
				CountType.NAME, PhaseName.NAME, Unit.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		CountImpl source = (CountImpl) elem;
		number = (Text) source.number.clone();
		attach(number);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(number);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		number = new TextImpl(iter.getText());
		iter.assertNoMoreNodes();
		attach(number);
	}

	public CountType getCountType() {
		return (CountType) getXliffAttribute(CountType.NAME);
	}

	public Text getNumber() {
		return number;
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public Unit getUnit() {
		return (Unit) getXliffAttribute(Unit.NAME);
	}

	public void setCountType(CountType countType) {
		Assert.notNull(countType, "countType");
		setAttribute(countType);
	}

	public void setNumber(Text number) {
		Assert.notNull(number, "number");
		Assert.isInstance(number, "number", TextImpl.class);
		assertNotAttached(number);
		detach(this.number);
		this.number = number;
		attach(this.number);
	}

	public void setPhaseName(PhaseName phaseName) {
		if (phaseName == null) {
			clearXliffAttribute(PhaseName.NAME);
		} else {
			setAttribute(phaseName);
		}
	}

	public void setUnit(Unit unit) {
		if (unit == null) {
			setAttribute(new UnitImpl(Unit.Value.WORD));
		} else {
			setAttribute(unit);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.singleton(new UnitImpl(Unit.Value.WORD));
	}
}
