package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ContactName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ContactNameImpl extends XliffAttributeImpl implements
		ContactName {

	public ContactNameImpl(String contactName) {
		super(NAME, contactName);
	}
	
}
