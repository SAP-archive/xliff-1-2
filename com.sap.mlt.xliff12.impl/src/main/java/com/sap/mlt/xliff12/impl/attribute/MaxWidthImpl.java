package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MaxWidth;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MaxWidthImpl extends XliffAttributeImpl implements MaxWidth {

	public MaxWidthImpl(String maxWidth) {
		super(NAME, maxWidth);
		Assert.isNmtoken(maxWidth, "maxWidth");
	}
	
}
