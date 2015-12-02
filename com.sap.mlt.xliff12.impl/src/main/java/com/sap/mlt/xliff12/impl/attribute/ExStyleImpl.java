package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class ExStyleImpl extends XliffAttributeImpl implements ExStyle {

	public ExStyleImpl(String exstyle) {
		super(NAME, exstyle);
		Assert.isNmtoken(exstyle, "exstyle");
	}

}
