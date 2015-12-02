package com.sap.mlt.xliff12.impl.factory;

import com.sap.mlt.xliff12.api.factory.AttributeFactory;
import com.sap.mlt.xliff12.api.factory.ElementFactory;
import com.sap.mlt.xliff12.api.factory.TextFactory;
import com.sap.mlt.xliff12.api.factory.XliffFactory;
import com.sap.mlt.xliff12.api.persistence.XliffDeserializer;
import com.sap.mlt.xliff12.api.persistence.XliffSerializer;
import com.sap.mlt.xliff12.impl.persistence.XliffDeserializerImpl;
import com.sap.mlt.xliff12.impl.persistence.XliffSerializerImpl;

public class XliffFactoryImpl extends XliffFactory {

	private static final String IMPLEMENTATION_VERSION = "2.1.1";
	
	public XliffFactoryImpl() {
	}
	
	@Override
	public String getImplementationVersion() {
		return IMPLEMENTATION_VERSION;
	}
	
	@Override
	public AttributeFactory getAttributeFactory() {
		return AttributeFactoryImpl.getInstance();
	}

	@Override
	public ElementFactory getElementFactory() {
		return ElementFactoryImpl.getInstance();
	}

	@Override
	public TextFactory getTextFactory() {
		return TextFactoryImpl.getInstance();
	}

	@Override
	public XliffDeserializer getDeserializer() {
		return XliffDeserializerImpl.getInstance();
	}

	@Override
	public XliffSerializer getSerializer() {
		return XliffSerializerImpl.getInstance();
	}

}
