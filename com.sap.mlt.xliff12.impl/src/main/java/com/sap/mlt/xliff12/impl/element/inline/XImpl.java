package com.sap.mlt.xliff12.impl.element.inline;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.inline.X;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CloneImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypePhImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.InlineBaseImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class XImpl extends InlineBaseImpl implements X {

	public XImpl(Id id) {
		super(NAME, id);
	}

	public XImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);

		// Fix wrong CtypeDelim attribute
		XliffAttribute xa = getXliffAttribute(CtypeDelim.NAME);
		if (xa instanceof CtypeDelim) {
			CtypeDelim ctype = (CtypeDelim) xa;
			if (!ctype.isXTended()) {
				String msg = MessageFormat.format(
						"Attribute ''ctype'' contains invalid value ''{0}''",
						ctype.getEnumValue().toString());
				throw new ConstraintViolationException(msg);
			}
			CtypePhImpl ctypePh = new CtypePhImpl(ctype.getXtendValue());
			setAttribute(ctypePh);
		}
	}

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME,
				CtypePh.NAME, Ts.NAME, Clone.NAME, Xid.NAME, EquivText.NAME);
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

	public Clone getClone() {
		return (Clone) getXliffAttribute(Clone.NAME);
	}

	public CtypePh getCtype() {
		return (CtypePh) getXliffAttribute(CtypePh.NAME);
	}

	public String getPlainText() {
		EquivText equivText = getEquivText();
		if (equivText != null) {
			return equivText.getValue();
		}
		return "";
	}

	public void setClone(Clone clone) {
		if (clone == null) {
			setAttribute(new CloneImpl(Clone.Value.YES));
		} else {
			setAttribute(clone);
		}
	}

	public void setCtype(CtypePh ctype) {
		if (ctype == null) {
			clearXliffAttribute(CtypePh.NAME);
		} else {
			setAttribute(ctype);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.singleton(new CloneImpl(Clone.Value.YES));
	}

}
