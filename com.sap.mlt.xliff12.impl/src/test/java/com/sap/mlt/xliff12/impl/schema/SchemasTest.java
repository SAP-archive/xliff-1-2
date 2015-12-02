package com.sap.mlt.xliff12.impl.schema;

import static org.junit.Assert.assertNotNull;

import javax.xml.validation.Schema;

import org.junit.Test;

public class SchemasTest {

	@Test
	public void testGetXLIFF12StrictSchema() {
		Schema schema = Schemas.getXLIFF12StrictSchema();
		assertNotNull(schema);
		schema = Schemas.getXLIFF12StrictSchema();
		assertNotNull(schema);
	}

	@Test
	public void testGetXLIFF12TransitionalSchema() {
		Schema schema = Schemas.getXLIFF12TransitionalSchema();
		assertNotNull(schema);
		schema = Schemas.getXLIFF12TransitionalSchema();
		assertNotNull(schema);
	}

}
