package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class XidImpl extends XliffAttributeImpl implements Xid {

	public XidImpl(String xid) {
		super(NAME, xid);
	}
	
}
