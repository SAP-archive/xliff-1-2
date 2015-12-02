package com.sap.mlt.xliff12.impl.element.inline;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.inline.Ph;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CtypePhImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.InlineBaseImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class PhImpl extends InlineBaseImpl implements Ph {

	public PhImpl(Id id, List<? extends CodeFragment> content) {
		super(NAME, id);
		setContent(content);
	}

	public PhImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);

		// Fix wrong CtypeDelim attribute
		XliffAttribute xa = getXliffAttribute(CtypeDelim.NAME);
		if (xa instanceof CtypeDelim) {
			CtypeDelim ctype = (CtypeDelim) xa;
			if (!ctype.isXTended()) {
				String msg = MessageFormat.format(
						"Attribute ''ctype'' contains invalid value ''{0}''",
						ctype.getEnumValue().toString());
				throw new ConstraintViolationException(msg);
			}
			CtypePhImpl ctypePh = new CtypePhImpl(ctype.getXtendValue());
			setAttribute(ctypePh);
		}
	}

	private ArrayList<CodeFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME,
				CtypePh.NAME, Ts.NAME, Crc.NAME, Assoc.NAME, Xid.NAME,
				EquivText.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		PhImpl source = (PhImpl) elem;
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

	public Assoc getAssoc() {
		return (Assoc) getXliffAttribute(Assoc.NAME);
	}

	public List<? extends CodeFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public CtypePh getCtype() {
		return (CtypePh) getXliffAttribute(CtypePh.NAME);
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (CodeFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

	public void setAssoc(Assoc assoc) {
		if (assoc == null) {
			clearXliffAttribute(Assoc.NAME);
		} else {
			setAttribute(assoc);
		}
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

	public void setCtype(CtypePh ctype) {
		if (ctype == null) {
			clearXliffAttribute(CtypePh.NAME);
		} else {
			setAttribute(ctype);
		}
	}

}
