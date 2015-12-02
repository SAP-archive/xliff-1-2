package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.BuildNum;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class BuildNumImpl extends XliffAttributeImpl implements BuildNum {
	
	public BuildNumImpl(String buildNum) {
		super(NAME, buildNum);
	}
	
}
