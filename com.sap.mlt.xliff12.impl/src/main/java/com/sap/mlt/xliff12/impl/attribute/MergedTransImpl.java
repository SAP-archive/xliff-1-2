package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MergedTrans;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class MergedTransImpl extends EnumeratedXliffAttributeImpl implements MergedTrans {

	public MergedTransImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
