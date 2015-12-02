package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.impl.base.AttributeImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public class NonXliffAttributeImpl extends AttributeImpl implements
		NonXliffAttribute {
	
	public NonXliffAttributeImpl(String namespaceUri, String prefix, String name, String value) {
		super(namespaceUri, prefix, name, value);
		if (Schemas.XLIFF_12_NAMESPACE.equals(namespaceUri)) {
			throw new IllegalArgumentException("Non-XLIFF attributes must not be member of the XLIFF namespace");
		} else if (Schemas.XML_NAMESPACE.equals(namespaceUri)) {
			throw new IllegalArgumentException("Non-XLIFF attributes must not be member of the XML namespace");
		} else if (Schemas.XMLNS_NAMESPACE.equals(namespaceUri)) {
			throw new IllegalArgumentException("Non-XLIFF attributes must not be member of the XMLNS namespace");
		}
	}

}
