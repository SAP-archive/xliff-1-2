package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class MimeTypeImpl extends XliffAttributeImpl implements MimeType {

	public MimeTypeImpl(String mimeType) {
		super(NAME, mimeType);
	}
	
}
