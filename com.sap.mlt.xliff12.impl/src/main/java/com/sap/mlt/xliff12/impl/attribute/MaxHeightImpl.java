package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MaxHeight;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MaxHeightImpl extends XliffAttributeImpl implements MaxHeight {

	public MaxHeightImpl(String maxHeight) {
		super(NAME, maxHeight);
		Assert.isNmtoken(maxHeight, "maxHeight");
	}
	
}
