package com.sap.mlt.xliff12.api.exception;

/**
 * Thrown when an XLIFF document could not be deserialized. Check the underlying
 * cause for details.
 * 
 * @author D049314
 */
public class DeserializationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            The exception cause
	 */
	public DeserializationException(Throwable cause) {
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
	public DeserializationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
