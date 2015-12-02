package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class PropGroupImpl extends XliffElementImpl implements PropGroup {

	public PropGroupImpl(List<Prop> props) {
		super(NAME);
		setProps(props);
	}

	public PropGroupImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	private ArrayList<Prop> props;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false, Name.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		PropGroupImpl source = (PropGroupImpl) elem;
		props = new ArrayList<Prop>();
		for (Prop prop : source.props) {
			props.add((Prop) prop.clone());
		}
		attach(props);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(props);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		props = new ArrayList<Prop>();
		
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		props.add(new PropImpl(iter.getXliffElement(Prop.NAME)));
		while (iter.hasNext()) {
			props.add(new PropImpl(iter.getXliffElement(Prop.NAME)));
		}
		
		attach(props);
	}

	public Name getPropGroupName() {
		return (Name) getXliffAttribute(Name.NAME);
	}

	public List<Prop> getProps() {
		return Collections.unmodifiableList(props);
	}

	public void setPropGroupName(Name name) {
		if (name == null) {
			clearXliffAttribute(Name.NAME);
		} else {
			setAttribute(name);
		}
	}

	public void setProps(List<Prop> props) {
		Assert.notNull(props, "props");
		if (props.isEmpty()) {
			throw new IllegalArgumentException(
					"A prop-group must contain at least one prop");
		}
		Assert.areInstances(props, "props", PropImpl.class);
		assertNotAttached(props);
		detach(this.props);
		this.props = new ArrayList<Prop>(props);
		attach(this.props);
	}

}
