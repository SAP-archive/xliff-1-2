package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.HelpId;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class HelpIdImpl extends XliffAttributeImpl implements HelpId {

	public HelpIdImpl(String helpId) {
		super(NAME, helpId);
		Assert.isNmtoken(helpId, "helpId");
	}

}
