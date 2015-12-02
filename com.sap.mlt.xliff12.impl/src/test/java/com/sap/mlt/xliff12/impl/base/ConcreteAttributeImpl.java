package com.sap.mlt.xliff12.impl.base;

import org.junit.Ignore;

@Ignore
public class ConcreteAttributeImpl extends AttributeImpl {
	
	public ConcreteAttributeImpl(String namespaceURI, String prefix,
			String name, String value) {
		super(namespaceURI, prefix, name, value);
	}
	
	public ConcreteAttributeImpl clone() {
		return (ConcreteAttributeImpl) super.clone();
	}
}