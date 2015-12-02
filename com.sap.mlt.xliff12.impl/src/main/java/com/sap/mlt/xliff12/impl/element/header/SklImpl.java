package com.sap.mlt.xliff12.impl.element.header;

import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.header.Skl;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class SklImpl extends XliffElementImpl implements Skl {

	public SklImpl(Child child) {
		super(NAME);
		setChild(child);
	}

	public SklImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private Child child;

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		SklImpl source = (SklImpl) elem;
		child = (Child) source.child.clone();
		attach(child);
	}

	@Override
	public List<? extends Element> getChildren() {
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

	public void setChild(Child child) {
		Assert.notNull(child, "child");
		Assert.isInstance(child, "child", InternalFileImpl.class,
				ExternalFileImpl.class);
		assertNotAttached(child);
		detach(this.child);
		this.child = child;
		attach(this.child);
	}

}
