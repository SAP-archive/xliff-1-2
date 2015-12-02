package com.sap.mlt.xliff12.impl.element.nonxliff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.factory.ElementFactory;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.factory.ElementFactoryImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class NonXliffElementImpl extends ElementImpl implements NonXliffElement {

	public NonXliffElementImpl(String namespaceUri, String prefix, String name,
			Collection<? extends Attribute> attributes, List<? extends Node> children) {
		super(namespaceUri, prefix, name);
		if (Schemas.XLIFF_12_NAMESPACE.equals(namespaceUri)) {
			throw new IllegalArgumentException(
					"Namespace must not be the XLIFF namespace");
		}
		Assert.notNull(attributes, "attributes");
		Assert.notNull(children, "children");
		for (Attribute attr : attributes) {
			setAttribute(attr);
		}
		assertNotAttached(children);
		this.children = new ArrayList<Node>(children);
		attach(this.children);
	}
	
	public NonXliffElementImpl(org.w3c.dom.Element xmlElement) throws ConstraintViolationException {
		super(xmlElement.getNamespaceURI(), xmlElement.getLocalName(), xmlElement);
		if (Schemas.XLIFF_12_NAMESPACE.equals(xmlElement.getNamespaceURI())) {
			throw new ConstraintViolationException(
					"Namespace must not be the XLIFF namespace");
		}
	}
	
	private ArrayList<Node> children;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		NonXliffElementImpl source = (NonXliffElementImpl) elem;
		children = new ArrayList<Node>();
		for (Node node : source.children) {
			children.add((Node) node.clone());
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
		children = new ArrayList<Node>();
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		ElementFactory elemFactory = ElementFactoryImpl.getInstance();
		while (iter.hasNext()) {
			if (iter.nextIsElement()) {
				children.add(elemFactory.createElement(iter.getElement()));
			} else {
				children.add(new TextImpl(iter.getText()));
			}
		}
		attach(children);
	}

}
