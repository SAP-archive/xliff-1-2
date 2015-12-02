package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ResNameImpl extends XliffAttributeImpl implements ResName {

	public ResNameImpl(String resname) {
		super(NAME, resname);
	}
	
}
