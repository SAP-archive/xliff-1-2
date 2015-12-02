package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class CtypePhImpl extends XTendableAttributeImpl implements
		CtypePh {
	
	public CtypePhImpl(Value value) {
		super(NAME, value);
	}
	
	public CtypePhImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
