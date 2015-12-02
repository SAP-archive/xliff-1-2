package com.sap.mlt.xliff12.impl.base;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public abstract class EnumeratedXliffAttributeImpl extends AttributeImpl
		implements XliffAttribute, EnumeratedAttribute {

	protected EnumeratedXliffAttributeImpl(String name, Enum<?> enumValue) {
		super(Schemas.XLIFF_12_NAMESPACE, null, name, enumValue.toString());
		this.enumValue = enumValue;
	}

	private Enum<?> enumValue;

	public Enum<?> getEnumValue() {
		return enumValue;
	}
}
