package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class MatchMandatoryImpl extends EnumeratedXliffAttributeImpl implements MatchMandatory {

	public MatchMandatoryImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
