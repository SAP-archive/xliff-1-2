package com.sap.mlt.xliff12.impl.element.structural;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.AltTransType;
import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.api.attribute.ExType;
import com.sap.mlt.xliff12.api.attribute.ExtraData;
import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.api.attribute.HelpId;
import com.sap.mlt.xliff12.api.attribute.MatchQuality;
import com.sap.mlt.xliff12.api.attribute.Menu;
import com.sap.mlt.xliff12.api.attribute.MenuName;
import com.sap.mlt.xliff12.api.attribute.MenuOption;
import com.sap.mlt.xliff12.api.attribute.Mid;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Origin;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.Tool;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.SegSource;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.AltTransTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class AltTransImpl extends XliffElementImpl implements AltTrans {

	public AltTransImpl(Target target) {
		super(NAME);
		context = new ArrayList<Context>();
		nonXliffElements = new ArrayList<NonXliffElement>();
		setTarget(target);
	}

	public AltTransImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private Source source;

	private SegSource segSource;

	private List<Target> targets;

	private List<Context> context;

	private List<NonXliffElement> nonXliffElements;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, true, true, Mid.NAME,
				MatchQuality.NAME, Tool.NAME, ToolId.NAME, Crc.NAME,
				DataType.NAME, Ts.NAME, ResType.NAME, ResName.NAME,
				ExtraData.NAME, HelpId.NAME, Menu.NAME, MenuOption.NAME,
				MenuName.NAME, Coord.NAME, Font.NAME, CssStyle.NAME,
				Style.NAME, ExStyle.NAME, ExType.NAME, Origin.NAME,
				PhaseName.NAME, AltTransType.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		AltTransImpl source = (AltTransImpl) elem;

		if (source.source != null) {
			this.source = (Source) source.source.clone();
			attach(this.source);
		}

		if (source.segSource != null) {
			segSource = (SegSource) source.segSource.clone();
			attach(segSource);
		}

		targets = new ArrayList<Target>();
		for (Target target : source.targets) {
			targets.add((Target) target.clone());
		}
		attach(targets);

		context = new ArrayList<Context>();
		for (Context ctx : source.context) {
			context.add((Context) ctx.clone());
		}
		attach(context);

		nonXliffElements = new ArrayList<NonXliffElement>();
		for (NonXliffElement nonXliffElement : source.nonXliffElements) {
			nonXliffElements.add((NonXliffElement) nonXliffElement.clone());
		}
		attach(nonXliffElements);
	}

	@Override
	public List<? extends Node> getChildren() {
		ArrayList<Node> ret = new ArrayList<Node>();
		if (source != null) {
			ret.add(source);
		}
		if (segSource != null) {
			ret.add(segSource);
		}
		ret.addAll(targets);
		ret.addAll(context);
		ret.addAll(nonXliffElements);
		return ret;
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		targets = new ArrayList<Target>();
		context = new ArrayList<Context>();
		nonXliffElements = new ArrayList<NonXliffElement>();

		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.nextIsXliffElement()) {
			org.w3c.dom.Element element = iter.getXliffElement(Source.NAME,
					SegSource.NAME, Target.NAME, ContextGroup.NAME,
					PropGroup.NAME, Note.NAME);
			String name = element.getLocalName();
			if (Source.NAME.equals(name)) {
				if (source != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed per <{1}> element",
									Source.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				source = new SourceImpl(element);
			} else if (SegSource.NAME.equals(name)) {
				if (segSource != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed per <{1}> element",
									SegSource.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				segSource = new SegSourceImpl(element);
			} else if (Target.NAME.equals(name)) {
				targets.add(new TargetImpl(element));
			} else if (ContextGroup.NAME.equals(name)) {
				context.add(new ContextGroupImpl(element));
			} else if (PropGroup.NAME.equals(name)) {
				context.add(new PropGroupImpl(element));
			} else if (Note.NAME.equals(name)) {
				context.add(new NoteImpl(element));
			}
		}
		while (iter.hasNext()) {
			nonXliffElements.add(new NonXliffElementImpl(iter
					.getNonXliffElement()));
		}

		if (targets.isEmpty()) {
			String msg = MessageFormat.format(
					"A <{0}> element must contain a <{1}> element", NAME,
					Target.NAME);
			throw new ConstraintViolationException(msg);
		}

		attach(source);
		attach(segSource);
		attach(targets);
		attach(context);
		attach(nonXliffElements);
	}

	public AltTransType getAltTransType() {
		return (AltTransType) getXliffAttribute(AltTransType.NAME);
	}

	public List<? extends Context> getContext() {
		return Collections.unmodifiableList(context);
	}

	public Coord getCoord() {
		return (Coord) getXliffAttribute(Coord.NAME);
	}

	public Crc getCrc() {
		return (Crc) getXliffAttribute(Crc.NAME);
	}

	public CssStyle getCssStyle() {
		return (CssStyle) getXliffAttribute(CssStyle.NAME);
	}

	public DataType getDataType() {
		return (DataType) getXliffAttribute(DataType.NAME);
	}

	public ExStyle getExStyle() {
		return (ExStyle) getXliffAttribute(ExStyle.NAME);
	}

	public ExType getExType() {
		return (ExType) getXliffAttribute(ExType.NAME);
	}

	public ExtraData getExtraData() {
		return (ExtraData) getXliffAttribute(ExtraData.NAME);
	}

	public Font getFont() {
		return (Font) getXliffAttribute(Font.NAME);
	}

	public HelpId getHelpId() {
		return (HelpId) getXliffAttribute(HelpId.NAME);
	}

	public MatchQuality getMatchQuality() {
		return (MatchQuality) getXliffAttribute(MatchQuality.NAME);
	}

	public Menu getMenu() {
		return (Menu) getXliffAttribute(Menu.NAME);
	}

	public MenuName getMenuName() {
		return (MenuName) getXliffAttribute(MenuName.NAME);
	}

	public MenuOption getMenuOption() {
		return (MenuOption) getXliffAttribute(MenuOption.NAME);
	}

	public Mid getMid() {
		return (Mid) getXliffAttribute(Mid.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public List<NonXliffElement> getNonXliffElements() {
		return Collections.unmodifiableList(nonXliffElements);
	}

	public Origin getOrigin() {
		return (Origin) getXliffAttribute(Origin.NAME);
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public ResName getResName() {
		return (ResName) getXliffAttribute(ResName.NAME);
	}

	public ResType getResType() {
		return (ResType) getXliffAttribute(ResType.NAME);
	}

	public SegSource getSegSource() {
		return segSource;
	}

	public Source getSource() {
		return source;
	}

	public Style getStyle() {
		return (Style) getXliffAttribute(Style.NAME);
	}

	public Target getTarget() {
		return targets.get(0);
	}

	public List<Target> getTargets() {
		return Collections.unmodifiableList(targets);
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

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
	}

	public XmlSpace getXmlSpace() {
		return (XmlSpace) getAttribute(Schemas.XML_NAMESPACE, XmlSpace.NAME);
	}

	public void setAltTransType(AltTransType altTransType) {
		if (altTransType == null) {
			setAttribute(new AltTransTypeImpl(AltTransType.Value.PROPOSAL));
		} else {
			setAttribute(altTransType);
		}
	}

	public void setContext(List<? extends Context> context) {
		Assert.notNull(context, "context");
		Assert.areInstances(context, "context", ContextGroupImpl.class,
				NoteImpl.class, PropGroup.class);
		assertNotAttached(context);
		detach(this.context);
		this.context = new ArrayList<Context>(context);
		attach(this.context);
	}

	public void setCoord(Coord coord) {
		if (coord == null) {
			clearXliffAttribute(Coord.NAME);
		} else {
			setAttribute(coord);
		}
	}

	public void setCrc(Crc crc) {
		if (crc == null) {
			clearXliffAttribute(Crc.NAME);
		} else {
			setAttribute(crc);
		}
	}

	public void setCssStyle(CssStyle cssStyle) {
		if (cssStyle == null) {
			clearXliffAttribute(CssStyle.NAME);
		} else {
			setAttribute(cssStyle);
		}
	}

	public void setDataType(DataType dataType) {
		if (dataType == null) {
			clearXliffAttribute(DataType.NAME);
		} else {
			setAttribute(dataType);
		}
	}

	public void setExStyle(ExStyle exStyle) {
		if (exStyle == null) {
			clearXliffAttribute(ExStyle.NAME);
		} else {
			setAttribute(exStyle);
		}
	}

	public void setExType(ExType exType) {
		if (exType == null) {
			clearXliffAttribute(ExType.NAME);
		} else {
			setAttribute(exType);
		}
	}

	public void setExtraData(ExtraData extraData) {
		if (extraData == null) {
			clearXliffAttribute(ExtraData.NAME);
		} else {
			setAttribute(extraData);
		}
	}

	public void setFont(Font font) {
		if (font == null) {
			clearXliffAttribute(Font.NAME);
		} else {
			setAttribute(font);
		}
	}

	public void setHelpId(HelpId helpId) {
		if (helpId == null) {
			clearXliffAttribute(HelpId.NAME);
		} else {
			setAttribute(helpId);
		}
	}

	public void setMatchQuality(MatchQuality matchQuality) {
		if (matchQuality == null) {
			clearXliffAttribute(MatchQuality.NAME);
		} else {
			setAttribute(matchQuality);
		}
	}

	public void setMenu(Menu menu) {
		if (menu == null) {
			clearXliffAttribute(Menu.NAME);
		} else {
			setAttribute(menu);
		}
	}

	public void setMenuName(MenuName menuName) {
		if (menuName == null) {
			clearXliffAttribute(MenuName.NAME);
		} else {
			setAttribute(menuName);
		}
	}

	public void setMenuOption(MenuOption menuOption) {
		if (menuOption == null) {
			clearXliffAttribute(MenuOption.NAME);
		} else {
			setAttribute(menuOption);
		}
	}

	public void setMid(Mid mid) {
		if (mid == null) {
			clearXliffAttribute(Mid.NAME);
		} else {
			setAttribute(mid);
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

	public void setNonXliffElements(List<NonXliffElement> nonXliffElements) {
		Assert.notNull(nonXliffElements, "nonXliffElements");
		Assert.areInstances(nonXliffElements, "nonXliffElements",
				NonXliffElementImpl.class);
		assertNotAttached(nonXliffElements);
		detach(this.nonXliffElements);
		this.nonXliffElements = new ArrayList<NonXliffElement>(nonXliffElements);
		attach(this.nonXliffElements);
	}

	public void setOrigin(Origin origin) {
		if (origin == null) {
			clearXliffAttribute(Origin.NAME);
		} else {
			setAttribute(origin);
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

	public void setSource(Source source) {
		Assert.isInstance(source, "source", SourceImpl.class);
		assertNotAttached(source);
		detach(this.source);
		this.source = source;
		attach(this.source);
	}

	public void setSegSource(SegSource segSource) {
		Assert.isInstance(segSource, "segSource", SegSourceImpl.class);
		assertNotAttached(segSource);
		detach(this.segSource);
		this.segSource = segSource;
		attach(this.segSource);
	}

	public void setStyle(Style style) {
		if (style == null) {
			clearXliffAttribute(Style.NAME);
		} else {
			setAttribute(style);
		}
	}

	public void setTarget(Target target) {
		Assert.notNull(target, "target");
		this.targets = Collections.singletonList(target);
	}

	public void setTargets(List<Target> targets) {
		Assert.notNull(targets, "targets");
		if (targets.isEmpty()) {
			throw new IllegalArgumentException(
					"An <alt-trans> element must contain at least one <target> element");
		}
		Assert.areInstances(targets, "targets", TargetImpl.class);
		assertNotAttached(targets);
		detach(this.targets);
		this.targets = new ArrayList<Target>(targets);
		attach(this.targets);
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

	public void setXmlSpace(XmlSpace xmlSpace) {
		if (xmlSpace == null) {
			setAttribute(new XmlSpaceImpl(XmlSpace.Value.DEFAULT));
		} else {
			setAttribute(xmlSpace);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		ArrayList<Attribute> defaults = new ArrayList<Attribute>();
		defaults.add(new XmlSpaceImpl(XmlSpace.Value.DEFAULT));
		defaults.add(new AltTransTypeImpl(AltTransType.Value.PROPOSAL));
		return defaults;
	}

}
