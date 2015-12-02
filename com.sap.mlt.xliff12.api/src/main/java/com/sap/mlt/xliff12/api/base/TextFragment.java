package com.sap.mlt.xliff12.api.base;

/**
 * A (tagging) interface for text-fragments used inside XLIFF inline elements.
 * 
 * @author D049314
 */
public interface TextFragment extends Node {

	/**
	 * Returns a plain-text representation of the text-fragment.
	 * 
	 * @return Returns a plain-text representation of the text-fragment.
	 */
	String getPlainText();

}
