package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Form;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class FormImpl extends XliffAttributeImpl implements Form {

	public FormImpl(String form) {
		super(NAME, form);
	}
	
}
