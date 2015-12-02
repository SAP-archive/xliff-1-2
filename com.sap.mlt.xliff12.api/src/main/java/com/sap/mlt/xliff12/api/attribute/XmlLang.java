package com.sap.mlt.xliff12.api.attribute;

import java.util.Locale;

import com.sap.mlt.xliff12.api.base.XmlAttribute;

/**
 * Language - The XmlLang attribute specifies the language variant of the text
 * of a given element. For example: "fr-FR" indicates the French language as
 * spoken in France.
 * 
 * @author D049314
 */
public interface XmlLang extends XmlAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "lang";

	/**
	 * Returns this language as {@link Locale}.
	 * 
	 * @return Returns this language as {@link Locale}.
	 */
	Locale getLocale();
}
