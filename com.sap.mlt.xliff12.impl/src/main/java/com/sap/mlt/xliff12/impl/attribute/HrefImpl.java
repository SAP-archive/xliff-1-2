package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Href;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class HrefImpl extends XliffAttributeImpl implements Href {

	public HrefImpl(String href) {
		super(NAME, href);
	}
	
}
