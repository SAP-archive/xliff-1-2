package com.sap.mlt.xliff12.impl.element.inline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.inline.G;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CloneImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.InlineBaseImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class GImpl extends InlineBaseImpl implements G {

	public GImpl(Id id, List<? extends TextFragment> content) {
		super(NAME, id);
		setContent(content);
	}
	
	public GImpl(org.w3c.dom.Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<TextFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME,
				CtypeDelim.NAME, Ts.NAME, Clone.NAME, Xid.NAME, EquivText.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		GImpl source = (GImpl) elem;
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


	public Clone getClone() {
		return (Clone) getXliffAttribute(Clone.NAME);
	}

	public List<? extends TextFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public CtypeDelim getCtype() {
		return (CtypeDelim) getXliffAttribute(CtypeDelim.NAME);
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (TextFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

	public void setClone(Clone clone) {
		if (clone == null) {
			setAttribute(new CloneImpl(Clone.Value.YES));
		} else {
			setAttribute(clone);
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

	public void setCtype(CtypeDelim ctype) {
		if (ctype == null) {
			clearXliffAttribute(CtypeDelim.NAME);
		} else {
			setAttribute(ctype);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.singleton(new CloneImpl(Clone.Value.YES));
	}

}
