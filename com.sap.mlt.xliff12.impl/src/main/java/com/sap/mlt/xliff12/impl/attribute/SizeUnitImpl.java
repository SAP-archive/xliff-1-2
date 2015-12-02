package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class SizeUnitImpl extends XTendableAttributeImpl implements SizeUnit {

	public SizeUnitImpl(Value value) {
		super(NAME, value);
	}
	
	public SizeUnitImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
