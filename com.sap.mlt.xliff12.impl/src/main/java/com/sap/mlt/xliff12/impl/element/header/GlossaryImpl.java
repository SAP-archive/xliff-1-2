package com.sap.mlt.xliff12.impl.element.header;

import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.Glossary;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class GlossaryImpl extends XliffElementImpl implements Glossary {

	public GlossaryImpl(Child child) {
		super(NAME);
		setChild(child);
	}
	
	public GlossaryImpl(org.w3c.dom.Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	private Child child;

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		GlossaryImpl source = (GlossaryImpl) elem;
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
