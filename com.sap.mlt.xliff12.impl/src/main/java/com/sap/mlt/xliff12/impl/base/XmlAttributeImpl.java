package com.sap.mlt.xliff12.impl.base;

import com.sap.mlt.xliff12.api.base.XmlAttribute;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public abstract class XmlAttributeImpl extends AttributeImpl implements XmlAttribute {

	protected XmlAttributeImpl(String name, String value) {
		super(Schemas.XML_NAMESPACE, "xml", name, value);
	}
	
}
