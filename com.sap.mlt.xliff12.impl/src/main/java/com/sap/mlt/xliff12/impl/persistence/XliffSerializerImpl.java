package com.sap.mlt.xliff12.impl.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.SerializationException;
import com.sap.mlt.xliff12.api.persistence.XliffSerializer;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;

public final class XliffSerializerImpl implements XliffSerializer {

	private static final XliffSerializerImpl INSTANCE = new XliffSerializerImpl();

	public static XliffSerializerImpl getInstance() {
		return INSTANCE;
	}

	private XliffSerializerImpl() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setSchema(Schemas.getXLIFF12TransitionalSchema());
		try {
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new IllegalStateException(
					"There is an internal problem with the XML-parser configuration.",
					e);
		}

		Schema schema = Schemas.getXLIFF12TransitionalSchema();
		validator = schema.newValidator();

		final InputStream resourceAsStream = getClass().getResourceAsStream("pretty_print_indent.xsl");
		try {
			Source prettyPrintIndentTemplate = new StreamSource(resourceAsStream);
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			prettyPrintIndentTransformer = transformerFactory
					.newTransformer(prettyPrintIndentTemplate);
			prettyPrintIndentTransformer.setOutputProperty(OutputKeys.INDENT,
					"no");
			nullTransformer = transformerFactory.newTransformer();
			nullTransformer.setOutputProperty(OutputKeys.INDENT, "no");
		} catch (TransformerConfigurationException e) {
			throw new IllegalStateException(
					"There is an internal problem with the XML configuration.",
					e);
		} finally {
			try {
				resourceAsStream.close();
			} catch (IOException e) {
				// ignore IOException during close
			}
		}
	}

	private DocumentBuilder builder;

	private Validator validator;

	private Transformer nullTransformer;

	private Transformer prettyPrintIndentTransformer;

	public void serialize(Xliff xliff, File file) throws SerializationException {
		serialize(xliff, file, "");
	}

	public void serialize(Xliff xliff, File file, String indentation)
			throws SerializationException {
		Assert.notNull(xliff, "xliff");
		Assert.notNull(file, "file");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			serialize(xliff, os, indentation);
			os.close();
			os = null;
		} catch (IOException e) {
			throw new SerializationException(e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// $JL-EXC$
				}
			}
		}
	}

	public void serialize(Xliff xliff, OutputStream os)
			throws SerializationException {
		serialize(xliff, os, "");
	}

	public synchronized void serialize(Xliff xliff, OutputStream os,
			String indentation) throws SerializationException {
		Assert.notNull(xliff, "xliff");
		Assert.notNull(os, "os");
		Assert.notNull(indentation, "indentation");

		int il = indentation.length();
		for (int i = 0; i < il; ++i) {
			char ch = indentation.charAt(i);
			if ((ch != ' ') && (ch != '\t')) {
				throw new IllegalArgumentException(
						"The parameter 'indentation' must contain spaces and tabulators only");
			}
		}

		Document document = builder.newDocument();
		document.appendChild(xliff.asXmlNode(document));

		// We will do a "null"-transform first to avoid issues with missing
		// attribute-prefixes
		DOMSource domSource = new DOMSource(document);
		DOMResult domResult = new DOMResult();
		try {
			nullTransformer.transform(domSource, domResult);
		} catch (TransformerException e) {
			throw new SerializationException("Could not write the XLIFF", e);
		}

		// Now we will perform the actual transformation on the "clean" DOM
		domSource = new DOMSource(domResult.getNode());

		// Check if the DOM is valid according to the schema
		try {
			validator.validate(domSource);
		} catch (SAXException e) {
			throw new SerializationException(
					"The passed XLIFF file is invalid. Check underlying exception for details.",
					e);
		} catch (IOException e) {
			// $JL-EXC$
		}

		StreamResult streamResult = new StreamResult(os);
		try {
			prettyPrintIndentTransformer.setParameter("indentsequence",
					indentation);
			prettyPrintIndentTransformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			throw new SerializationException("Could not write the XLIFF", e);
		}
	}
	
}
