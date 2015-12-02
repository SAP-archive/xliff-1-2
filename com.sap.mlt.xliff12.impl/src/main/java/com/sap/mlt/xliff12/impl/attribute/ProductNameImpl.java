package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ProductName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ProductNameImpl extends XliffAttributeImpl implements ProductName {

	public ProductNameImpl(String productName) {
		super(NAME, productName);
	}
	
}
