package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.inline.G;

/**
 * Font - The font attribute specifies the font name, size, and weight of the
 * text for a given element. The font attribute would generally be used for
 * resource-type data: change of font in document-type data can be marked with
 * the {@link G} element.
 * 
 * @author D049314
 */
public interface Font extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "font";

}
