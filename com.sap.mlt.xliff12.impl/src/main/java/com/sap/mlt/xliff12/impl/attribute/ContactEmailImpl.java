package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ContactEmail;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ContactEmailImpl extends XliffAttributeImpl implements
		ContactEmail {

	public ContactEmailImpl(String contactEmail) {
		super(NAME, contactEmail);
	}
	
}
