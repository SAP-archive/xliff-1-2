package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.XmlSpace;

public class XmlSpaceImplTest {

	@Test
	public void testXmlSapceImpl() {
		XmlSpaceImpl attr = new XmlSpaceImpl(XmlSpace.Value.PRESERVE);
		assertEquals(XmlSpace.Value.PRESERVE, attr.getEnumValue());
	}

}
