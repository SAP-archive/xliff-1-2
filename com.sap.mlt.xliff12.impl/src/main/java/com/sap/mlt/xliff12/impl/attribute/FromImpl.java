package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.From;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class FromImpl extends XliffAttributeImpl implements From {

	public FromImpl(String from) {
		super(NAME, from);
	}

}
