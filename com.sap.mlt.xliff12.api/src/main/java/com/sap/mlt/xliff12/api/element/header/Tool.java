package com.sap.mlt.xliff12.api.element.header;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.ToolCompany;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.api.attribute.ToolVersion;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Tool - The Tool element describes the tool that has been used to execute a
 * given task in the document. The required {@link ToolId} attribute uniquely
 * identifies the tool for reference within the {@link File} element. The
 * required {@link ToolName} attribute specifies the actual tool name. The
 * optional {@link ToolVersion} attribute provides the version of the tool. The
 * optional {@link ToolCompany} attribute provides the name of the company that
 * produced the tool.
 * 
 * @author D049314
 */
public interface Tool extends XliffElement, Header.Context {

	/**
	 * The element's name.
	 */
	static final String NAME = "tool";

	/**
	 * Returns the <code>ToolId</code> attribute.
	 * 
	 * @return Returns the <code>ToolId</code> attribute.
	 */
	ToolId getToolId();

	/**
	 * Sets the <code>ToolId</code> attribute.
	 * 
	 * @param toolId
	 *            The <code>ToolId</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setToolId(ToolId toolId);

	/**
	 * Returns the <code>ToolName</code> attribute.
	 * 
	 * @return Returns the <code>ToolName</code> attribute.
	 */
	ToolName getToolName();

	/**
	 * Sets the <code>ToolName</code> attribute.
	 * 
	 * @param toolName
	 *            The <code>ToolName</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setToolName(ToolName toolName);

	/**
	 * Returns the <code>ToolVersion</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ToolVersion</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ToolVersion getToolVersion();

	/**
	 * Sets the <code>ToolVersion</code> attribute.
	 * 
	 * @param toolVersion
	 *            The <code>ToolVersion</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setToolVersion(ToolVersion toolVersion);

	/**
	 * Returns the <code>ToolCompany</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ToolCompany</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ToolCompany getToolCompany();

	/**
	 * Sets the <code>ToolCompany</code> attribute.
	 * 
	 * @param toolCompany
	 *            The <code>ToolCompany</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setToolCompany(ToolCompany toolCompany);

	/**
	 * Returns the element's non-XLIFF attributes.
	 * 
	 * @return Returns the element's non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Sets the element's non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The element's non-XLIFF attributes. Must not be
	 *            <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Returns this element's child nodes. Please note: While the specification
	 * allows non-XLIFF elements only, the schema allows any elements and text
	 * contents.
	 * 
	 * @return Returns this element's child nodes. Please note: While the
	 *         specification allows non-XLIFF elements only, the schema allows
	 *         any elements and text contents.
	 */
	List<? extends Node> getChildren();

	/**
	 * Sets the element's child nodes.
	 * 
	 * @param children
	 *            The element's child nodes. Must not be <code>null</code>.
	 *            Please note: While the specification allows non-XLIFF elements
	 *            only, the schema allows any elements and text contents.
	 */
	void setChildren(List<? extends Node> children);

}
