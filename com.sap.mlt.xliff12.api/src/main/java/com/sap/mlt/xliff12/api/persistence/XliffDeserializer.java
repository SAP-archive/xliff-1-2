package com.sap.mlt.xliff12.api.persistence;

import java.io.File;
import java.io.InputStream;

import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.DeserializationException;

/**
 * Interface that offers methods to deserialize XLIFF documents from files or
 * input streams.
 * 
 * @author D049314
 */
public interface XliffDeserializer {

	/**
	 * Deserializes an XLIFF document from the passed file.
	 * 
	 * @param file
	 *            The file containing an XLIFF document
	 * @return Returns the deserialized XLIFF document.
	 * @throws DeserializationException
	 *             Occurs if the XLIFF document could not be deserialized.
	 */
	Xliff deserialize(File file) throws DeserializationException;

	/**
	 * Deserializes an XLIFF document from the passed input stream. The input
	 * stream is not closed by this method.
	 * 
	 * @param is
	 *            The input stream the XLIFF document is read from
	 * @return Returns the deserialized XLIFF document.
	 * @throws DeserializationException
	 *             Occurs if the XLIFF document could not be deserialized.
	 */
	Xliff deserialize(InputStream is) throws DeserializationException;

}
