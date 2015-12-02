package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class PhaseNameImpl extends XliffAttributeImpl implements PhaseName {

	public PhaseNameImpl(String phaseName) {
		super(NAME, phaseName);
		Assert.isNmtoken(phaseName, "phaseName");
	}
	
}
