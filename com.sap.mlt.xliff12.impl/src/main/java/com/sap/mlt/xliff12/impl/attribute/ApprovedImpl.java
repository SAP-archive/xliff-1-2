package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class ApprovedImpl extends EnumeratedXliffAttributeImpl implements Approved {

	public ApprovedImpl(Value value) {
		super(NAME, value);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
}
