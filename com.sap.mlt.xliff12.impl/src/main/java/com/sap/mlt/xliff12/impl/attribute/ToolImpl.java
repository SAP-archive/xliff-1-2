package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Tool;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

/**
 * @deprecated
 */
public class ToolImpl extends XliffAttributeImpl implements Tool {

	public ToolImpl(String tool) {
		super(NAME, tool);
	}

}
