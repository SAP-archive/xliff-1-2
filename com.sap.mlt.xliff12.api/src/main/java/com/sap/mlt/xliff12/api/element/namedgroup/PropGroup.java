package com.sap.mlt.xliff12.api.element.namedgroup;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Property group - The PropGroup element contains {@link Prop} elements. Each
 * PropGroup element may be named, allowing different uses for each group. These
 * uses can be controlled through the use of XML processing instructions.
 * 
 * @author D049314
 * @deprecated The PropGroup element was DEPRECATED in version 1.1. Instead, use
 *             attributes defined in a namespace different from XLIFF.
 */
public interface PropGroup extends XliffElement, Header.Context,
		TransUnit.Context, AltTrans.Context, BinUnit.Context {

	/**
	 * The element's name.
	 */
	static final String NAME = "prop-group";

	/**
	 * Returns the <code>Name</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Name</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Name getPropGroupName();

	/**
	 * Sets the <code>Name</code> attribute.
	 * 
	 * @param name
	 *            The <code>Name</code> attribute. May be <code>null</code>.
	 */
	void setPropGroupName(Name name);

	/**
	 * Returns the <code>Prop</code> elements in this group.
	 * 
	 * @return Returns the <code>Prop</code> elements in this group. Contains at
	 *         least one element.
	 */
	List<Prop> getProps();

	/**
	 * Sets the <code>Prop</code> elements contained in this group.
	 * 
	 * @param props
	 *            The <code>Prop</code> elements. Must not be <code>null</code>.
	 *            Must contain at least one element.
	 */
	void setProps(List<Prop> props);

}
