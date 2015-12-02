package com.sap.mlt.xliff12.impl.base;

import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.impl.util.Assert;

public abstract class NodeImpl implements Node {

	private Element parent;

	public abstract org.w3c.dom.Node asXmlNode(Document document);

	public Element getParentElement() {
		return parent;
	}

	public void setParentElement(Element parent) {
		Assert.isInstance(parent, "parent", ElementImpl.class);
		if (parent == null) {
			this.parent = null;
			return;
		}
		if ((this.parent != null) && (parent != this.parent)) {
			throw new IllegalArgumentException(
					"This node is already owned by a different element");
		}
		this.parent = parent;
	}

	public Object clone() {
		try {
			NodeImpl clone = (NodeImpl) super.clone();
			clone.parent = null;
			return clone;
		} catch (CloneNotSupportedException e) {
			//$JL-EXC$
			throw new AssertionError(e);
		}
	}

}
