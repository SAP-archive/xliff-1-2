package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class RidImpl extends XliffAttributeImpl implements Rid {

	public RidImpl(String rid) {
		super(NAME, rid);
		Assert.isNmtoken(rid, "rid");
	}
	
}
