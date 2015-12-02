package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CompanyName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CompanyNameImpl extends XliffAttributeImpl implements CompanyName {

	public CompanyNameImpl(String companyName) {
		super(NAME, companyName);
	}
	
}
