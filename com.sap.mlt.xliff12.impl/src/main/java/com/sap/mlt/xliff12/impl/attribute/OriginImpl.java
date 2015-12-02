package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Origin;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class OriginImpl extends XliffAttributeImpl implements Origin {

	public OriginImpl(String origin) {
		super(NAME, origin);
	}
	
}
