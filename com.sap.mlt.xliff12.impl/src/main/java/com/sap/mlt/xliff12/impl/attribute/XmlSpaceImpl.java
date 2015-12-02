package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.impl.base.EnumeratedXmlAttributeImpl;

public class XmlSpaceImpl extends EnumeratedXmlAttributeImpl implements
		XmlSpace {

	public XmlSpaceImpl(Value value) {
		super(NAME, value);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}

}
