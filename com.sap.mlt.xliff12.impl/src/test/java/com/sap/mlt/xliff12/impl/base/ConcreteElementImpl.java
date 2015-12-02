/**
 * 
 */
package com.sap.mlt.xliff12.impl.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.text.TextImpl;

@Ignore
public class ConcreteElementImpl extends ElementImpl {

	public ConcreteElementImpl(String namespaceUri, String prefix, String name) {
		super(namespaceUri, prefix, name);
		children = new ArrayList<Node>();
	}

	public ConcreteElementImpl(String namespaceUri, String name,
			org.w3c.dom.Element xmlElement) throws ConstraintViolationException {
		super(namespaceUri, name, xmlElement);
	}

	private ArrayList<Node> children;

	public void addChild(Node node) {
		children.add(node);
	}

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(children);
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		ArrayList<Attribute> defaults = new ArrayList<Attribute>();
		defaults.add(new ConcreteAttributeImpl("ns", "pre", "defaultattr",
				"defaultvalue"));
		return defaults;
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
		ConcreteElementImpl source = (ConcreteElementImpl) elem;
		children = new ArrayList<Node>();
		for (Node child : source.children) {
			children.add((Node) child.clone());
		}
		attach(children);		
	}
	
	@Override
	public ConcreteElementImpl clone() {
		return (ConcreteElementImpl) super.clone();
	}
}