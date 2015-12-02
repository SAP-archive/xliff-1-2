package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Approved;
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
import com.sap.mlt.xliff12.api.attribute.MinBytes;
import com.sap.mlt.xliff12.api.attribute.MinHeight;
import com.sap.mlt.xliff12.api.attribute.MinWidth;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Translation unit - The TransUnit elements contains a {@link Source},
 * {@link Target} and associated elements.
 * 
 * The required {@link Id} attribute is used to uniquely identify the TransUnit
 * within all TransUnit and {@link BinUnit} elements within the same
 * {@link File}. The optional {@link Approved} attribute indicates whether the
 * translation has been approved by a reviewer. The optional {@link Translate}
 * attribute indicates whether the TransUnit is to be translated. The optional
 * {@link Reformat} attribute specifies whether and which attributes can be
 * modified for the {@link Target} element of the TransUnit. The optional
 * {@link XmlSpace} attribute is used to specify how white-spaces are to be
 * treated within the TransUnit. The optional {@link DataType} attribute
 * specifies the data type of the content of the TransUnit; e.g.
 * {@link com.sap.mlt.xliff12.api.attribute.DataType.Value#WINRES} for Windows
 * resources. The optional {@link com.sap.mlt.xliff12.api.attribute.Ts}
 * attribute was DEPRECATED in XLIFF 1.1. The optional {@link PhaseName}
 * attribute references the phase that the TransUnit is in. The optional
 * {@link ResType}, {@link ResName}, {@link ExtraData}, {@link HelpId},
 * {@link Menu}, {@link MenuOption}, {@link MenuName}, {@link Coord},
 * {@link Font}, {@link CssStyle}, {@link Style}, {@link ExStyle}, and
 * {@link ExType} attributes describe the resource contained within the
 * TransUnit. The optional {@link MaxBytes} and {@link MinBytes} attributes
 * specify the required maximum and minimum number of bytes for the text inside
 * the {@link Source} and {@link Target} elements of the TransUnit. The optional
 * {@link SizeUnit} attribute determines the unit for the optional
 * {@link MaxHeight}, {@link MinHeight}, {@link MaxWidth}, and {@link MinWidth}
 * attributes, which limit the size of the resource described by the TransUnit.
 * The optional {@link CharClass} attribute restricts all {@link Source} and
 * {@link Target} text in the scope of the TransUnit to a subset of characters.
 * Lists of values for the {@link DataType}, {@link ResType}, and
 * {@link SizeUnit} attributes are provided. During translation the content of
 * the {@link Source} element may be duplicated into a {@link SegSource}
 * element, in which additional segmentation related markup is introduced.
 * 
 * @author D049314
 */
public interface TransUnit extends XliffElement, StructuralUnit,
		BinUnit.Context {

	/**
	 * The element's name.
	 */
	static final String NAME = "trans-unit";

	/**
	 * An {@link AltTrans}, {@link ContextGroup}, {@link CountGroup},
	 * {@link Note} or
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup} element.
	 * 
	 * @author D049314
	 */
	interface Context extends XliffElement {
	}

	/**
	 * Returns the <code>Approved</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Approved</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Approved getApproved();

	/**
	 * Returns the <code>CharClass</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>CharClass</code> attribute. Might be
	 *         <code>null</code>.
	 */
	CharClass getCharClass();

	/**
	 * Returns the <code>Coord</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Coord</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Coord getCoord();

	/**
	 * Returns the <code>CssStyle</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>CssStyle</code> attribute. Might be
	 *         <code>null</code>.
	 */
	CssStyle getCssStyle();

	/**
	 * Returns the <code>DataType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>DataType</code> attribute. Might be
	 *         <code>null</code>.
	 */
	DataType getDataType();

	/**
	 * Returns the <code>ExStyle</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ExStyle</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ExStyle getExStyle();

	/**
	 * Returns the <code>ExtraData</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ExtraData</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ExtraData getExtraData();

	/**
	 * Returns the <code>ExType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ExType</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ExType getExType();

	/**
	 * Returns the <code>Font</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Font</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Font getFont();

	/**
	 * Returns the <code>HelpId</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>HelpId</code> attribute. Might be
	 *         <code>null</code>.
	 */
	HelpId getHelpId();

	/**
	 * Returns the <code>Id</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Id</code> attribute. Might be <code>null</code>
	 *         .
	 */
	Id getId();

	/**
	 * Returns the <code>MaxBytes</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MaxBytes</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MaxBytes getMaxBytes();

	/**
	 * Returns the <code>MaxHeight</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MaxHeight</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MaxHeight getMaxHeight();

	/**
	 * Returns the <code>MaxWidth</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MaxWidth</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MaxWidth getMaxWidth();

	/**
	 * Returns the <code>Menu</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Menu</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Menu getMenu();

	/**
	 * Returns the <code>MenuName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MenuName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MenuName getMenuName();

	/**
	 * Returns the <code>MenuOption</code> attribute. Might be <code>null</code>
	 * .
	 * 
	 * @return Returns the <code>MenuOption</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MenuOption getMenuOption();

	/**
	 * Returns the <code>MinBytes</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MinBytes</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MinBytes getMinBytes();

	/**
	 * Returns the <code>MinHeight</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MinHeight</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MinHeight getMinHeight();

	/**
	 * Returns the <code>MinWidth</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MinWidth</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MinWidth getMinWidth();

	/**
	 * Returns the non-XLIFF attributes.
	 * 
	 * @return Returns the non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Returns the <code>PhaseName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>PhaseName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	PhaseName getPhaseName();

	/**
	 * Returns the <code>Reformat</code> attribute.
	 * 
	 * @return Returns the <code>Reformat</code> attribute.
	 */
	Reformat getReformat();

	/**
	 * Returns the <code>ResName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ResName</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ResName getResName();

	/**
	 * Returns the <code>ResType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ResType</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ResType getResType();

	/**
	 * Returns the <code>SizeUnit</code> attribute.
	 * 
	 * @return Returns the <code>SizeUnit</code> attribute.
	 */
	SizeUnit getSizeUnit();

	/**
	 * Returns the <code>Style</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Style</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Style getStyle();

	/**
	 * Returns the <code>Translate</code> attribute.
	 * 
	 * @return Returns the <code>Translate</code> attribute.
	 */
	Translate getTranslate();

	/**
	 * Returns the <code>Ts</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Ts</code> attribute. Might be <code>null</code>
	 *         .
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	com.sap.mlt.xliff12.api.attribute.Ts getTs();

	/**
	 * Returns the <code>XmlSpace</code> attribute.
	 * 
	 * @return Returns the <code>XmlSpace</code> attribute.
	 */
	XmlSpace getXmlSpace();

	/**
	 * Returns the <code>Source</code> element.
	 * 
	 * @return Returns the <code>Source</code> element.
	 */
	Source getSource();

	/**
	 * Returns the <code>SegSource</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>SegSource</code> element. Might be
	 *         <code>null</code> .
	 */
	SegSource getSegSource();

	/**
	 * Returns the <code>Target</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Target</code> element. Might be
	 *         <code>null</code>.
	 */
	Target getTarget();

	/**
	 * Returns the list of <code>Context</code> elements. This can be any
	 * combination of {@link AltTrans}, {@link ContextGroup}, {@link CountGroup}
	 * , {@link Note} and
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup} elements.
	 * 
	 * @return Returns the list of <code>Context</code> elements. This can be
	 *         any combination of {@link AltTrans}, {@link ContextGroup},
	 *         {@link CountGroup}, {@link Note} and
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup}
	 *         elements.
	 */
	List<? extends Context> getContext();

	/**
	 * Returns the non-XLIFF elements.
	 * 
	 * @return Returns the non-XLIFF elements.
	 */
	List<NonXliffElement> getNonXliffElements();

	/**
	 * Sets the <code>Approved</code> attribute.
	 * 
	 * @param approved
	 *            The <code>Approved</code> attribute. May be <code>null</code>.
	 */
	void setApproved(Approved approved);

	/**
	 * Sets the <code>CharClass</code> attribute.
	 * 
	 * @param charClass
	 *            The <code>CharClass</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setCharClass(CharClass charClass);

	/**
	 * Sets the <code>Coord</code> attribute.
	 * 
	 * @param coord
	 *            The <code>Coord</code> attribute. May be <code>null</code>.
	 */
	void setCoord(Coord coord);

	/**
	 * Sets the <code>CssStyle</code> attribute.
	 * 
	 * @param cssStyle
	 *            The <code>CssStyle</code> attribute. May be <code>null</code>.
	 */
	void setCssStyle(CssStyle cssStyle);

	/**
	 * Sets the <code>DataType</code> attribute.
	 * 
	 * @param dataType
	 *            The <code>DataType</code> attribute. May be <code>null</code>.
	 */
	void setDataType(DataType dataType);

	/**
	 * Sets the <code>ExStyle</code> attribute.
	 * 
	 * @param exStyle
	 *            The <code>ExStyle</code> attribute. May be <code>null</code>.
	 */
	void setExStyle(ExStyle exStyle);

	/**
	 * Sets the <code>ExtraData</code> attribute.
	 * 
	 * @param extraData
	 *            The <code>ExtraData</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setExtraData(ExtraData extraData);

	/**
	 * Sets the <code>ExType</code> attribute.
	 * 
	 * @param exType
	 *            The <code>ExType</code> attribute. May be <code>null</code>.
	 */
	void setExType(ExType exType);

	/**
	 * Sets the <code>Font</code> attribute.
	 * 
	 * @param font
	 *            The <code>Font</code> attribute. May be <code>null</code>.
	 */
	void setFont(Font font);

	/**
	 * Sets the <code>HelpId</code> attribute.
	 * 
	 * @param helpId
	 *            The <code>HelpId</code> attribute. May be <code>null</code>.
	 */
	void setHelpId(HelpId helpId);

	/**
	 * Sets the <code>Id</code> attribute.
	 * 
	 * @param id
	 *            The <code>Id</code> attribute. May be <code>null</code>.
	 */
	void setId(Id id);

	/**
	 * Sets the <code>MaxBytes</code> attribute.
	 * 
	 * @param maxBytes
	 *            The <code>MaxBytes</code> attribute. May be <code>null</code>.
	 */
	void setMaxBytes(MaxBytes maxBytes);

	/**
	 * Sets the <code>MaxHeight</code> attribute.
	 * 
	 * @param maxHeight
	 *            The <code>MaxHeight</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setMaxHeight(MaxHeight maxHeight);

	/**
	 * Sets the <code>MaxWidth</code> attribute.
	 * 
	 * @param maxWidth
	 *            The <code>MaxWidth</code> attribute. May be <code>null</code>.
	 */
	void setMaxWidth(MaxWidth maxWidth);

	/**
	 * Sets the <code>Menu</code> attribute.
	 * 
	 * @param menu
	 *            The <code>Menu</code> attribute. May be <code>null</code>.
	 */
	void setMenu(Menu menu);

	/**
	 * Sets the <code>MenuName</code> attribute.
	 * 
	 * @param menuName
	 *            The <code>MenuName</code> attribute. May be <code>null</code>.
	 */
	void setMenuName(MenuName menuName);

	/**
	 * Sets the <code>MenuOption</code> attribute.
	 * 
	 * @param menuOption
	 *            The <code>MenuOption</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setMenuOption(MenuOption menuOption);

	/**
	 * Sets the <code>MinBytes</code> attribute.
	 * 
	 * @param minBytes
	 *            The <code>MinBytes</code> attribute. May be <code>null</code>.
	 */
	void setMinBytes(MinBytes minBytes);

	/**
	 * Sets the <code>MinHeight</code> attribute.
	 * 
	 * @param minHeight
	 *            The <code>MinHeight</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setMinHeight(MinHeight minHeight);

	/**
	 * Sets the <code>MinWidth</code> attribute.
	 * 
	 * @param minWidth
	 *            The <code>MinWidth</code> attribute. May be <code>null</code>.
	 */
	void setMinWidth(MinWidth minWidth);

	/**
	 * Sets the non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Sets the <code>PhaseName</code> attribute.
	 * 
	 * @param phaseName
	 *            The <code>PhaseName</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setPhaseName(PhaseName phaseName);

	/**
	 * Sets the <code>Reformat</code> attribute.
	 * 
	 * @param reformat
	 *            The <code>Reformat</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>yes</code>.
	 */
	void setReformat(Reformat reformat);

	/**
	 * Sets the <code>ResName</code> attribute.
	 * 
	 * @param resName
	 *            The <code>ResName</code> attribute. May be <code>null</code>.
	 */
	void setResName(ResName resName);

	/**
	 * Sets the <code>ResType</code> attribute.
	 * 
	 * @param resType
	 *            The <code>ResType</code> attribute. May be <code>null</code>.
	 */
	void setResType(ResType resType);

	/**
	 * Sets the <code>SizeUnit</code> attribute.
	 * 
	 * @param sizeUnit
	 *            The <code>SizeUnit</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>pixel</code>.
	 */
	void setSizeUnit(SizeUnit sizeUnit);

	/**
	 * Sets the <code>Style</code> attribute.
	 * 
	 * @param style
	 *            The <code>Style</code> attribute. May be <code>null</code>.
	 */
	void setStyle(Style style);

	/**
	 * Sets the <code>Translate</code> attribute.
	 * 
	 * @param translate
	 *            The <code>Translate</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>yes</code>.
	 */
	void setTranslate(Translate translate);

	/**
	 * Sets the <code>Ts</code> attribute
	 * 
	 * @param ts
	 *            The <code>Ts</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts);

	/**
	 * Sets the <code>XmlSpace</code> attribute.
	 * 
	 * @param xmlSpace
	 *            The <code>XmlSpace</code> attribute. If this parameter is
	 *            <code>null</code>, the parameter is set to the default value
	 *            <code>default</code>.
	 */
	void setXmlSpace(XmlSpace xmlSpace);

	/**
	 * Sets the <code>Source</code> element.
	 * 
	 * @param source
	 *            The <code>Source</code> element. Must not be <code>null</code>
	 *            .
	 */
	void setSource(Source source);

	/**
	 * Set the <code>SegSource</code> element.
	 * 
	 * @param segSource
	 *            The <code>SegSource</code> element. May be <code>null</code>.
	 */
	void setSegSource(SegSource segSource);

	/**
	 * Set the <code>Target</code> element.
	 * 
	 * @param target
	 *            The <code>Target</code> element. May be <code>null</code>.
	 */
	void setTarget(Target target);

	/**
	 * Sets the <code>Context</code> elements.
	 * 
	 * @param context
	 *            The list of <code>Context</code> elements. Must not be
	 *            <code>null</code>. Can by any combination of {@link AltTrans},
	 *            {@link ContextGroup}, {@link CountGroup}, {@link Note} and
	 *            {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup}
	 *            elements.
	 */
	void setContext(List<? extends Context> context);

	/**
	 * Sets the non-XLIFF elements.
	 * 
	 * @param nonXliffElements
	 *            The non-XLIFF elements. Must not be <code>null</code>.
	 */
	void setNonXliffElements(List<NonXliffElement> nonXliffElements);

}
