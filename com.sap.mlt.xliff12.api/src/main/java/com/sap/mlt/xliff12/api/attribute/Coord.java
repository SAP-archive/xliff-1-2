package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Coordinates - The coord attribute specifies the x, y, cx and cy coordinates
 * of the text for a given element. The cx and cy values must represent the
 * width and the height (as in Windows resources). The extraction and merging
 * tools must make the right conversion if the original format uses a
 * top-left/bottom-right coordinate system.
 * 
 * @author D049314
 */
public interface Coord extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "coord";

	/**
	 * Returns the x-coordinate. Might be <code>null</code>.
	 * 
	 * @return Returns the x-coordinate. Might be <code>null</code>.
	 */
	Integer getX();

	/**
	 * Returns the y-coordinate. Might be <code>null</code>.
	 * 
	 * @return Returns the y-coordinate. Might be <code>null</code>.
	 */
	Integer getY();

	/**
	 * Returns the width. Might be <code>null</code>.
	 * 
	 * @return Returns the width. Might be <code>null</code>.
	 */
	Integer getCx();

	/**
	 * Returns the height. Might be <code>null</code>.
	 * 
	 * @return Returns the height. Might be <code>null</code>.
	 */
	Integer getCy();
}
