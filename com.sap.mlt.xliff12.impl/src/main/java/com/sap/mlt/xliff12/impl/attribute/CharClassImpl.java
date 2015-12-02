package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CharClass;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CharClassImpl extends XliffAttributeImpl implements CharClass {

	public CharClassImpl(String charClass) {
		super(NAME, charClass);
	}
	
}
