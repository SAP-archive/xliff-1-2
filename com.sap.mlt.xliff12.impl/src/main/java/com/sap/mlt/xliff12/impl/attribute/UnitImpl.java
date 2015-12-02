package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class UnitImpl extends XTendableAttributeImpl implements Unit {

	public UnitImpl(Value value) {
		super(NAME, value);
	}
	
	public UnitImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
