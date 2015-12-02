package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Annotates;

public class AnnotatesImplTest {

	@Test
	public void testAnnotatesImpl() {
		AnnotatesImpl attr = new AnnotatesImpl(Annotates.Value.SOURCE);
		assertEquals(Annotates.Value.SOURCE, attr.getEnumValue());
	}

}
