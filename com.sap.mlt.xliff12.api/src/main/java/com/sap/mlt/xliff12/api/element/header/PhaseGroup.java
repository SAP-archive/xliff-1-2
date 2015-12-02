package com.sap.mlt.xliff12.api.element.header;

import java.util.List;

import com.sap.mlt.xliff12.api.base.XliffElement;

/**
 * Phase group - The PhaseGroup element contains information about the task that
 * has been performed on the file. This phase information is specific to the
 * tools and workflow used in processing the file.
 * 
 * @author D049314
 */
public interface PhaseGroup extends XliffElement {

	/**
	 * The element's name.
	 */
	final static String NAME = "phase-group";

	/**
	 * Returns the list of <code>Phase</code>s in this group. The returned list
	 * contains at least one phase.
	 * 
	 * @return Returns the list of <code>Phase</code>s in this group. The
	 *         returned list contains at least one phase.
	 */
	List<Phase> getPhases();

	/**
	 * Sets the <code>Phase</code>s contained in this phase-group.
	 * 
	 * @param phases
	 *            A list of <code>Phase</code>s. Must not be <code>null</code>
	 *            and must contain at least one phase.
	 */
	void setPhases(List<Phase> phases);

}
