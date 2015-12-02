package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CoordImplTest {

	@Test
	public void testCoordImpl() {
		CoordImpl coord = new CoordImpl(1, 2, 3, 4);
		assertEquals(new Integer(1), coord.getX());
		assertEquals(new Integer(2), coord.getY());
		assertEquals(new Integer(3), coord.getCx());
		assertEquals(new Integer(4), coord.getCy());
		assertEquals("1;2;3;4", coord.getValue());
		
		coord = new CoordImpl(null, null, null, null);
		assertNull(coord.getX());
		assertNull(coord.getY());
		assertNull(coord.getCx());
		assertNull(coord.getCy());
		assertEquals("#;#;#;#", coord.getValue());
	}

}
