package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MinBytes;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MinBytesImpl extends XliffAttributeImpl implements MinBytes {

	public MinBytesImpl(String minBytes) {
		super(NAME, minBytes);
		Assert.isNmtoken(minBytes, "minBytes");
	}
	
}
