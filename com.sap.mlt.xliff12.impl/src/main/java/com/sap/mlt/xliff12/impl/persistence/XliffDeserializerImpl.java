package com.sap.mlt.xliff12.impl.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.exception.DeserializationException;
import com.sap.mlt.xliff12.api.persistence.XliffDeserializer;
import com.sap.mlt.xliff12.impl.element.toplevel.XliffImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.NullErrorHandler;

public final class XliffDeserializerImpl implements XliffDeserializer {

	private static final XliffDeserializerImpl INSTANCE = new XliffDeserializerImpl();

	public static XliffDeserializerImpl getInstance() {
		return INSTANCE;
	}

	private XliffDeserializerImpl() {
	}

	public Xliff deserialize(File file) throws DeserializationException {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			Xliff xliff = deserialize(is);
			is.close();
			is = null;
			return xliff;
		} catch (IOException e) {
			throw new DeserializationException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// $JL-EXC$
				}
			}
		}
	}

	public Xliff deserialize(InputStream is) throws DeserializationException {

		// Create a parser
		DocumentBuilder parser;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true);
			factory.setCoalescing(true);
			factory.setExpandEntityReferences(true);
			factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
			parser = factory.newDocumentBuilder();
			parser.setErrorHandler(new NullErrorHandler());
		} catch (ParserConfigurationException e) {
			throw new DeserializationException(
					"There is a problem with your Java XML parser configuration.",
					e);
		}

		// Parse the XML-document
		Document document;
		try {
			document = parser.parse(is);
		} catch (SAXParseException e) {
			String msg = MessageFormat
					.format(
							"The XLIFF-file is not well-formed. The erroneous location is at line {0}, column {1}.",
							e.getLineNumber(), e.getColumnNumber());
			throw new DeserializationException(msg, e);
		} catch (SAXException e) {
			throw new DeserializationException(
					"The XLIFF-file is not well-formed.", e);
		} catch (IOException e) {
			throw new DeserializationException(
					"An I/O-error occured while XLIFF-file was read.", e);
		}

		// Validate against schema
		Schema schema = Schemas.getXLIFF12TransitionalSchema();
		Validator validator = schema.newValidator();
		try {
			validator.validate(new DOMSource(document));
		} catch (SAXException e) {
			throw new DeserializationException(
					"XLIFF-file could not be validated against schema.", e);
		} catch (IOException e) {
			throw new DeserializationException(
					"An I/O-error occured while XLIFF-file was read.", e);
		}

		Element root = document.getDocumentElement();
		try {
			return new XliffImpl(root);
		} catch (ConstraintViolationException e) {
			throw new DeserializationException(e);
		} catch (IllegalArgumentException e) {
			throw new DeserializationException(e);
		}
	}

}
