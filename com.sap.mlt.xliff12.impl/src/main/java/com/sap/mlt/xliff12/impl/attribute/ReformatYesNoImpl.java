package com.sap.mlt.xliff12.impl.attribute;

import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ReformatYesNoImpl extends XliffAttributeImpl implements Reformat {

	public ReformatYesNoImpl(boolean allPropertiesCanBeReformatted) {
		super(NAME, allPropertiesCanBeReformatted? "yes": "no");
		this.allPropertiesCanBeReformatted = allPropertiesCanBeReformatted;
	}
	
	private boolean allPropertiesCanBeReformatted;
	
	public boolean canAllPropertiesBeReformatted() {
		return allPropertiesCanBeReformatted;
	}

	public boolean shouldNoPropertiesBeReformatted() {
		return !allPropertiesCanBeReformatted;
	}

	public List<Value> getEnumValues() {
		return Collections.emptyList();
	}

	public List<String> getXtendValues() {
		return Collections.emptyList();
	}

}
