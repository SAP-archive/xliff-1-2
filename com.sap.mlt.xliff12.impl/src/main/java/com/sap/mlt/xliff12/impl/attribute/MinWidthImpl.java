package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MinWidth;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MinWidthImpl extends XliffAttributeImpl implements MinWidth {

	public MinWidthImpl(String minWidth) {
		super(NAME, minWidth);
		Assert.isNmtoken(minWidth, "minWidth");
	}
	
}
