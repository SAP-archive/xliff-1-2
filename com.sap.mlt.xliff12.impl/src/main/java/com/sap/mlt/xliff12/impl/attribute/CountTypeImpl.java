package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class CountTypeImpl extends XTendableAttributeImpl implements CountType {

	public CountTypeImpl(Value value) {
		super(NAME, value);
	}
	
	public CountTypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
