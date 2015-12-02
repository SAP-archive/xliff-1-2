package com.sap.mlt.xliff12.impl.element.header;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Href;
import com.sap.mlt.xliff12.api.attribute.Uid;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class ExternalFileImpl extends XliffElementImpl implements ExternalFile {

	public ExternalFileImpl(Href href) {
		super(NAME);
		setHref(href);
	}

	public ExternalFileImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Href.NAME);
		Assert.xliffAttrRestricted(element, false, false, false, Href.NAME,
				Uid.NAME, Crc.NAME);
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


	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public Href getHref() {
		return (Href) getXliffAttribute(Href.NAME);
	}

	public Uid getUid() {
		return (Uid) getXliffAttribute(Uid.NAME);
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setHref(Href href) {
		Assert.notNull(href, "href");
		setAttribute(href);
	}

	public void setUid(Uid uid) {
		if (uid == null) {
			clearXliffAttribute(Uid.NAME);
		} else {
			setAttribute(uid);
		}
	}

}
