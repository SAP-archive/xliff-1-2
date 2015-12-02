package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Tool;

/**
 * Tool identifier - The {@link ToolId} attribute allows unique identification
 * of a {@link Tool} element. It is also used in other elements in the file to
 * refer to the given {@link Tool} element.
 * 
 * @author D049314
 */
public interface ToolId extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "tool-id";

}
