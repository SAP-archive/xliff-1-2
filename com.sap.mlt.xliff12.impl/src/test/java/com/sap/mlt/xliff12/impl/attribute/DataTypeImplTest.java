package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.DataType;

public class DataTypeImplTest {

	@Test
	public void testDataTypeImplValue() {
		DataTypeImpl attr = new DataTypeImpl(DataType.Value.CSHARP);
		assertEquals(DataType.Value.CSHARP, attr.getEnumValue());
	}

	@Test
	public void testDataTypeImplString() {
		DataTypeImpl attr = new DataTypeImpl("abc");
		assertEquals("abc", attr.getXtendValue());
	}

}
