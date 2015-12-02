package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class EquivTextImpl extends XliffAttributeImpl implements EquivText {
	
	public EquivTextImpl(String equivText) {
		super(NAME, equivText);
	}
	
}
