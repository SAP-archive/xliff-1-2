package com.sap.mlt.xliff12.impl.element.inline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.inline.It;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.InlineBaseImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class ItImpl extends InlineBaseImpl implements It {

	public ItImpl(Id id, Pos pos, List<? extends CodeFragment> content) {
		super(NAME, id);
		setPos(pos);
		setContent(content);
	}

	public ItImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<CodeFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME, Pos.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME, Pos.NAME,
				Rid.NAME, CtypeDelim.NAME, Ts.NAME, Crc.NAME, Xid.NAME,
				EquivText.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		ItImpl source = (ItImpl) elem;
		content = new ArrayList<CodeFragment>();
		for (CodeFragment cf : source.content) {
			content.add((CodeFragment) cf.clone());
		}
		attach(content);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(content);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		content = CommonsParser.parseCodeFragments(elementsAndText);
		attach(content);
	}

	public List<? extends CodeFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public CtypeDelim getCtype() {
		return (CtypeDelim) getXliffAttribute(CtypeDelim.NAME);
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (CodeFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

	public Pos getPos() {
		return (Pos) getXliffAttribute(Pos.NAME);
	}

	public Rid getRid() {
		return (Rid) getXliffAttribute(Rid.NAME);
	}

	public void setContent(List<? extends CodeFragment> content) {
		Assert.notNull(content, "content");
		Assert.areInstances(content, "content", TextImpl.class, SubImpl.class);
		assertNotAttached(content);
		detach(this.content);
		this.content = new ArrayList<CodeFragment>(content);
		attach(this.content);
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setCtype(CtypeDelim ctype) {
		if (ctype == null) {
			clearXliffAttribute(CtypeDelim.NAME);
		} else {
			setAttribute(ctype);
		}
	}

	public void setPos(Pos pos) {
		Assert.notNull(pos, "pos");
		setAttribute(pos);
	}

	public void setRid(Rid rid) {
		if (rid == null) {
			clearXliffAttribute(Rid.NAME);
		} else {
			setAttribute(rid);
		}
	}

}
