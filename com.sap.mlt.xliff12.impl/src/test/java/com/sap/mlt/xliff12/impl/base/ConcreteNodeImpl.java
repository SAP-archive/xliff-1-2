package com.sap.mlt.xliff12.impl.base;

import org.junit.Ignore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@Ignore
public class ConcreteNodeImpl extends NodeImpl {

	public ConcreteNodeImpl() {
	}

	@Override
	public Node asXmlNode(Document document) {
		return null;
	}
	
	@Override
	public ConcreteNodeImpl clone() {
		return (ConcreteNodeImpl) super.clone();
	}

}
