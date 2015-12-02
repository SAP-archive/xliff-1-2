package com.sap.mlt.xliff12.impl.attribute;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.impl.base.MultiXtendableAttributeImpl;

public class PurposeImpl extends MultiXtendableAttributeImpl implements Purpose {

	public PurposeImpl(Collection<Value> values, Collection<String> xtendValues) {
		super(NAME, values, xtendValues);
	}
	
	@SuppressWarnings("unchecked")
	public List<Value> getEnumValues() {
		return (List<Value>) super.getEnumValues();
	}
	
}
