package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Category;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CategoryImpl extends XliffAttributeImpl implements Category {
	
	public CategoryImpl(String category) {
		super(NAME, category);
	}
	
}
