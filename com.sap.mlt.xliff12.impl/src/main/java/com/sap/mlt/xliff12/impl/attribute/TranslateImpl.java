package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.impl.base.EnumeratedXliffAttributeImpl;

public class TranslateImpl extends EnumeratedXliffAttributeImpl implements Translate {

	public TranslateImpl(Value value) {
		super(NAME, value);
	}
	
	public Value getEnumValue() {
		return (Value) (Object) super.getEnumValue();
	}
	
}
