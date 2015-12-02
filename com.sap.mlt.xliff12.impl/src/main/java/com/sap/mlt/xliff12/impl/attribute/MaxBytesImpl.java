package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MaxBytes;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MaxBytesImpl extends XliffAttributeImpl implements MaxBytes {

	public MaxBytesImpl(String maxBytes) {
		super(NAME, maxBytes);
		Assert.isNmtoken(maxBytes, "maxBytes");
	}
	
}
