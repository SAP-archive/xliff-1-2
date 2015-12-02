package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;
import java.util.List;

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
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.header.Tool;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;

/**
 * Translation match - The AltTrans element contains possible translations in
 * {@link Target} elements along with optional context, notes, etc. The optional
 * {@link Mid} attribute indicates that the AltTrans applies only to a specific
 * {@link Mrk} segment in the {@link SegSource} element of the {@link TransUnit}
 * . The optional {@link MatchQuality} attribute provides a value indicating the
 * exactness of the match between the {@link Source} of the AltTrans and that of
 * the {@link Source} element of the parent {@link TransUnit}; e.g. "90%". The
 * optional {@link ToolId} attribute accepts the id of the {@link Tool} used to
 * generate this AltTrans. The optional {@link Crc} attribute allows a
 * verification of the data. The optional {@link XmlLang} attribute is used to
 * specify the content language of the AltTrans. The optional {@link XmlSpace}
 * attribute is used to specify how white-spaces are to be treated within the
 * AltTrans. The optional {@link DataType} attribute specifies the data type of
 * the content of the AltTrans; e.g.
 * {@link com.sap.mlt.xliff12.api.attribute.DataType.Value#WINRES} for Windows
 * resources. The optional {@link ResType}, {@link ResName}, {@link ExtraData},
 * {@link HelpId}, {@link Menu}, {@link MenuOption}, {@link MenuName},
 * {@link Coord}, {@link Font}, {@link CssStyle}, {@link Style}, {@link ExStyle}
 * , and {@link ExType} attributes describe the resource contained within the
 * AltTrans. The optional {@link Origin} attribute specifies where the alternate
 * translation comes from; e.g. a previous version of the product. The
 * {@link com.sap.mlt.xliff12.api.attribute.Tool} and
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attributes were DEPRECATED in
 * XLIFF 1.1. Multiple {@link Target} elements within a single {@link AltTrans}
 * are DEPRECATED in XLIFF 1.2. A list of values for the {@link DataType} and
 * {@link ResType} attributes are provided.
 * 
 * @author D049314
 */
public interface AltTrans extends XliffElement, TransUnit.Context {

	/**
	 * The element's name.
	 */
	static final String NAME = "alt-trans";

	/**
	 * A {@link ContextGroup}, {@link Note} or
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup} element
	 * 
	 * @author D049314
	 */
	interface Context extends XliffElement {
	}

	/**
	 * Returns the <code>AltTransType</code> attribute.
	 * 
	 * @return Returns the <code>AltTransType</code> attribute.
	 */
	AltTransType getAltTransType();

	/**
	 * Returns the <code>Coord</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Coord</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Coord getCoord();

	/**
	 * Returns the <code>Crc</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Crc</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Crc getCrc();

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
	 * Returns the <code>MatchQuality</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>MatchQuality</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MatchQuality getMatchQuality();

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
	 * Returns the <code>Mid</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Mid</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Mid getMid();

	/**
	 * Returns non-XLIFF attributes.
	 * 
	 * @return Returns non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Returns the <code>Origin</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Origin</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Origin getOrigin();

	/**
	 * Returns the <code>PhaseName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>PhaseName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	PhaseName getPhaseName();

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
	 * Sets the <code>AltTransType</code> attribute.
	 * 
	 * @param altTransType
	 *            The <code>AltTransType</code> attribute. If this parameter is
	 *            <code>null</code>, the default value <code>proposal</code> is
	 *            set.
	 */
	void setAltTransType(AltTransType altTransType);

	/**
	 * Sets the <code>Coord</code> attribute.
	 * 
	 * @param coord
	 *            The <code>Coord</code> attribute. May be <code>null</code>.
	 */
	void setCoord(Coord coord);

	/**
	 * Sets the <code>Crc</code> attribute.
	 * 
	 * @param crc
	 *            The <code>Crc</code> attribute. May be <code>null</code>.
	 */
	void setCrc(Crc crc);

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
	 * Sets the <code>MatchQuality</code> attribute.
	 * 
	 * @param matchQuality
	 *            The <code>MatchQuality</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setMatchQuality(MatchQuality matchQuality);

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
	 * Sets the <code>Mid</code> attribute.
	 * 
	 * @param mid
	 *            The <code>Mid</code> attribute. May be <code>null</code>.
	 */
	void setMid(Mid mid);

	/**
	 * Sets the element's non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Sets the <code>Origin</code> attribute.
	 * 
	 * @param origin
	 *            The <code>Origin</code> attribute. May be <code>null</code>.
	 */
	void setOrigin(Origin origin);

	/**
	 * Sets the <code>PhaseName</code> attribute.
	 * 
	 * @param phaseName
	 *            The <code>PhaseName</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setPhaseName(PhaseName phaseName);

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
	 * Returns the <code>Style</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Style</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Style getStyle();

	/**
	 * Sets the <code>Style</code> attribute.
	 * 
	 * @param style
	 *            The <code>Style</code> attribute. May be <code>null</code>.
	 */
	void setStyle(Style style);

	/**
	 * Returns the <code>Tool</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Tool</code> attribute. Might be
	 *         <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	com.sap.mlt.xliff12.api.attribute.Tool getTool();

	/**
	 * Sets the <code>Tool</code> attribute.
	 * 
	 * @param tool
	 *            The <code>Tool</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	void setTool(com.sap.mlt.xliff12.api.attribute.Tool tool);

	/**
	 * Returns the <code>ToolId</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ToolId</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ToolId getToolId();

	/**
	 * Sets the <code>ToolId</code> attribute.
	 * 
	 * @param toolId
	 *            The <code>ToolId</code> attribute. May be <code>null</code>.
	 */
	void setToolId(ToolId toolId);

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
	 * Returns the <code>XmlLang</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>XmlLang</code> attribute. Might be
	 *         <code>null</code> .
	 */
	XmlLang getXmlLang();

	/**
	 * Sets the <code>XmlLang</code> attribute.
	 * 
	 * @param xmlLang
	 *            The <code>XmlLang</code> attribute. May be <code>null</code>.
	 */
	void setXmlLang(XmlLang xmlLang);

	/**
	 * Returns the <code>XmlSpace</code> attribute.
	 * 
	 * @return Returns the <code>XmlSpace</code> attribute.
	 */
	XmlSpace getXmlSpace();

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
	 * Returns the <code>Source</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Source</code> element. Might be
	 *         <code>null</code>.
	 */
	Source getSource();

	/**
	 * Sets the <code>Source</code> element.
	 * 
	 * @param source
	 *            The <code>Source</code> element. May be <code>null</code>.
	 */
	void setSource(Source source);

	/**
	 * Returns the <code>SegSource</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>SegSource</code> element. Might be
	 *         <code>null</code> .
	 */
	SegSource getSegSource();

	/**
	 * Sets the <code>SegSource</code> element.
	 * 
	 * @param segSource
	 *            The <code>SegSource</code> element. May be <code>null</code>.
	 */
	void setSegSource(SegSource segSource);

	/**
	 * Returns the <code>Target</code> element.
	 * 
	 * @return Returns the <code>Target</code> element.
	 */
	Target getTarget();

	/**
	 * Returns a list of <code>Target</code> elements contained in this element.
	 * Contains at least one <code>Target</code> element.
	 * 
	 * @return Returns a list of <code>Target</code> elements contained in this
	 *         element. Contains at least one <code>Target</code> element.
	 * 
	 * @deprecated Multiple <code>Target</code> elements within a single
	 *             <code>AltTrans</code> are DEPRECATED in XLIFF 1.2.
	 */
	List<Target> getTargets();

	/**
	 * Sets the <code>Target</code> element.
	 * 
	 * @param target
	 *            The <code>Target</code> element. Must not be <code>null</code>
	 *            .
	 */
	void setTarget(Target target);

	/**
	 * Sets the <code>Target</code> elements contained in this element.
	 * 
	 * @param targets
	 *            List of <code>Target</code> elements. Must not be
	 *            <code>null</code> . Must contain at least one element.
	 * 
	 * @deprecated Multiple <code>Target</code> elements within a single
	 *             <code>AltTrans</code> are DEPRECATED in XLIFF 1.2.
	 */
	void setTargets(List<Target> targets);

	/**
	 * Returns a list of <code>Context</code> elements. This is any combination
	 * of {@link ContextGroup}, {@link Note} and
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup} elements.
	 * 
	 * @return Returns a list of <code>Context</code> elements. This is any
	 *         combination of {@link ContextGroup}, {@link Note} and
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup}
	 *         elements.
	 */
	List<? extends Context> getContext();

	/**
	 * Set a list of <code>Context</code> elements.
	 * 
	 * @param context
	 *            A list of <code>Context</code> elements. This is any
	 *            combination of {@link ContextGroup}, {@link Note} and
	 *            {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup}
	 *            elements. Must not be <code>null</code>.
	 */
	void setContext(List<? extends Context> context);

	/**
	 * Returns a list of non-XLIFF elements.
	 * 
	 * @return Returns a list of non-XLIFF elements.
	 */
	List<NonXliffElement> getNonXliffElements();

	/**
	 * Sets the list of non-XLIFF elements.
	 * 
	 * @param nonXliffElements
	 *            The list of non-XLIFF elements. Must not be <code>null</code>.
	 */
	void setNonXliffElements(List<NonXliffElement> nonXliffElements);

}
