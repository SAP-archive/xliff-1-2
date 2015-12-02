package com.sap.mlt.xliff12.impl.element.structural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.CharClass;
import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.api.attribute.ExType;
import com.sap.mlt.xliff12.api.attribute.ExtraData;
import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.api.attribute.HelpId;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.MaxBytes;
import com.sap.mlt.xliff12.api.attribute.MaxHeight;
import com.sap.mlt.xliff12.api.attribute.MaxWidth;
import com.sap.mlt.xliff12.api.attribute.Menu;
import com.sap.mlt.xliff12.api.attribute.MenuName;
import com.sap.mlt.xliff12.api.attribute.MenuOption;
import com.sap.mlt.xliff12.api.attribute.MergedTrans;
import com.sap.mlt.xliff12.api.attribute.MinBytes;
import com.sap.mlt.xliff12.api.attribute.MinHeight;
import com.sap.mlt.xliff12.api.attribute.MinWidth;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Group;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.MergedTransImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.SizeUnitImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class GroupImpl extends XliffElementImpl implements Group {

	public GroupImpl(List<? extends StructuralUnit> structuralUnits) {
		super(NAME);
		contextGroups = new ArrayList<ContextGroup>();
		countGroups = new ArrayList<CountGroup>();
		propGroups = new ArrayList<PropGroup>();
		notes = new ArrayList<Note>();
		nonXliffElements = new ArrayList<NonXliffElement>();
		setStructuralUnits(structuralUnits);
	}

	public GroupImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<ContextGroup> contextGroups;

	private ArrayList<CountGroup> countGroups;

	private ArrayList<PropGroup> propGroups;

	private ArrayList<Note> notes;

	private ArrayList<NonXliffElement> nonXliffElements;

	private ArrayList<StructuralUnit> structuralUnits;

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, true, false, Id.NAME,
				DataType.NAME, Ts.NAME, ResType.NAME, ResName.NAME,
				ExtraData.NAME, HelpId.NAME, Menu.NAME, MenuOption.NAME,
				MenuName.NAME, Coord.NAME, Font.NAME, CssStyle.NAME,
				Style.NAME, ExStyle.NAME, ExType.NAME, Translate.NAME,
				Reformat.NAME, MaxBytes.NAME, MinBytes.NAME, SizeUnit.NAME,
				MaxHeight.NAME, MinHeight.NAME, MaxWidth.NAME, MinWidth.NAME,
				CharClass.NAME, MergedTrans.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		GroupImpl source = (GroupImpl) elem;

		contextGroups = new ArrayList<ContextGroup>();
		for (ContextGroup contextGroup : source.contextGroups) {
			contextGroups.add((ContextGroup) contextGroup.clone());
		}
		attach(contextGroups);

		countGroups = new ArrayList<CountGroup>();
		for (CountGroup countGroup : source.countGroups) {
			countGroups.add((CountGroup) countGroup.clone());
		}
		attach(countGroups);

		propGroups = new ArrayList<PropGroup>();
		for (PropGroup propGroup : source.propGroups) {
			propGroups.add((PropGroup) propGroup.clone());
		}
		attach(propGroups);

		notes = new ArrayList<Note>();
		for (Note note : source.notes) {
			notes.add((Note) note.clone());
		}
		attach(notes);

		nonXliffElements = new ArrayList<NonXliffElement>();
		for (NonXliffElement nonXliffElement : source.nonXliffElements) {
			nonXliffElements.add((NonXliffElement) nonXliffElement.clone());
		}
		attach(nonXliffElements);

		structuralUnits = new ArrayList<StructuralUnit>();
		for (StructuralUnit su : source.structuralUnits) {
			structuralUnits.add((StructuralUnit) su.clone());
		}
		attach(structuralUnits);

	}

	@Override
	public List<? extends Node> getChildren() {
		ArrayList<Element> children = new ArrayList<Element>();
		children.addAll(contextGroups);
		children.addAll(countGroups);
		children.addAll(propGroups);
		children.addAll(notes);
		children.addAll(nonXliffElements);
		children.addAll(structuralUnits);
		return children;
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		contextGroups = new ArrayList<ContextGroup>();
		countGroups = new ArrayList<CountGroup>();
		propGroups = new ArrayList<PropGroup>();
		notes = new ArrayList<Note>();
		nonXliffElements = new ArrayList<NonXliffElement>();
		structuralUnits = new ArrayList<StructuralUnit>();

		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.nextIsXliffElement(ContextGroup.NAME)) {
			contextGroups.add(new ContextGroupImpl(iter.getElement()));
		}
		while (iter.nextIsXliffElement(CountGroup.NAME)) {
			countGroups.add(new CountGroupImpl(iter.getElement()));
		}
		while (iter.nextIsXliffElement(PropGroup.NAME)) {
			propGroups.add(new PropGroupImpl(iter.getElement()));
		}
		while (iter.nextIsXliffElement(Note.NAME)) {
			notes.add(new NoteImpl(iter.getElement()));
		}
		while (iter.nextIsNonXliffElement()) {
			nonXliffElements.add(new NonXliffElementImpl(iter.getElement()));
		}
		while (iter.hasNext()) {
			org.w3c.dom.Element element = iter.getXliffElement(Group.NAME,
					TransUnit.NAME, BinUnit.NAME);
			String name = element.getLocalName();
			if (Group.NAME.equals(name)) {
				structuralUnits.add(new GroupImpl(element));
			} else if (TransUnit.NAME.equals(name)) {
				structuralUnits.add(new TransUnitImpl(element));
			} else {
				structuralUnits.add(new BinUnitImpl(element));
			}
		}

		attach(contextGroups);
		attach(countGroups);
		attach(propGroups);
		attach(notes);
		attach(nonXliffElements);
		attach(structuralUnits);
	}

	public CharClass getCharClass() {
		return (CharClass) getXliffAttribute(CharClass.NAME);
	}

	public List<ContextGroup> getContextGroups() {
		return Collections.unmodifiableList(contextGroups);
	}

	public Coord getCoord() {
		return (Coord) getXliffAttribute(Coord.NAME);
	}

	public List<CountGroup> getCountGroups() {
		return Collections.unmodifiableList(countGroups);
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

	public Id getId() {
		return (Id) getXliffAttribute(Id.NAME);
	}

	public MaxBytes getMaxBytes() {
		return (MaxBytes) getXliffAttribute(MaxBytes.NAME);
	}

	public MaxHeight getMaxHeight() {
		return (MaxHeight) getXliffAttribute(MaxHeight.NAME);
	}

	public MaxWidth getMaxWidth() {
		return (MaxWidth) getXliffAttribute(MaxWidth.NAME);
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

	public MergedTrans getMergedTrans() {
		return (MergedTrans) getXliffAttribute(MergedTrans.NAME);
	}

	public MinBytes getMinBytes() {
		return (MinBytes) getXliffAttribute(MinBytes.NAME);
	}

	public MinHeight getMinHeight() {
		return (MinHeight) getXliffAttribute(MinHeight.NAME);
	}

	public MinWidth getMinWidth() {
		return (MinWidth) getXliffAttribute(MinWidth.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public List<NonXliffElement> getNonXliffElements() {
		return Collections.unmodifiableList(nonXliffElements);
	}

	public List<Note> getNotes() {
		return Collections.unmodifiableList(notes);
	}

	/**
	 * @deprecated
	 */
	public List<com.sap.mlt.xliff12.api.element.namedgroup.PropGroup> getPropGroups() {
		return Collections.unmodifiableList(propGroups);
	}

	public Reformat getReformat() {
		return (Reformat) getXliffAttribute(Reformat.NAME);
	}

	public ResName getResName() {
		return (ResName) getXliffAttribute(ResName.NAME);
	}

	public ResType getResType() {
		return (ResType) getXliffAttribute(ResType.NAME);
	}

	public SizeUnit getSizeUnit() {
		return (SizeUnit) getXliffAttribute(SizeUnit.NAME);
	}

	public List<? extends StructuralUnit> getStructuralUnits() {
		return Collections.unmodifiableList(structuralUnits);
	}

	public Style getStyle() {
		return (Style) getXliffAttribute(Style.NAME);
	}

	public Translate getTranslate() {
		return (Translate) getXliffAttribute(Translate.NAME);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public XmlSpace getXmlSpace() {
		return (XmlSpace) getAttribute(Schemas.XML_NAMESPACE, XmlSpace.NAME);
	}

	public void setCharClass(CharClass charClass) {
		if (charClass == null) {
			clearXliffAttribute(CharClass.NAME);
		} else {
			setAttribute(charClass);
		}
	}

	public void setContextGroups(List<ContextGroup> contextGroups) {
		Assert.notNull(contextGroups, "contextGroups");
		Assert.areInstances(contextGroups, "contextGroups",
				ContextGroupImpl.class);
		assertNotAttached(contextGroups);
		detach(this.contextGroups);
		this.contextGroups = new ArrayList<ContextGroup>(contextGroups);
		attach(this.contextGroups);
	}

	public void setCoord(Coord coord) {
		if (coord == null) {
			clearXliffAttribute(Coord.NAME);
		} else {
			setAttribute(coord);
		}
	}

	public void setCountGroups(List<CountGroup> countGroups) {
		Assert.notNull(countGroups, "countGroups");
		Assert.areInstances(countGroups, "countGroups", CountGroupImpl.class);
		assertNotAttached(countGroups);
		detach(this.countGroups);
		this.countGroups = new ArrayList<CountGroup>(countGroups);
		attach(this.countGroups);
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

	public void setId(Id id) {
		if (id == null) {
			clearXliffAttribute(Id.NAME);
		} else {
			setAttribute(id);
		}
	}

	public void setMaxBytes(MaxBytes maxBytes) {
		if (maxBytes == null) {
			clearXliffAttribute(MaxBytes.NAME);
		} else {
			setAttribute(maxBytes);
		}
	}

	public void setMaxHeight(MaxHeight maxHeight) {
		if (maxHeight == null) {
			clearXliffAttribute(MaxHeight.NAME);
		} else {
			setAttribute(maxHeight);
		}
	}

	public void setMaxWidth(MaxWidth maxWidth) {
		if (maxWidth == null) {
			clearXliffAttribute(MaxWidth.NAME);
		} else {
			setAttribute(maxWidth);
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

	public void setMergedTrans(MergedTrans mergedTrans) {
		if (mergedTrans == null) {
			setAttribute(new MergedTransImpl(MergedTrans.Value.NO));
		} else {
			setAttribute(mergedTrans);
		}
	}

	public void setMinBytes(MinBytes minBytes) {
		if (minBytes == null) {
			clearXliffAttribute(MinBytes.NAME);
		} else {
			setAttribute(minBytes);
		}
	}

	public void setMinHeight(MinHeight minHeight) {
		if (minHeight == null) {
			clearXliffAttribute(MinHeight.NAME);
		} else {
			setAttribute(minHeight);
		}
	}

	public void setMinWidth(MinWidth minWidth) {
		if (minWidth == null) {
			clearXliffAttribute(MinWidth.NAME);
		} else {
			setAttribute(minWidth);
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

	public void setNotes(List<Note> notes) {
		Assert.notNull(notes, "notes");
		Assert.areInstances(notes, "notes", NoteImpl.class);
		assertNotAttached(notes);
		detach(this.notes);
		this.notes = new ArrayList<Note>(notes);
		attach(this.notes);
	}

	/**
	 * @deprecated
	 */
	public void setPropGroups(List<PropGroup> propGroups) {
		Assert.notNull(propGroups, "propGroups");
		Assert.areInstances(propGroups, "propGroups", PropGroupImpl.class);
		assertNotAttached(propGroups);
		detach(this.propGroups);
		this.propGroups = new ArrayList<PropGroup>(propGroups);
		attach(this.propGroups);
	}

	public void setReformat(Reformat reformat) {
		if (reformat == null) {
			setAttribute(new ReformatYesNoImpl(true));
		} else {
			setAttribute(reformat);
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

	public void setSizeUnit(SizeUnit sizeUnit) {
		if (sizeUnit == null) {
			setAttribute(new SizeUnitImpl(SizeUnit.Value.PIXEL));
		} else {
			setAttribute(sizeUnit);
		}
	}

	public void setStructuralUnits(List<? extends StructuralUnit> units) {
		Assert.notNull(units, "units");
		Assert.areInstances(units, "units", TransUnitImpl.class,
				GroupImpl.class, BinUnitImpl.class);
		assertNotAttached(units);
		detach(this.structuralUnits);
		this.structuralUnits = new ArrayList<StructuralUnit>(units);
		attach(this.structuralUnits);
	}

	public void setStyle(Style style) {
		if (style == null) {
			clearXliffAttribute(Style.NAME);
		} else {
			setAttribute(style);
		}
	}

	public void setTranslate(Translate translate) {
		if (translate == null) {
			setAttribute(new TranslateImpl(Translate.Value.YES));
		} else {
			setAttribute(translate);
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
		defaults.add(new TranslateImpl(Translate.Value.YES));
		defaults.add(new ReformatYesNoImpl(true));
		defaults.add(new SizeUnitImpl(SizeUnit.Value.PIXEL));
		defaults.add(new MergedTransImpl(MergedTrans.Value.NO));
		return defaults;
	}

}
