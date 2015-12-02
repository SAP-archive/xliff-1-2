package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Minimum width - The minimum width for the {@link Target} of a
 * {@link TransUnit}. This could be interpreted as lines, pixels, or any other
 * relevant unit. The unit is determined by the {@link SizeUnit} attribute,
 * which defaults to pixel.
 * 
 * @author D049314
 */
public interface MinWidth extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "minwidth";

}
