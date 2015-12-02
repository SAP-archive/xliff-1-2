package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Extern Reference identifier - The {@link Xid} attribute is used to link an
 * inline element to a different {@link TransUnit} or {@link BinUnit} element.
 * For example, to link the text within a code to a corresponding translation
 * unit.
 * 
 * @author D049314
 */
public interface Xid extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "xid";

}
