package com.sap.mlt.xliff12.impl.base;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XmlAttribute;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public abstract class EnumeratedXmlAttributeImpl extends AttributeImpl implements
		XmlAttribute, EnumeratedAttribute {

	protected EnumeratedXmlAttributeImpl(String name, Enum<?> enumValue) {
		super(Schemas.XML_NAMESPACE, "xml", name, enumValue.toString());
		this.enumValue = enumValue;
	}

	private Enum<?> enumValue;

	public Enum<?> getEnumValue() {
		return enumValue;
	}
}
