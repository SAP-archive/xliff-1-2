package com.sap.mlt.xliff12.api.attribute;

import java.util.Locale;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Source language - The language for the {@link Source} elements in the given
 * {@link File} element.
 * 
 * @author D049314
 */
public interface SourceLanguage extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "source-language";

	/**
	 * Returns the language as {@link Locale}.
	 * 
	 * @return Returns the language as {@link Locale}.
	 */
	Locale getLocale();

}
