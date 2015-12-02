package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ToolNameImpl extends XliffAttributeImpl implements ToolName {

	public ToolNameImpl(String toolName) {
		super(NAME, toolName);
	}

}
