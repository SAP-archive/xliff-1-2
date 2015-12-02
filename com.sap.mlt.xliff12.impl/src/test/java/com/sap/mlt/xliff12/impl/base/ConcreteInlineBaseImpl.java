package com.sap.mlt.xliff12.impl.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.text.TextImpl;

@Ignore
public class ConcreteInlineBaseImpl extends InlineBaseImpl {

	public ConcreteInlineBaseImpl(String name, Id id) {
		super(name, id);
	}

	public ConcreteInlineBaseImpl(String name, Element element)
			throws ConstraintViolationException {
		super(name, element);
	}

	private ArrayList<Node> children;

	public void addChild(Node node) {
		children.add(node);
	}

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
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
		for (org.w3c.dom.Node node : elementsAndText) {
			if (node instanceof org.w3c.dom.Element) {
				org.w3c.dom.Element elem = (org.w3c.dom.Element) node;
				children.add(new ConcreteElementImpl(elem.getNamespaceURI(),
						elem.getLocalName(), elem));
			} else if (node instanceof org.w3c.dom.Text) {
				children.add(new TextImpl(node.getTextContent()));
			}
		}
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		ConcreteInlineBaseImpl source = (ConcreteInlineBaseImpl) elem;
		
		children = new ArrayList<Node>();
		for (Node child : source.children) {
			children.add((Node) child.clone());
		}
		attach(children);
	}

}
