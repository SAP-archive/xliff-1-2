package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class VersionImpl extends EnumeratedXliffAttributeImpl implements Version {

	public VersionImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
