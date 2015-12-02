package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class StyleImpl extends XliffAttributeImpl implements Style {

	public StyleImpl(String style) {
		super(NAME, style);
		Assert.isNmtoken(style, "style");
	}
	
}
