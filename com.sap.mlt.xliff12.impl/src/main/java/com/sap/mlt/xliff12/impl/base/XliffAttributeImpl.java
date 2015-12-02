package com.sap.mlt.xliff12.impl.base;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public abstract class XliffAttributeImpl extends AttributeImpl implements XliffAttribute {

	protected XliffAttributeImpl(String name, String value) {
		super(Schemas.XLIFF_12_NAMESPACE, null, name, value);
	}
	
}
