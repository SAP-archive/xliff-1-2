package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class NameImpl extends XliffAttributeImpl implements Name {

	public NameImpl(String name) {
		super(NAME, name);
	}
	
}
