package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class StateImpl extends XTendableAttributeImpl implements State {

	public StateImpl(Value value) {
		super(NAME, value);
	}
	
	public StateImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
}
