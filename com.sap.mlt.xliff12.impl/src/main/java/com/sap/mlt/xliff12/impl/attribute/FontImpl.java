package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class FontImpl extends XliffAttributeImpl implements Font {

	public FontImpl(String font) {
		super(NAME, font);
	}
	
}
