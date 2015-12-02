package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class XmlAttributeImplTest {

	static private final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";

	@Test
	public void testXmlAttributeImpl() {
		ConcreteXmlAttributeImpl attr = new ConcreteXmlAttributeImpl("lang", "en");
		assertEquals(XML_NAMESPACE, attr.getNamespaceUri());
		assertEquals("xml", attr.getPrefix());
		assertEquals("lang", attr.getName());
		assertEquals("en", attr.getValue());
	}

}
