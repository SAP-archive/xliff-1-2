package com.sap.mlt.xliff12.api.element.namedgroup;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Count group - The CountGroup element holds count elements relating to the
 * level in the tree in which it occurs. Each group for {@link Count} elements
 * must be named, allowing different uses for each group. The required name
 * attribute uniquely identifies the CountGroup within the {@link File} element.
 * 
 * @author D049314
 */
public interface CountGroup extends XliffElement, Header.Context,
		TransUnit.Context, BinUnit.Context {

	/**
	 * Returns the element's name.
	 */
	static final String NAME = "count-group";

	/**
	 * Returns the <code>Name</code> attribute.
	 * 
	 * @return Returns the <code>Name</code> attribute.
	 */
	Name getCountGroupName();

	/**
	 * Sets the <code>Name</code> attribute.
	 * 
	 * @param name
	 *            The <code>Name</code> attribute. Must not be <code>null</code>
	 *            .
	 */
	void setCountGroupName(Name name);

	/**
	 * Returns the <code>Count</code> elements contained in this group. The
	 * returned list contains at least one element.
	 * 
	 * @return Returns the <code>Count</code> elements contained in this group.
	 *         The returned list contains at least one element.
	 */
	List<Count> getCounts();

	/**
	 * Sets the <code>Count</code> elements contained in this group.
	 * 
	 * @param counts
	 *            The <code>Count</code> elements this group is to contain. Must
	 *            not be <code>null</code> and must contain at least one entry.
	 */
	void setCounts(List<Count> counts);

}
