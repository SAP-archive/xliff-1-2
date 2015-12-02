package com.sap.mlt.xliff12.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sap.mlt.xliff12.api.exception.DeserializationException;
import com.sap.mlt.xliff12.api.exception.SerializationException;

public class XliffTest {

	// private AttributeFactory attrFactory;
	//
	// private ElementFactory elemFactory;
	//
	// private XliffDeserializer deserializer;
	//
	// private XliffSerializer serializer;

	@Before
	public void initialize() {
		// XliffFactory factory = XliffFactory.newInstance();
		// attrFactory = factory.getAttributeFactory();
		// elemFactory = factory.getElementFactory();
		// deserializer = factory.getDeserializer();
		// serializer = factory.getSerializer();
	}

	@Test
	public void strictTest() throws DeserializationException, IOException,
			SerializationException {
		// InputStream is = getClass().getResourceAsStream(
		// "Sample_AlmostEverything_1.2_strict.xlf");
		// Xliff xliff = deserializer.deserialize(is);
		// is.close();
		//
		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// serializer.serialize(xliff, baos);
		// baos.close();
		//
		// ByteArrayInputStream bais = new
		// ByteArrayInputStream(baos.toByteArray());
		// Xliff xliff2 = deserializer.deserialize(bais);
		// bais.close();
		//
		// assertTrue(xliff.equals(xliff2));
		//
		// ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		// ArrayList<Element> children = new ArrayList<Element>();
		// NonXliffElement addition = elemFactory.createNonXliffElement("abc",
		// "xyz", attributes, children);
		// xliff2.getFiles().get(0).getHeader().setNonXliffElements(Collections.singletonList(addition));
		//
		// assertFalse(xliff.equals(xliff2));
	}

	@Test
	public void transitionalTest() throws DeserializationException,
			IOException, SerializationException {
		// InputStream is = getClass().getResourceAsStream(
		// "Sample_AlmostEverything_1.2_transitional.xlf");
		// Xliff xliff = deserializer.deserialize(is);
		// is.close();
		//
		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// serializer.serialize(xliff, baos);
		// baos.close();
		//
		// ByteArrayInputStream bais = new
		// ByteArrayInputStream(baos.toByteArray());
		// Xliff xliff2 = deserializer.deserialize(bais);
		// bais.close();
		//
		// assertTrue(xliff.equals(xliff2));
		//
		// ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		// ArrayList<Element> children = new ArrayList<Element>();
		// NonXliffElement addition = elemFactory.createNonXliffElement("abc",
		// "xyz", attributes, children);
		// xliff2.getFiles().get(0).getHeader().setNonXliffElements(Collections.singletonList(addition));
		//
		// assertFalse(xliff.equals(xliff2));
	}

	@Test
	public void nonXliffAttributesTest() throws SerializationException {
		// Id id = attrFactory.createId("1");
		// Source source = elemFactory.createSource("Test");
		// TransUnit tu = elemFactory.createTransUnit(id, source);
		// NonXliffAttribute attr = attrFactory.createNonXliffAttribute("abc",
		// "xyz", "123");
		// tu.setNonXliffAttributes(Collections.singleton(attr));
		// System.out.println(tu);
		//
		// Body body = elemFactory.createBody(Collections.singletonList(tu));
		//		
		// Original original = attrFactory.createOriginal("self");
		// SourceLanguage sourceLanguage =
		// attrFactory.createSourceLanguage(Locale.ENGLISH);
		// DataType dataType =
		// attrFactory.createDataType(DataType.Value.PLAINTEXT);
		// File file = elemFactory.createFile(original, sourceLanguage,
		// dataType, body);
		// file.setNonXliffAttributes(Collections.singleton(attr));
		//		
		// Version version = attrFactory.createVersion(Version.Value.V1_2);
		// Xliff xliff = elemFactory.createXliff(version, file);
		//		
		// serializer.serialize(xliff, System.out, "\t");

	}
}
