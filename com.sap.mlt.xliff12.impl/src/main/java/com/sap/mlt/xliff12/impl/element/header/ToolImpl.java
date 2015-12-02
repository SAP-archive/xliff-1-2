package com.sap.mlt.xliff12.impl.element.header;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.ToolCompany;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.api.attribute.ToolVersion;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Tool;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.NodeImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class ToolImpl extends XliffElementImpl implements Tool {

	public ToolImpl(ToolId toolId, ToolName toolName) {
		super(NAME);
		children = new ArrayList<Node>();
		setToolId(toolId);
		setToolName(toolName);
	}

	public ToolImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	private ArrayList<Node> children;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, ToolId.NAME, ToolName.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, ToolId.NAME,
				ToolName.NAME, ToolVersion.NAME, ToolCompany.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		ToolImpl source = (ToolImpl) elem;
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

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		children = new ArrayList<Node>();
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.hasNext()) {
			if (iter.nextIsElement()) {
				children
						.add(new NonXliffElementImpl(iter.getNonXliffElement()));
			} else {
				String text = iter.getText();
				children.add(new TextImpl(text));
			}
		}
		attach(children);
	}

	public ToolCompany getToolCompany() {
		return (ToolCompany) getXliffAttribute(ToolCompany.NAME);
	}

	public ToolId getToolId() {
		return (ToolId) getXliffAttribute(ToolId.NAME);
	}

	public ToolName getToolName() {
		return (ToolName) getXliffAttribute(ToolName.NAME);
	}

	public ToolVersion getToolVersion() {
		return (ToolVersion) getXliffAttribute(ToolVersion.NAME);
	}

	public void setChildren(List<? extends Node> children) {
		Assert.notNull(children, "children");
		Assert.areInstances(children, "children", NodeImpl.class);
		assertNotAttached(children);
		detach(this.children);
		this.children = new ArrayList<Node>(children);
		attach(this.children);
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

	public void setToolCompany(ToolCompany toolCompany) {
		if (toolCompany == null) {
			clearXliffAttribute(ToolCompany.NAME);
		} else {
			setAttribute(toolCompany);
		}
	}

	public void setToolId(ToolId toolId) {
		Assert.notNull(toolId, "toolId");
		setAttribute(toolId);
	}

	public void setToolName(ToolName toolName) {
		Assert.notNull(toolName, "toolName");
		setAttribute(toolName);
	}

	public void setToolVersion(ToolVersion toolVersion) {
		if (toolVersion == null) {
			clearXliffAttribute(ToolVersion.NAME);
		} else {
			setAttribute(toolVersion);
		}
	}

}
