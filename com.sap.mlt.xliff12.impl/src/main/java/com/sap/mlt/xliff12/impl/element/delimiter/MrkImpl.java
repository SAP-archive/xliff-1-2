package com.sap.mlt.xliff12.impl.element.delimiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Comment;
import com.sap.mlt.xliff12.api.attribute.Mid;
import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.element.inline.BptImpl;
import com.sap.mlt.xliff12.impl.element.inline.BxImpl;
import com.sap.mlt.xliff12.impl.element.inline.EptImpl;
import com.sap.mlt.xliff12.impl.element.inline.ExImpl;
import com.sap.mlt.xliff12.impl.element.inline.GImpl;
import com.sap.mlt.xliff12.impl.element.inline.ItImpl;
import com.sap.mlt.xliff12.impl.element.inline.PhImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class MrkImpl extends XliffElementImpl implements Mrk {

	public MrkImpl(Mtype mtype, List<? extends TextFragment> content) {
		super(NAME);
		setMtype(mtype);
		setContent(content);
	}

	public MrkImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<TextFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Mtype.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Mtype.NAME,
				Mid.NAME, Ts.NAME, Comment.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		MrkImpl source = (MrkImpl) elem;
		content = new ArrayList<TextFragment>();
		for (TextFragment tf : source.content) {
			content.add((TextFragment) tf.clone());
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
		content = CommonsParser.parseTextFragments(elementsAndText);
		attach(content);
	}

	public Comment getComment() {
		return (Comment) getXliffAttribute(Comment.NAME);
	}

	public List<? extends TextFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public Mid getMid() {
		return (Mid) getXliffAttribute(Mid.NAME);
	}

	public Mtype getMtype() {
		return (Mtype) getXliffAttribute(Mtype.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public void setComment(Comment comment) {
		if (comment == null) {
			clearXliffAttribute(Comment.NAME);
		} else {
			setAttribute(comment);
		}
	}

	public void setContent(List<? extends TextFragment> content) {
		Assert.notNull(content, "content");
		Assert.areInstances(content, "content", TextImpl.class, BptImpl.class,
				BxImpl.class, EptImpl.class, ExImpl.class, GImpl.class,
				ItImpl.class, MrkImpl.class, PhImpl.class, XImpl.class);
		assertNotAttached(content);
		detach(this.content);
		this.content = new ArrayList<TextFragment>(content);
		attach(this.content);
	}

	public void setMid(Mid mid) {
		if (mid == null) {
			clearXliffAttribute(Mid.NAME);
		} else {
			setAttribute(mid);
		}
	}

	public void setMtype(Mtype mtype) {
		Assert.notNull(mtype, "mtype");
		setAttribute(mtype);
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	/**
	 * @deprecated
	 */
	public void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts) {
		if (ts == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (TextFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

}
