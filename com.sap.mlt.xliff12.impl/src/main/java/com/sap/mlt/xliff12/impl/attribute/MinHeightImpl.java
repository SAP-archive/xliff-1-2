package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MinHeight;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MinHeightImpl extends XliffAttributeImpl implements MinHeight {

	public MinHeightImpl(String minHeight) {
		super(NAME, minHeight);
		Assert.isNmtoken(minHeight, "minHeight");
	}
	
}
