package com.sap.mlt.xliff12.api.element.structural;

import java.util.List;

import com.sap.mlt.xliff12.api.base.XliffElement;

/**
 * File body - The Body element contains the content from the file.
 * 
 * @author D049314
 */
public interface Body extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "body";

	/**
	 * Returns the <code>StructuralUnit</code>s in this element. This can be any
	 * combination of {@link Group}, {@link TransUnit} and {@link BinUnit}
	 * elements.
	 * 
	 * @return Returns the <code>StructuralUnit</code>s in this element. This
	 *         can be any combination of {@link Group}, {@link TransUnit} and
	 *         {@link BinUnit} elements.
	 */
	List<? extends StructuralUnit> getStructuralUnits();

	/**
	 * Sets the <code>StructuralUnit</code>s in this element.
	 * 
	 * @param children
	 *            A list of <code>StructuralUnit</code>s. Must not be
	 *            <code>null</code>. Can be any combination of {@link Group},
	 *            {@link TransUnit} and {@link BinUnit} elements.
	 */
	void setStructuralUnits(List<? extends StructuralUnit> children);

}
