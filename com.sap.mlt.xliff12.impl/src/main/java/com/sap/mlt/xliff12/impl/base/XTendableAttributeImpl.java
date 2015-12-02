package com.sap.mlt.xliff12.impl.base;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;

public abstract class XTendableAttributeImpl extends XliffAttributeImpl implements
		XliffAttribute, XTendableAttribute {

	protected XTendableAttributeImpl(String name, Enum<?> enumValue) {
		super(name, enumValue.toString());
		this.enumValue = enumValue;
	}

	protected XTendableAttributeImpl(String name, String xtendValue) {
		super(name, "x-" + xtendValue);
		this.xtendValue = xtendValue;
	}

	private Enum<?> enumValue;

	private String xtendValue;

	public String getXtendValue() {
		return xtendValue;
	}

	public boolean isXTended() {
		return (xtendValue != null);
	}

	public Enum<?> getEnumValue() {
		return enumValue;
	}
}
