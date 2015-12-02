package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumeratedXmlAttributeImplTest {

	static private final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";

	@Test
	public void testEnumeratedXmlAttributeImpl() {
		ConcreteEnumeratedXmlAttributeImpl attr = new ConcreteEnumeratedXmlAttributeImpl(
				"name", ConcreteEnumeratedXmlAttributeImpl.Value.ENUM1);
		assertEquals(XML_NAMESPACE, attr.getNamespaceUri());
		assertEquals("xml", attr.getPrefix());
		assertEquals("name", attr.getName());
		assertEquals("enum1", attr.getValue());
		assertEquals(ConcreteEnumeratedXmlAttributeImpl.Value.ENUM1, attr.getEnumValue());
	}

}
