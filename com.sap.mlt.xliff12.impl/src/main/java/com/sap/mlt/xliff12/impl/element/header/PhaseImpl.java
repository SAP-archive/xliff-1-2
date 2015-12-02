package com.sap.mlt.xliff12.impl.element.header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CompanyName;
import com.sap.mlt.xliff12.api.attribute.ContactEmail;
import com.sap.mlt.xliff12.api.attribute.ContactName;
import com.sap.mlt.xliff12.api.attribute.ContactPhone;
import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.api.attribute.JobId;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ProcessName;
import com.sap.mlt.xliff12.api.attribute.Tool;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class PhaseImpl extends XliffElementImpl implements Phase {

	public PhaseImpl(PhaseName phaseName, ProcessName processName) {
		super(NAME);
		notes = new ArrayList<Note>();
		setPhaseName(phaseName);
		setProcessName(processName);
	}

	public PhaseImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<Note> notes;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, PhaseName.NAME, ProcessName.NAME);
		Assert.xliffAttrRestricted(element, false, false, false,
				PhaseName.NAME, ProcessName.NAME, CompanyName.NAME, Tool.NAME,
				ToolId.NAME, Date.NAME, JobId.NAME, ContactName.NAME,
				ContactEmail.NAME, ContactPhone.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		PhaseImpl source = (PhaseImpl) elem;
		notes = new ArrayList<Note>();
		for (Note note : source.notes) {
			notes.add((Note) note.clone());
		}
		attach(notes);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(notes);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		notes = new ArrayList<Note>();
		
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.hasNext()) {
			notes.add(new NoteImpl(iter.getXliffElement(Note.NAME)));
		}
		
		attach(notes);
	}

	public CompanyName getCompanyName() {
		return (CompanyName) getXliffAttribute(CompanyName.NAME);
	}

	public ContactEmail getContactEmail() {
		return (ContactEmail) getXliffAttribute(ContactEmail.NAME);
	}

	public ContactName getContactName() {
		return (ContactName) getXliffAttribute(ContactName.NAME);
	}

	public ContactPhone getContactPhone() {
		return (ContactPhone) getXliffAttribute(ContactPhone.NAME);
	}

	public Date getDate() {
		return (Date) getXliffAttribute(Date.NAME);
	}

	public JobId getJobId() {
		return (JobId) getXliffAttribute(JobId.NAME);
	}

	public List<Note> getNotes() {
		return Collections.unmodifiableList(notes);
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public ProcessName getProcessName() {
		return (ProcessName) getXliffAttribute(ProcessName.NAME);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Tool getTool() {
		return (com.sap.mlt.xliff12.api.attribute.Tool) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Tool.NAME);
	}

	public ToolId getToolId() {
		return (ToolId) getXliffAttribute(ToolId.NAME);
	}

	public void setCompanyName(CompanyName companyName) {
		if (companyName == null) {
			clearXliffAttribute(CompanyName.NAME);
		} else {
			setAttribute(companyName);
		}
	}

	public void setContactEmail(ContactEmail contactEmail) {
		if (contactEmail == null) {
			clearXliffAttribute(ContactEmail.NAME);
		} else {
			setAttribute(contactEmail);
		}
	}

	public void setContactName(ContactName contactName) {
		if (contactName == null) {
			clearXliffAttribute(ContactName.NAME);
		} else {
			setAttribute(contactName);
		}
	}

	public void setContactPhone(ContactPhone contactPhone) {
		if (contactPhone == null) {
			clearXliffAttribute(ContactPhone.NAME);
		} else {
			setAttribute(contactPhone);
		}
	}

	public void setDate(Date date) {
		if (date == null) {
			clearXliffAttribute(Date.NAME);
		} else {
			setAttribute(date);
		}
	}

	public void setJobId(JobId jobId) {
		if (jobId == null) {
			clearXliffAttribute(JobId.NAME);
		} else {
			setAttribute(jobId);
		}
	}

	public void setNotes(List<Note> notes) {
		Assert.notNull(notes, "notes");
		Assert.areInstances(notes, "notes", NoteImpl.class);
		assertNotAttached(notes);
		detach(this.notes);
		this.notes = new ArrayList<Note>(notes);
		attach(this.notes);
	}

	public void setPhaseName(PhaseName phaseName) {
		Assert.notNull(phaseName, "phaseName");
		setAttribute(phaseName);
	}

	public void setProcessName(ProcessName processName) {
		Assert.notNull(processName, "processName");
		setAttribute(processName);
	}

	/**
	 * @deprecated
	 */
	public void setTool(com.sap.mlt.xliff12.api.attribute.Tool tool) {
		if (tool == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Tool.NAME);
		} else {
			setAttribute(tool);
		}
	}

	public void setToolId(ToolId toolId) {
		if (toolId == null) {
			clearXliffAttribute(ToolId.NAME);
		} else {
			setAttribute(toolId);
		}
	}

}
