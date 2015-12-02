package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Mid;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class MidImpl extends XliffAttributeImpl implements Mid {

	public MidImpl(String mid) {
		super(NAME, mid);
		Assert.isNmtoken(mid, "mid");
	}

}
