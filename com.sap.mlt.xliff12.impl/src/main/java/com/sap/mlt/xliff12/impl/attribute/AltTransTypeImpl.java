package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.AltTransType;
import com.sap.mlt.xliff12.impl.base.XTendableAttributeImpl;

public class AltTransTypeImpl extends XTendableAttributeImpl implements AltTransType {

	public AltTransTypeImpl(Value enumValue) {
		super(NAME, enumValue);
	}

	public AltTransTypeImpl(String xtendValue) {
		super(NAME, xtendValue);
	}

	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
}
