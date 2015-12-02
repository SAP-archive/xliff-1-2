package com.sap.mlt.xliff12.api.persistence;

import java.io.File;
import java.io.OutputStream;

import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.SerializationException;

/**
 * Interface that offers methods to serialize XLIFF documents to files or output
 * streams.
 * 
 * @author D049314
 */
public interface XliffSerializer {

	/**
	 * Serializes an XLIFF document to the passed file using no indentation.
	 * 
	 * @param xliff
	 *            The XLIFF document to serialize
	 * @param file
	 *            The target file
	 * @throws SerializationException
	 *             Occurs if the XLIFF document could not be serialized.
	 */
	void serialize(Xliff xliff, File file) throws SerializationException;

	/**
	 * Serializes an XLIFF document to the passed file.
	 * 
	 * @param xliff
	 *            The XLIFF document to serialize
	 * @param file
	 *            The target file
	 * @param indentation
	 *            String that is used indent elements, e.g. you could specify
	 *            "\t" to indent with a tabulator. Only spaces and tabulators
	 *            are allowed.
	 * @throws SerializationException
	 *             Occurs if the XLIFF document could not be serialized.
	 * @since 1.1
	 */
	void serialize(Xliff xliff, File file, String indentation)
			throws SerializationException;

	/**
	 * Serializes an XLIFF document to the passed output stream using no
	 * indentation. The output stream is not closed by this method.
	 * 
	 * @param xliff
	 *            The XLIFF document to serialize
	 * @param os
	 *            The target output stream
	 * @throws SerializationException
	 *             Occurs if the XLIFF document could not be serialized.
	 */
	void serialize(Xliff xliff, OutputStream os) throws SerializationException;

	/**
	 * Serializes an XLIFF document to the passed output stream. The output
	 * stream is not closed by this method.
	 * 
	 * @param xliff
	 *            The XLIFF document to serialize
	 * @param os
	 *            The target output stream
	 * @param indentation
	 *            String that is used to indent elements, e.g. you could specify
	 *            "\t" to indent with a tabulator. Only spaces and tabulators
	 *            are allowed.
	 * @throws SerializationException
	 *             Occurs if the XLIFF document could not be serialized.
	 * @since 1.1
	 */
	void serialize(Xliff xliff, OutputStream os, String indentation)
			throws SerializationException;
}
