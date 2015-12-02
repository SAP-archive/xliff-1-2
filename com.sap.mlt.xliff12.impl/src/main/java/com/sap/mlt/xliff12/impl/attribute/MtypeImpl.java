package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class MtypeImpl extends XTendableAttributeImpl implements Mtype {

	public MtypeImpl(Value value) {
		super(NAME, value);
	}
	
	public MtypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
