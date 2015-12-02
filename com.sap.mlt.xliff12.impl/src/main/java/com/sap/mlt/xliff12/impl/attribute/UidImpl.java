package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Uid;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class UidImpl extends XliffAttributeImpl implements Uid {

	public UidImpl(String uid) {
		super(NAME, uid);
		Assert.isNmtoken(uid, "uid");
	}
	
}
