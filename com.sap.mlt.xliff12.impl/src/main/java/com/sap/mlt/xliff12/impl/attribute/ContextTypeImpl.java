package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class ContextTypeImpl extends XTendableAttributeImpl implements
		ContextType {
	
	public ContextTypeImpl(Value enumValue) {
		super(NAME, enumValue);
	}
	
	public ContextTypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
