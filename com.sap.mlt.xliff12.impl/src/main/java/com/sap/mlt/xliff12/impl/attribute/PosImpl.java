package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class PosImpl extends EnumeratedXliffAttributeImpl implements Pos {

	public PosImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
