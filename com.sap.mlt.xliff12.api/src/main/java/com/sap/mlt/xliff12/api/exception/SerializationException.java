package com.sap.mlt.xliff12.api.exception;

/**
 * Thrown when an XLIFF document could not be serialized. Check the underlying
 * cause for details.
 * 
 * @author D049314
 */
public class SerializationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            The exception cause
	 */
	public SerializationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param msg
	 *            The exception message
	 * @param cause
	 *            The exception cause
	 */
	public SerializationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
