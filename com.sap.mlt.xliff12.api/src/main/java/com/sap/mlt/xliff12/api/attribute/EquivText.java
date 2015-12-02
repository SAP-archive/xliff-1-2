package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * equiv-text - Indicates the equivalent text to substitute in place of an
 * inline tag. It is useful for inserting whitespace or other content in place
 * of markup to facilitate consistent word counting. The equiv-text attribute is
 * also useful for ensuring consistent round trip conversion between native
 * resource formats and XLIFF content, for example the resource string
 * "F&amp;ile" converts to the following XLIFF:
 * "F&lt;x id='1' ctype='x-akey' equiv-text=''/>ile" to preserve the underlying
 * translatable content.
 * 
 * @author D049314
 */
public interface EquivText extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "equiv-text";

}
