package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MatchQuality;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class MatchQualityImpl extends XliffAttributeImpl implements
		MatchQuality {

	public MatchQualityImpl(String matchQuality) {
		super(NAME, matchQuality);
	}
	
}
