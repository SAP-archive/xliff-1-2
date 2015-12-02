package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class IdImpl extends XliffAttributeImpl implements Id {

	public IdImpl(String id) {
		super(NAME, id);
	}
	
}
