package com.sap.mlt.xliff12.api.element.header;

import java.util.List;

import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * File header - The Header element contains metadata relating to the
 * {@link File} element.
 * 
 * @author D049314
 */
public interface Header extends XliffElement {

	/**
	 * The element's name
	 */
	static final String NAME = "header";

	/**
	 * A {@link Glossary}, {@link Reference}, {@link CountGroup},
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 * {@link Note}, or {@link Tool}
	 * 
	 * @author D049314
	 */
	interface Context extends XliffElement {
	}

	/**
	 * Returns the <code>Skl</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Skl</code> element. Might be <code>null</code>.
	 */
	Skl getSkl();

	/**
	 * Sets the <code>Skl</code> element.
	 * 
	 * @param skl
	 *            The <code>Skl</code> element. May be <code>null</code>.
	 */
	void setSkl(Skl skl);

	/**
	 * Returns the <code>PhaseGroup</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>PhaseGroup</code> element. Might be
	 *         <code>null</code>.
	 */
	PhaseGroup getPhaseGroup();

	/**
	 * Sets the <code>PhaseGroup</code> element.
	 * 
	 * @param phaseGroup
	 *            The <code>PhaseGroup</code> element. May be <code>null</code>.
	 */
	void setPhaseGroup(PhaseGroup phaseGroup);

	/**
	 * Returns the list of <code>Context</code> elements. Can be any combination
	 * of {@link Glossary}, {@link Reference}, {@link CountGroup},
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 * {@link Note} and {@link Tool} elements.
	 * 
	 * @return Returns the list of <code>Context</code> elements. Can be any
	 *         combination of {@link Glossary}, {@link Reference},
	 *         {@link CountGroup},
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 *         {@link Note} and {@link Tool} elements.
	 */
	List<? extends Context> getContext();

	/**
	 * Sets the list of <code>Context</code> elements.
	 * 
	 * @param context
	 *            The list of <code>Context</code> elements. Must not be
	 *            <code>null</code>. Can be any combination of {@link Glossary},
	 *            {@link Reference}, {@link CountGroup},
	 *            {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 *            {@link Note} and {@link Tool} elements.
	 */
	void setContext(List<? extends Context> context);

	/**
	 * Returns the list of non-XLIFF elements.
	 * 
	 * @return Returns the list of non-XLIFF elements.
	 */
	List<NonXliffElement> getNonXliffElements();

	/**
	 * Sets the list of non-XLIFF elements.
	 * 
	 * @param nonXliffElements
	 *            The list of non-XLIFF elements. Must not be <code>null</code>.
	 */
	void setNonXliffElements(List<NonXliffElement> nonXliffElements);

}
