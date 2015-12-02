package com.sap.mlt.xliff12.impl.element.header;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.api.attribute.From;
import com.sap.mlt.xliff12.api.attribute.Priority;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.attribute.AnnotatesImpl;
import com.sap.mlt.xliff12.impl.attribute.PriorityImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class NoteImpl extends XliffElementImpl implements Note {

	public NoteImpl(Text note) {
		super(NAME);
		setNote(note);
	}

	public NoteImpl(Element elem) throws ConstraintViolationException {
		super(NAME, elem);
	}

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, true, From.NAME,
				Priority.NAME, Annotates.NAME);
	}

	private Text note;

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		NoteImpl source = (NoteImpl) elem;
		note = (Text) source.note.clone();
		attach(note);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(note);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		if (!iter.hasNext()) {
			note = new TextImpl("");
		} else {
			String text = iter.getText();
			note = new TextImpl(text);
			iter.assertNoMoreNodes();
		}
		attach(note);
	}

	public Annotates getAnnotates() {
		return (Annotates) getXliffAttribute(Annotates.NAME);
	}

	public From getFrom() {
		return (From) getXliffAttribute(From.NAME);
	}

	public Text getNote() {
		return note;
	}

	public Priority getPriority() {
		return (Priority) getXliffAttribute(Priority.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
	}

	public void setAnnotates(Annotates annotates) {
		if (annotates == null) {
			setAnnotates(new AnnotatesImpl(Annotates.Value.GENERAL));
		} else {
			setAttribute(annotates);
		}
	}

	public void setFrom(From from) {
		if (from == null) {
			clearXliffAttribute(From.NAME);
		} else {
			setAttribute(from);
		}
	}

	public void setNote(Text note) {
		Assert.notNull(note, "note");
		Assert.isInstance(note, "note", TextImpl.class);
		assertNotAttached(note);
		detach(this.note);
		this.note = note;
		attach(this.note);
	}

	public void setPriority(Priority priority) {
		if (priority == null) {
			setPriority(new PriorityImpl(1));
		} else {
			setAttribute(priority);
		}
	}

	public void setXmlLang(XmlLang xmlLang) {
		if (xmlLang == null) {
			clearAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
		} else {
			setAttribute(xmlLang);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		ArrayList<Attribute> defaults = new ArrayList<Attribute>();
		defaults.add(new PriorityImpl(1));
		defaults.add(new AnnotatesImpl(Annotates.Value.GENERAL));
		return defaults;
	}
}
