package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MultiXtendableAttributeImplTest {

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testMultiXTendableAttributeImpl() {
		List<? extends Enum<?>> values = Arrays.asList(
				ConcreteMultiXtendableAttributeImpl.Value.ENUM1,
				ConcreteMultiXtendableAttributeImpl.Value.ENUM2);
		List<String> xtendValues = Arrays.asList("xtend1", "xtend2");

		ConcreteMultiXtendableAttributeImpl attr = new ConcreteMultiXtendableAttributeImpl(
				"name", values, xtendValues);
		assertEquals(XLIFF_12_NAMESPACE, attr.getNamespaceUri());
		assertEquals("name", attr.getName());
		assertEquals("enum1 enum2 x-xtend1 x-xtend2", attr.getValue());
		
		List<? extends Enum<?>> attrEnumValues = attr.getEnumValues();
		List<String> attrXtendValues = attr.getXtendValues();
		assertEquals(new Integer(2), new Integer(attrEnumValues.size()));
		assertEquals(new Integer(2), new Integer(attrXtendValues.size()));
		
		List<String> emptyStringList = Collections.emptyList();
		attr = new ConcreteMultiXtendableAttributeImpl("name", values, emptyStringList);
		assertEquals("enum1 enum2", attr.getValue());
		
		List<? extends Enum<?>> emptyEnumList = Collections.emptyList();
		attr = new ConcreteMultiXtendableAttributeImpl("name", emptyEnumList, xtendValues);
		assertEquals("x-xtend1 x-xtend2", attr.getValue());
	}

}
