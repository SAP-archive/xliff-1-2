package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ContactPhone;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ContactPhoneImpl extends XliffAttributeImpl implements
		ContactPhone {

	public ContactPhoneImpl(String contactPhone) {
		super(NAME, contactPhone);
	}
	
}
