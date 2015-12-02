package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Assoc;

public class AssocImplTest {

	@Test
	public void testAssocImpl() {
		AssocImpl attr = new AssocImpl(Assoc.Value.FOLLOWING);
		assertEquals(Assoc.Value.FOLLOWING, attr.getEnumValue());
	}

}
