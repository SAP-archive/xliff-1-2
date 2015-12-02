package com.sap.mlt.xliff12.impl.base;

import java.util.Collection;

import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.util.Assert;

public abstract class InlineBaseImpl extends XliffElementImpl implements
		InlineBase {

	protected InlineBaseImpl(String name, Id id) {
		super(name);
		setId(id);
	}

	protected InlineBaseImpl(String name, org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(name, element);
	}

	public EquivText getEquivText() {
		return (EquivText) getXliffAttribute(EquivText.NAME);
	}

	public Id getId() {
		return (Id) getXliffAttribute(Id.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public Xid getXid() {
		return (Xid) getXliffAttribute(Xid.NAME);
	}

	public void setEquivText(EquivText equivText) {
		if (equivText == null) {
			clearXliffAttribute(EquivText.NAME);
		} else {
			setAttribute(equivText);
		}
	}

	public void setId(Id id) {
		Assert.notNull(id, "id");
		setAttribute(id);
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
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

	public void setXid(Xid xid) {
		if (xid == null) {
			clearXliffAttribute(Xid.NAME);
		} else {
			setAttribute(xid);
		}
	}

}
