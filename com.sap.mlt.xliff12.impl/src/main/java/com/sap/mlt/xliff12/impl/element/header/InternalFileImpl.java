package com.sap.mlt.xliff12.impl.element.header;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Form;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class InternalFileImpl extends XliffElementImpl implements InternalFile {

	public InternalFileImpl(Text embeddedFile) {
		super(NAME);
		setEmbeddedFile(embeddedFile);
	}

	public InternalFileImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}
	
	private Text embeddedFile;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false, Form.NAME,
				Crc.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		InternalFileImpl source = (InternalFileImpl) elem;
		embeddedFile = (Text) source.embeddedFile.clone();
		attach(embeddedFile);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(embeddedFile);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		if (!iter.hasNext()) {
			embeddedFile = new TextImpl("");
		} else {
			String text = iter.getText();
			embeddedFile = new TextImpl(text);
			iter.assertNoMoreNodes();
		}
		attach(embeddedFile);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public Text getEmbeddedFile() {
		return embeddedFile;
	}

	public Form getForm() {
		return (Form) getXliffAttribute(Form.NAME);
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setEmbeddedFile(Text embeddedFile) {
		Assert.notNull(embeddedFile, "embeddedFile");
		Assert.isInstance(embeddedFile, "embeddedFile", TextImpl.class);
		assertNotAttached(embeddedFile);
		detach(this.embeddedFile);
		this.embeddedFile = embeddedFile;
		attach(this.embeddedFile);
	}

	public void setForm(Form form) {
		if (form == null) {
			clearXliffAttribute(Form.NAME);
		} else {
			setAttribute(form);
		}
	}

}
