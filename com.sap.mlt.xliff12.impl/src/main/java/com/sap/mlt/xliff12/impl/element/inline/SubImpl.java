package com.sap.mlt.xliff12.impl.element.inline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.inline.Sub;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class SubImpl extends XliffElementImpl implements Sub {

	public SubImpl(List<? extends TextFragment> content) {
		super(NAME);
		setContent(content);
	}
	
	public SubImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<TextFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false, DataType.NAME,
				CtypeDelim.NAME, Xid.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		SubImpl source = (SubImpl) elem;
		content = new ArrayList<TextFragment>();
		for (TextFragment tf : source.content) {
			content.add((TextFragment) tf.clone());
		}
		attach(content);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(content);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		content = CommonsParser.parseTextFragments(elementsAndText);
		attach(content);
	}

	public List<? extends TextFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public CtypeDelim getCtype() {
		return (CtypeDelim) getXliffAttribute(CtypeDelim.NAME);
	}

	public DataType getDataType() {
		return (DataType) getXliffAttribute(DataType.NAME);
	}

	public Xid getXid() {
		return (Xid) getXliffAttribute(Xid.NAME);
	}

	public void setContent(List<? extends TextFragment> content) {
		Assert.notNull(content, "content");
		Assert.areInstances(content, "content", TextImpl.class, BptImpl.class,
				BxImpl.class, EptImpl.class, ExImpl.class, GImpl.class,
				ItImpl.class, MrkImpl.class, PhImpl.class, XImpl.class);
		assertNotAttached(content);
		detach(this.content);
		this.content = new ArrayList<TextFragment>(content);
		attach(this.content);
	}

	public void setCtype(CtypeDelim ctype) {
		if (ctype == null) {
			clearXliffAttribute(CtypeDelim.NAME);
		} else {
			setAttribute(ctype);
		}
	}

	public void setDataType(DataType dataType) {
		if (dataType == null) {
			clearXliffAttribute(DataType.NAME);
		} else {
			setAttribute(dataType);
		}
	}

	public void setXid(Xid xid) {
		if (xid == null) {
			clearXliffAttribute(Xid.NAME);
		} else {
			setAttribute(xid);
		}
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (TextFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

}
