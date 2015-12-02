package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ToolVersion;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ToolVersionImpl extends XliffAttributeImpl implements ToolVersion {

	public ToolVersionImpl(String toolVersion) {
		super(NAME, toolVersion);
	}

}
