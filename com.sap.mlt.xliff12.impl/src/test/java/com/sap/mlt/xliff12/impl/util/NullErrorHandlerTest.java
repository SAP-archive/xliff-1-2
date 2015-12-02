package com.sap.mlt.xliff12.impl.util;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class NullErrorHandlerTest {

	@Test
	public void testError() throws SAXException {
		NullErrorHandler neh = new NullErrorHandler();
		neh.error(new SAXParseException("test", null));
	}

	@Test
	public void testFatalError() throws SAXException {
		NullErrorHandler neh = new NullErrorHandler();
		neh.fatalError(new SAXParseException("test", null));
	}

	@Test
	public void testWarning() throws SAXException {
		NullErrorHandler neh = new NullErrorHandler();
		neh.warning(new SAXParseException("test", null));
	}

}
