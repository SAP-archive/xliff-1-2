package com.sap.mlt.xliff12.api.factory;

import com.sap.mlt.xliff12.api.text.Text;

/**
 * XLIFF text factory.
 * 
 * Use this factory to create plain texts for XLIFF documents.
 * 
 * @author D049314
 */
public interface TextFactory {

	/**
	 * Creates and returns a text with the passed content.
	 * 
	 * @param text
	 *            The content
	 * @return Creates and returns a text with the passed content.
	 */
	Text createText(String text);

}
