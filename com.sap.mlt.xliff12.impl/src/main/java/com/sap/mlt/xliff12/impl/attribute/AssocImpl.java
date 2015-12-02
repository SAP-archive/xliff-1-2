package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class AssocImpl extends EnumeratedXliffAttributeImpl implements Assoc {

	public static final String NAME = "assoc";

	public AssocImpl(Value value) {
		super(NAME, value);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
}
