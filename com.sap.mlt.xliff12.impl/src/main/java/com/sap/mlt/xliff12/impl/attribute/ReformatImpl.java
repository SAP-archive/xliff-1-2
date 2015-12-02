package com.sap.mlt.xliff12.impl.attribute;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.impl.base.MultiXtendableAttributeImpl;

public class ReformatImpl extends MultiXtendableAttributeImpl implements
		Reformat {

	public ReformatImpl(Collection<Value> values, Collection<String> xtendValues) {
		super(NAME, values, xtendValues);
	}

	public boolean canAllPropertiesBeReformatted() {
		return false;
	}

	public boolean shouldNoPropertiesBeReformatted() {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Value> getEnumValues() {
		return (List<Value>) super.getEnumValues();
	}
}
