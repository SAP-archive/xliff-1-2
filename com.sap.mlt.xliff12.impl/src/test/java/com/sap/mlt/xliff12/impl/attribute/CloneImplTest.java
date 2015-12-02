package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Clone;

public class CloneImplTest {

	@Test
	public void testCloneImpl() {
		CloneImpl attr = new CloneImpl(Clone.Value.NO);
		assertEquals(Clone.Value.NO, attr.getEnumValue());
	}

}
