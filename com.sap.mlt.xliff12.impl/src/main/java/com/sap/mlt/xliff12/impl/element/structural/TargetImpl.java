package com.sap.mlt.xliff12.impl.element.structural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.EquivTransImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.element.inline.BptImpl;
import com.sap.mlt.xliff12.impl.element.inline.BxImpl;
import com.sap.mlt.xliff12.impl.element.inline.EptImpl;
import com.sap.mlt.xliff12.impl.element.inline.ExImpl;
import com.sap.mlt.xliff12.impl.element.inline.GImpl;
import com.sap.mlt.xliff12.impl.element.inline.ItImpl;
import com.sap.mlt.xliff12.impl.element.inline.PhImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class TargetImpl extends XliffElementImpl implements Target {

	public TargetImpl(List<? extends TextFragment> content) {
		super(NAME);
		setContent(content);
	}

	public TargetImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<TextFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, false, true, State.NAME,
				StateQualifier.NAME, PhaseName.NAME, Ts.NAME, ResType.NAME,
				ResName.NAME, Coord.NAME, Font.NAME, CssStyle.NAME, Style.NAME,
				ExStyle.NAME, EquivTrans.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		TargetImpl source = (TargetImpl) elem;
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

	public List<? extends TextFragment> getContent() {
		return Collections.unmodifiableList(content);
	}


	public Coord getCoord() {
		return (Coord) getXliffAttribute(Coord.NAME);
	}

	public CssStyle getCssStyle() {
		return (CssStyle) getXliffAttribute(CssStyle.NAME);
	}

	public EquivTrans getEquivTrans() {
		return (EquivTrans) getXliffAttribute(EquivTrans.NAME);
	}

	public ExStyle getExStyle() {
		return (ExStyle) getXliffAttribute(ExStyle.NAME);
	}

	public Font getFont() {
		return (Font) getXliffAttribute(Font.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (TextFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

	public ResName getResName() {
		return (ResName) getXliffAttribute(ResName.NAME);
	}

	public ResType getResType() {
		return (ResType) getXliffAttribute(ResType.NAME);
	}

	public State getState() {
		return (State) getXliffAttribute(State.NAME);
	}

	public StateQualifier getStateQualifier() {
		return (StateQualifier) getXliffAttribute(StateQualifier.NAME);
	}

	public Style getStyle() {
		return (Style) getXliffAttribute(Style.NAME);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
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

	public void setCoord(Coord coord) {
		if (coord == null) {
			clearXliffAttribute(Coord.NAME);
		} else {
			setAttribute(coord);
		}
	}

	public void setCssStyle(CssStyle cssStyle) {
		if (cssStyle == null) {
			clearXliffAttribute(CssStyle.NAME);
		} else {
			setAttribute(cssStyle);
		}
	}

	public void setEquivTrans(EquivTrans equivTrans) {
		if (equivTrans == null) {
			setAttribute(new EquivTransImpl(EquivTrans.Value.YES));
		} else {
			setAttribute(equivTrans);
		}
	}

	public void setExStyle(ExStyle exStyle) {
		if (exStyle == null) {
			clearXliffAttribute(ExStyle.NAME);
		} else {
			setAttribute(exStyle);
		}
	}

	public void setFont(Font font) {
		if (font == null) {
			clearXliffAttribute(Font.NAME);
		} else {
			setAttribute(font);
		}
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Assert.notNull(nonXliffAttributes, "nonXliffAttributes");
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	public void setPhaseName(PhaseName phaseName) {
		if (phaseName == null) {
			clearXliffAttribute(PhaseName.NAME);
		} else {
			setAttribute(phaseName);
		}
	}

	public void setResName(ResName resName) {
		if (resName == null) {
			clearXliffAttribute(ResName.NAME);
		} else {
			setAttribute(resName);
		}
	}

	public void setResType(ResType resType) {
		if (resType == null) {
			clearXliffAttribute(ResType.NAME);
		} else {
			setAttribute(resType);
		}
	}

	public void setState(State state) {
		if (state == null) {
			clearXliffAttribute(State.NAME);
		} else {
			setAttribute(state);
		}
	}

	public void setStateQualifier(StateQualifier stateQualifier) {
		if (stateQualifier == null) {
			clearXliffAttribute(StateQualifier.NAME);
		} else {
			setAttribute(stateQualifier);
		}
	}

	public void setStyle(Style style) {
		if (style == null) {
			clearXliffAttribute(Style.NAME);
		} else {
			setAttribute(style);
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

	public void setXmlLang(XmlLang xmlLang) {
		if (xmlLang == null) {
			clearAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
		} else {
			setAttribute(xmlLang);
		}

	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections.singleton(new EquivTransImpl(EquivTrans.Value.YES));
	}
	
	

}
