package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.ProductVersion;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class ProductVersionImpl extends XliffAttributeImpl implements
		ProductVersion {

	public ProductVersionImpl(String productVersion) {
		super(NAME, productVersion);
	}

}
