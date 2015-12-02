package com.sap.mlt.xliff12.api.element.namedgroup;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Group;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Context group - The ContextGroup element holds context elements relating to
 * the level in the tree in which it occurs. Thus context can be set at a
 * {@link Group} level, a {@link TransUnit} level, or a {@link AltTrans} level.
 * Each ContextGroup element may be named, allowing different uses for each
 * group. When the ContextGroup is named, these uses can be controlled through
 * the use of XML processing instructions. Because the ContextGroup element may
 * occur at a very high level, a default context can be established for all
 * {@link TransUnit} elements within a file. This default can be overridden at
 * many subsequent levels. The optional {@link Name} attribute may uniquely
 * identify the ContextGroup within the {@link File} element. The optional
 * {@link Crc} attribute allows a verification of the data. The optional
 * {@link Purpose} attribute indicates to what use this context information is
 * used; e.g. {@link com.sap.mlt.xliff12.api.attribute.Purpose.Value#MATCH}
 * indicates the context information is for memory lookups.
 * 
 * @author D049314
 */
public interface ContextGroup extends XliffElement, TransUnit.Context,
		AltTrans.Context, BinUnit.Context {

	/**
	 * The element's name.
	 */
	final static String NAME = "context-group";

	/**
	 * Returns the <code>Crc</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Crc</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Crc getCrc();

	/**
	 * Sets the <code>Crc</code> attribute.
	 * 
	 * @param crc
	 *            The <code>Crc</code> attribute. May be <code>null</code>.
	 */
	void setCrc(Crc crc);

	/**
	 * Returns the <code>Name</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Name</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Name getContextGroupName();

	/**
	 * Sets the <code>Name</code> attribute.
	 * 
	 * @param name
	 *            The <code>Name</code> attribute. May be <code>null</code>.
	 */
	void setContextGroupName(Name name);

	/**
	 * Returns the <code>Purpose</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Purpose</code> attribute. Might be
	 *         <code>null</code> .
	 */
	Purpose getPurpose();

	/**
	 * Sets the <code>Purpose</code> attribute.
	 * 
	 * @param purpose
	 *            The <code>Purpose</code> attribute. May be <code>null</code>.
	 */
	void setPurpose(Purpose purpose);

	/**
	 * Returns the <code>Context</code> elements contained in this element.
	 * Returned list contains at least one {@link Context} element.
	 * 
	 * @return Returns the <code>Context</code> elements contained in this
	 *         element. Returned list contains at least one {@link Context}
	 *         element.
	 */
	List<Context> getContexts();

	/**
	 * Sets the <code>Context</code> elements of this element.
	 * 
	 * @param contexts
	 *            The <code>Context</code> elements. Must not be
	 *            <code>null</code>. Must contain at least one element.
	 */
	void setContexts(List<Context> contexts);

}
