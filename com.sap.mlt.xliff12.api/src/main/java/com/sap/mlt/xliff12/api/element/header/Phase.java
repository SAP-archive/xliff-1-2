package com.sap.mlt.xliff12.api.element.header;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.CompanyName;
import com.sap.mlt.xliff12.api.attribute.ContactEmail;
import com.sap.mlt.xliff12.api.attribute.ContactName;
import com.sap.mlt.xliff12.api.attribute.ContactPhone;
import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.api.attribute.JobId;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ProcessName;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Phase information - The Phase element contains metadata about the tasks
 * performed in a particular process. The required {@link PhaseName} attribute
 * uniquely identifies the phase for reference within the {@link File} element.
 * The required {@link ProcessName} attribute identifies the kind of process the
 * phase corresponds to; e.g. "proofreading". The optional {@link CompanyName}
 * attribute identifies the company performing the task. The optional
 * {@link ToolId} attribute references the {@link Tool} used in performing the
 * task. The optional {@link Date} attribute provides a timestamp indicating
 * when the task was performed. The optional {@link JobId} attribute allows an
 * ID to be assigned to the job. The optional {@link ContactName},
 * {@link ContactEmail}, and {@link ContactPhone} attributes all refer to the
 * person performing the task.
 * 
 * @author D049314
 */
public interface Phase extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "phase";

	/**
	 * Returns the <code>PhaseName</code> attribute.
	 * 
	 * @return Returns the <code>PhaseName</code> attribute.
	 */
	PhaseName getPhaseName();

	/**
	 * Sets the <code>PhaseName</code> attribute.
	 * 
	 * @param phaseName
	 *            The <code>PhaseName</code> attribute. Must not be
	 *            <code>null</code> .
	 */
	void setPhaseName(PhaseName phaseName);

	/**
	 * Returns the <code>ProcessName</code> attribute.
	 * 
	 * @return Returns the <code>ProcessName</code> attribute.
	 */
	ProcessName getProcessName();

	/**
	 * Sets the <code>ProcessName</code> attribute.
	 * 
	 * @param processName
	 *            The <code>ProcessName</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setProcessName(ProcessName processName);

	/**
	 * Returns the <code>CompanyName</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>CompanyName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	CompanyName getCompanyName();

	/**
	 * Sets the <code>CompanyName</code> attribute.
	 * 
	 * @param companyName
	 *            The <code>CompanyName</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setCompanyName(CompanyName companyName);

	/**
	 * Returns <code>Tool</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns <code>Tool</code> attribute. Might be <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	com.sap.mlt.xliff12.api.attribute.Tool getTool();

	/**
	 * Sets the <code>Tool</code> attribute.
	 * 
	 * @param tool
	 *            The <code>Tool</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	void setTool(com.sap.mlt.xliff12.api.attribute.Tool tool);

	/**
	 * Returns the <code>ToolId</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ToolId</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ToolId getToolId();

	/**
	 * Sets the <code>ToolId</code> attribute. Before serialization a
	 * {@link Tool} element with this id must exist in the XLIFF this phase is a
	 * member of.
	 * 
	 * @param toolId
	 *            The <code>ToolId</code> attribute. May be <code>null</code>.
	 */
	void setToolId(ToolId toolId);

	/**
	 * Returns the <code>Date</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Date</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Date getDate();

	/**
	 * Sets the <code>Date</code> attribute.
	 * 
	 * @param date
	 *            The <code>Date</code> attribute. May be <code>null</code>.
	 */
	void setDate(Date date);

	/**
	 * Returns the <code>JobId</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>JobId</code> attribute. Might be
	 *         <code>null</code>.
	 */
	JobId getJobId();

	/**
	 * Sets the <code>JobId</code> attribute.
	 * 
	 * @param jobId
	 *            The <code>JobId</code> attribute. May be <code>null</code>.
	 */
	void setJobId(JobId jobId);

	/**
	 * Returns the <code>ContactName</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ContactName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ContactName getContactName();

	/**
	 * Sets the <code>ContactName</code> attribute.
	 * 
	 * @param contactName
	 *            The <code>ContactName</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setContactName(ContactName contactName);

	/**
	 * Returns the <code>ContactEmail</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ContactEmail</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ContactEmail getContactEmail();

	/**
	 * Sets the <code>ContactEmail</code> attribute.
	 * 
	 * @param contactEmail
	 *            The <code>ContactEmail</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setContactEmail(ContactEmail contactEmail);

	/**
	 * Returns the <code>ContactPhone</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ContactPhone</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ContactPhone getContactPhone();

	/**
	 * Sets the <code>ContactPhone</code> attribute.
	 * 
	 * @param contactPhone
	 *            The <code>ContactPhone</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setContactPhone(ContactPhone contactPhone);

	/**
	 * Returns the list of child <code>Note</code> elements.
	 * 
	 * @return Returns the list of child <code>Note</code> elements.
	 */
	List<Note> getNotes();

	/**
	 * Sets the child <code>Note</code>s.
	 * 
	 * @param notes
	 *            The list of child <code>Note</code> s. Must not be
	 *            <code>null</code> .
	 */
	void setNotes(List<Note> notes);
}
