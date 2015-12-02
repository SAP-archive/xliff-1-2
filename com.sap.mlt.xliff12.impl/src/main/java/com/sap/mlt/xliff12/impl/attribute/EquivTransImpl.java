package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class EquivTransImpl extends EnumeratedXliffAttributeImpl implements
		EquivTrans {

	public EquivTransImpl(Value value) {
		super(NAME, value);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}

}
