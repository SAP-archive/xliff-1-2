package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class CtypeDelimImpl extends XTendableAttributeImpl implements
		CtypeDelim {
	
	public CtypeDelimImpl(Value value) {
		super(NAME, value);
	}
	
	public CtypeDelimImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
