package com.sap.mlt.xliff12.api.exception;

/**
 * Thrown when a constraint of an XLIFF document is violated.
 * 
 * @author D049314
 */
public class ConstraintViolationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param msg
	 *            The exception message
	 */
	public ConstraintViolationException(String msg) {
		super(msg);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            The exception cause
	 */
	public ConstraintViolationException(Throwable cause) {
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
	public ConstraintViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
