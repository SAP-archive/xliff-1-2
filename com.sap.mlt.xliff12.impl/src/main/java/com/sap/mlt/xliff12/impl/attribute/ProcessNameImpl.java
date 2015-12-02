package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ProcessName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ProcessNameImpl extends XliffAttributeImpl implements ProcessName {

	public ProcessNameImpl(String processName) {
		super(NAME, processName);
	}
	
}
