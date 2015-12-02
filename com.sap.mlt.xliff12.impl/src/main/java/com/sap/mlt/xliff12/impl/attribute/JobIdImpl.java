package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.JobId;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class JobIdImpl extends XliffAttributeImpl implements JobId {

	public JobIdImpl(String jobId) {
		super(NAME, jobId);
	}
	
}
