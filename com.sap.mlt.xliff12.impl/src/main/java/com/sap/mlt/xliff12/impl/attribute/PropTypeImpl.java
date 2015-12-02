package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.PropType;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

/**
 * @deprecated
 */
public class PropTypeImpl extends XliffAttributeImpl implements PropType {

	public PropTypeImpl(String propType) {
		super(NAME, propType);
	}
	
}
