package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class DataTypeImpl extends XTendableAttributeImpl implements DataType {

	public DataTypeImpl(Value value) {
		super(NAME, value);
	}
	
	public DataTypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
