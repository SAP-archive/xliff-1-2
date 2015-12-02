package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.attribute.MatchMandatoryImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class ContextImpl extends XliffElementImpl implements Context {

	public ContextImpl(ContextType contextType, Text content) {
		super(NAME);
		setContextType(contextType);
		setContent(content);
	}

	public ContextImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private Text content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, ContextType.NAME);
		Assert.xliffAttrRestricted(element, false, false, false,
				ContextType.NAME, MatchMandatory.NAME, Crc.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		ContextImpl source = (ContextImpl) elem;
		content = (Text) source.content.clone();
		attach(content);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(content);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		if (iter.hasNext()) {
			content = new TextImpl(iter.getText());
			iter.assertNoMoreNodes();
		} else {
			content = new TextImpl("");
		}
		attach(content);
	}

	public Text getContent() {
		return content;
	}

	public ContextType getContextType() {
		return (ContextType) getXliffAttribute(ContextType.NAME);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public MatchMandatory getMatchMandatory() {
		return (MatchMandatory) getXliffAttribute(MatchMandatory.NAME);
	}

	public void setContent(Text content) {
		Assert.notNull(content, "content");
		Assert.isInstance(content, "content", TextImpl.class);
		assertNotAttached(content);
		detach(this.content);
		this.content = content;
		attach(this.content);
	}

	public void setContextType(ContextType contextType) {
		Assert.notNull(contextType, "contextType");
		setAttribute(contextType);
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setMatchMandatory(MatchMandatory matchMandatory) {
		if (matchMandatory == null) {
			setAttribute(new MatchMandatoryImpl(MatchMandatory.Value.NO));
		} else {
			setAttribute(matchMandatory);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.singleton(new MatchMandatoryImpl(MatchMandatory.Value.NO));
	}
	
}
