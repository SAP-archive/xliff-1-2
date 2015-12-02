package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class ResTypeImpl extends XTendableAttributeImpl implements ResType {

	public ResTypeImpl(Value value) {
		super(NAME, value);		
	}
	
	public ResTypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
