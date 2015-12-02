package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ToolIdImpl extends XliffAttributeImpl implements ToolId {

	public ToolIdImpl(String toolId) {
		super(NAME, toolId);
	}

}
