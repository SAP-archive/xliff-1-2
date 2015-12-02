package com.sap.mlt.xliff12.api.base;

/**
 * A (tagging) interface for code-fragments used inside XLIFF inline elements.
 * 
 * @author D049314
 */
public interface CodeFragment extends Node {

	/**
	 * Returns a plain-text representation of the code-fragment.
	 * 
	 * @return Returns a plain-text representation of the code-fragment.
	 */
	String getPlainText();

}
