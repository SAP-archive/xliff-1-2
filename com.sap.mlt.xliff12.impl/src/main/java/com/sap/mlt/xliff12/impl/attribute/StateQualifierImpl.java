package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class StateQualifierImpl extends XTendableAttributeImpl implements StateQualifier {

	public StateQualifierImpl(Value value) {
		super(NAME, value);
	}
	
	public StateQualifierImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
}
