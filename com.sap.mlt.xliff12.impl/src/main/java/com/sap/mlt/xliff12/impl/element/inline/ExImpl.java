package com.sap.mlt.xliff12.impl.element.inline;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.inline.Ex;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.InlineBaseImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class ExImpl extends InlineBaseImpl implements Ex {

	public ExImpl(Id id) {
		super(NAME, id);
	}

	public ExImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME,
				Rid.NAME, Ts.NAME, Xid.NAME, EquivText.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl source) {
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.emptyList();
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		iter.assertNoMoreNodes();
	}

	public String getPlainText() {
		EquivText equivText = getEquivText();
		if (equivText != null) {
			return equivText.getValue();
		}
		return "";
	}

	public Rid getRid() {
		return (Rid) getXliffAttribute(Rid.NAME);
	}

	public void setRid(Rid rid) {
		if (rid == null) {
			clearXliffAttribute(Rid.NAME);
		} else {
			setAttribute(rid);
		}
	}

}
