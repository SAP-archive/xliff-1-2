package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Creation tool - The tool attribute is used to specify the signature and
 * version of the tool that created or modified the document.
 * 
 * @author D049314
 * @deprecated The tool attribute was DEPRECATED in version 1.1. Instead, use
 *             the {@link com.sap.mlt.xliff12.api.element.header.Tool} element
 *             and a {@link ToolId} attribute.
 */
public interface Tool extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "tool";

}
