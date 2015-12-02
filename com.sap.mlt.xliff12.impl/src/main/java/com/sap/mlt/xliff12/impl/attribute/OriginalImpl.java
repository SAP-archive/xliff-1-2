package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Original;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class OriginalImpl extends XliffAttributeImpl implements Original {

	public OriginalImpl(String original) {
		super(NAME, original);
	}
	
}
