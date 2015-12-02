package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CssStyleImpl extends XliffAttributeImpl implements CssStyle {

	public CssStyleImpl(String cssStyle) {
		super(NAME, cssStyle);
	}
	
}
