package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class AnnotatesImpl extends EnumeratedXliffAttributeImpl implements Annotates {

	public AnnotatesImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
