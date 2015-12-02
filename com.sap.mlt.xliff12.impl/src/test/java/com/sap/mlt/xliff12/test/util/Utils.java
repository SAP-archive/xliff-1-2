package com.sap.mlt.xliff12.test.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public final class Utils {

	private Utils() {
	}

	public static final Document createDocument() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			return dbf.newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			//$JL-EXC$
			throw new AssertionError(e);
		}
	}

}
