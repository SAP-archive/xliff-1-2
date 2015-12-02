package com.sap.mlt.xliff12.impl.persistence;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Test;

import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.DeserializationException;
import com.sap.mlt.xliff12.api.exception.SerializationException;

public class PersistenceTest {

	private static final String STRICT_NAME = "Sample_AlmostEverything_1.2_strict.xlf";

	private static final String TRANSITIONAL_NAME = "Sample_AlmostEverything_1.2_transitional.xlf";

	@Test
	public void strictTest() throws DeserializationException, SerializationException {
		
		XliffDeserializerImpl deserializer = XliffDeserializerImpl.getInstance();
		XliffSerializerImpl serializer = XliffSerializerImpl.getInstance();
		
		InputStream is = getClass().getResourceAsStream(STRICT_NAME);
		Xliff xliff = deserializer.deserialize(is);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		serializer.serialize(xliff, baos);
	
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		Xliff xliff2 = deserializer.deserialize(bais);
		
		assertEquals(xliff, xliff2);
	}

	@Test
	public void transitionalTest() throws DeserializationException, SerializationException {
		
		XliffDeserializerImpl deserializer = XliffDeserializerImpl.getInstance();
		XliffSerializerImpl serializer = XliffSerializerImpl.getInstance();
		
		InputStream is = getClass().getResourceAsStream(TRANSITIONAL_NAME);
		Xliff xliff = deserializer.deserialize(is);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		serializer.serialize(xliff, baos);
	
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		Xliff xliff2 = deserializer.deserialize(bais);
		
		assertEquals(xliff, xliff2);
	}

}
