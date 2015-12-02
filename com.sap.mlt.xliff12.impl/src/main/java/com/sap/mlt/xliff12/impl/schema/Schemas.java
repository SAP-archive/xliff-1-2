package com.sap.mlt.xliff12.impl.schema;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public final class Schemas {

	/**
	 * The XML-namespace, i.e. http://www.w3.org/XML/1998/namespace
	 */
	static public final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";
	
	/**
	 * the XMLNS-namespace, i.e. http://www.w3.org/2000/xmlns/
	 */
	static public final String XMLNS_NAMESPACE = "http://www.w3.org/2000/xmlns/";
	
	/**
	 * The XMLSchema-namespace, i.e. http://www.w3.org/2001/XMLSchema
	 */
	static public final String XMLSCHEMA_NAMESPACE = "http://www.w3.org/2001/XMLSchema";

	/**
	 * The namespace of XLIFF 1.2 strict, i.e.
	 * urn:oasis:names:tc:xliff:document:1.2
	 */
	static public final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	private final static String[] XLIFF_12_STRICT_SOURCES = { "xml.xsd",
			"xliff-core-1.2-strict.xsd" };

	private final static String[] XLIFF_12_TRANSITIONAL_SOURCES = { "xml.xsd",
			"xliff-core-1.2-transitional.xsd" };

	private Schemas() {
	}

	static private Schema xliff12StrictSchema = null;

	static private Schema xliff12TransitionalSchema = null;

	static private synchronized void createXLIFF12StrictSchema() {
		if (xliff12StrictSchema != null)
			return;
		xliff12StrictSchema = createSchemaFromSources(XLIFF_12_STRICT_SOURCES);
	}

	/**
	 * Returns the schema for OASIS standard XLIFF 1.2 strict.
	 * 
	 * @return Returns the schema for OASIS standard XLIFF 1.2 strict.
	 */
	static public Schema getXLIFF12StrictSchema() {
		if (xliff12StrictSchema == null)
			createXLIFF12StrictSchema();
		return xliff12StrictSchema;
	}

	static private synchronized void createXLIFF12TransitionalSchema() {
		if (xliff12TransitionalSchema != null)
			return;
		xliff12TransitionalSchema = createSchemaFromSources(XLIFF_12_TRANSITIONAL_SOURCES);
	}

	/**
	 * Returns the schema for OASIS standard XLIFF 1.2 transitional.
	 * 
	 * @return Returns the schema for OASIS standard XLIFF 1.2 transitional.
	 */
	static public Schema getXLIFF12TransitionalSchema() {
		if (xliff12TransitionalSchema == null)
			createXLIFF12TransitionalSchema();
		return xliff12TransitionalSchema;
	}

	static private Schema createSchemaFromSources(String[] s) {
		Source[] sources = new Source[s.length];
		InputStream[] streams = new InputStream[s.length];
		try {
			Class<Schemas> cl = Schemas.class;
			for (int i = 0; i < s.length; ++i) {
				final InputStream resourceAsStream = cl.getResourceAsStream(s[i]);
				streams[i] = resourceAsStream;
				sources[i] = new StreamSource(resourceAsStream);
			}

			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema;
			try {
				schema = factory.newSchema(sources);
			} catch (SAXException e) {
				throw new IllegalStateException("The library-internal schemas are corrupt.", e);
			}
			return schema;
		} finally {
			for (InputStream stream : streams) {
				try {
					if (stream != null) {
						stream.close();
					}
				} catch (IOException e) {
					// ignore exception during close
				}
			}
		}
	}
}
