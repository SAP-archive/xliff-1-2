package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class CloneImpl extends EnumeratedXliffAttributeImpl implements Clone {

	public CloneImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
