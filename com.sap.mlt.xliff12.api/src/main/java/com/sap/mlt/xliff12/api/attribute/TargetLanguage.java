package com.sap.mlt.xliff12.api.attribute;

import java.util.Locale;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Target language - The language for the {@link Target} elements in the given
 * {@link File} element.
 * 
 * @author D049314
 */
public interface TargetLanguage extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "target-language";

	/**
	 * Returns this language as {@link Locale}.
	 * 
	 * @return Returns this language as {@link Locale}.
	 */
	Locale getLocale();

}
