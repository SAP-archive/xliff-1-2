package com.sap.mlt.xliff12.impl.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sap.mlt.xliff12.api.factory.AttributeFactory;
import com.sap.mlt.xliff12.api.factory.ElementFactory;
import com.sap.mlt.xliff12.api.factory.TextFactory;
import com.sap.mlt.xliff12.api.persistence.XliffDeserializer;
import com.sap.mlt.xliff12.api.persistence.XliffSerializer;
import com.sap.mlt.xliff12.impl.persistence.XliffDeserializerImpl;
import com.sap.mlt.xliff12.impl.persistence.XliffSerializerImpl;


public class XliffFactoryImplTest {

	@Test
	public void testXliffFactory() {
		
		XliffFactoryImpl factory = new XliffFactoryImpl();
		
		String version = factory.getImplementationVersion();
		assertNotNull(version);
		
		AttributeFactory attrFactory = factory.getAttributeFactory();
		assertTrue(attrFactory instanceof AttributeFactoryImpl);
		
		ElementFactory elemFactory = factory.getElementFactory();
		assertTrue(elemFactory instanceof ElementFactoryImpl);
		
		TextFactory textFactory = factory.getTextFactory();
		assertTrue(textFactory instanceof TextFactoryImpl);
		
		XliffDeserializer deserializer = factory.getDeserializer();
		assertTrue(deserializer instanceof XliffDeserializerImpl);
		
		XliffSerializer serializer = factory.getSerializer();
		assertTrue(serializer instanceof XliffSerializerImpl);
	}
	
	
}
