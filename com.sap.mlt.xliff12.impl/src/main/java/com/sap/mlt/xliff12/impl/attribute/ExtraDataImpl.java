package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ExtraData;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ExtraDataImpl extends XliffAttributeImpl implements ExtraData {

	public ExtraDataImpl(String extraData) {
		super(NAME, extraData);
	}
	
}
