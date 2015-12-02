package com.sap.mlt.xliff12.api.factory;

import java.util.Collection;
import java.util.Locale;

import org.w3c.dom.Attr;

import com.sap.mlt.xliff12.api.attribute.AltTransType;
import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.api.attribute.BuildNum;
import com.sap.mlt.xliff12.api.attribute.Category;
import com.sap.mlt.xliff12.api.attribute.CharClass;
import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.Comment;
import com.sap.mlt.xliff12.api.attribute.CompanyName;
import com.sap.mlt.xliff12.api.attribute.ContactEmail;
import com.sap.mlt.xliff12.api.attribute.ContactName;
import com.sap.mlt.xliff12.api.attribute.ContactPhone;
import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.api.attribute.ExType;
import com.sap.mlt.xliff12.api.attribute.ExtraData;
import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.api.attribute.Form;
import com.sap.mlt.xliff12.api.attribute.From;
import com.sap.mlt.xliff12.api.attribute.HelpId;
import com.sap.mlt.xliff12.api.attribute.Href;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.JobId;
import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.api.attribute.MatchQuality;
import com.sap.mlt.xliff12.api.attribute.MaxBytes;
import com.sap.mlt.xliff12.api.attribute.MaxHeight;
import com.sap.mlt.xliff12.api.attribute.MaxWidth;
import com.sap.mlt.xliff12.api.attribute.Menu;
import com.sap.mlt.xliff12.api.attribute.MenuName;
import com.sap.mlt.xliff12.api.attribute.MenuOption;
import com.sap.mlt.xliff12.api.attribute.MergedTrans;
import com.sap.mlt.xliff12.api.attribute.Mid;
import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.MinBytes;
import com.sap.mlt.xliff12.api.attribute.MinHeight;
import com.sap.mlt.xliff12.api.attribute.MinWidth;
import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Origin;
import com.sap.mlt.xliff12.api.attribute.Original;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.attribute.Priority;
import com.sap.mlt.xliff12.api.attribute.ProcessName;
import com.sap.mlt.xliff12.api.attribute.ProductName;
import com.sap.mlt.xliff12.api.attribute.ProductVersion;
import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.api.attribute.ToolCompany;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.api.attribute.ToolVersion;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.Uid;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.element.header.Tool;

/**
 * XLIFF attribute factory.
 * 
 * Use an instance of this factory to create XLIFF attributes.
 * 
 * @author D049314
 */
public interface AttributeFactory {

	/**
	 * Creates and returns an <code>AltTransType</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link AltTransType} attribute value
	 * @return Creates and returns an <code>AltTransType</code> attribute with the
	 *         passed pre-defined value.
	 */
	AltTransType createAltTransType(AltTransType.Value value);

	/**
	 * Creates and returns an <code>AltTransType</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link AltTransType} attribute value
	 * @return Creates and returns an <code>AltTransType</code> attribute with the
	 *         passed user-defined value.
	 */
	AltTransType createAltTransType(String xtendValue);

	/**
	 * Creates and returns an <code>Annotates</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The {@link Annotates} attribute value
	 * @return Creates and returns an <code>Annotates</code> attribute with the
	 *         passed value.
	 */
	Annotates createAnnotates(Annotates.Value value);

	/**
	 * Creates and returns an <code>Approved</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The {@link Approved} attribute value
	 * @return Creates and returns an <code>Approved</code> attribute with the passed
	 *         value.
	 */
	Approved createApproved(Approved.Value value);

	/**
	 * Creates and returns an <code>Assoc</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The {@link Assoc} attribute value
	 * @return Creates and returns an <code>Assoc</code> attribute with the passed
	 *         value.
	 */
	Assoc createAssoc(Assoc.Value value);

	/**
	 * Creates and returns a <code>BuildNum</code> attribute with the passed value.
	 * 
	 * @param buildNum
	 *            The build num
	 * @return Creates and returns a <code>BuildNum</code> attribute with the passed
	 *         value.
	 */
	BuildNum createBuildNum(String buildNum);

	/**
	 * Creates and returns a <code>Category</code> attribute with the passed value.
	 * 
	 * @param category
	 *            The category
	 * @return Creates and returns a <code>Category</code> attribute with the passed
	 *         value.
	 */
	Category createCategory(String category);

	/**
	 * Creates and returns a <code>CharClass</code> attribute with the passed value.
	 * 
	 * @param charClass
	 *            The char class
	 * @return Creates and returns a <code>CharClass</code> attribute with the passed
	 *         value.
	 */
	CharClass createCharClass(String charClass);

	/**
	 * Creates and returns a <code>Clone</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The clone value
	 * @return Creates and returns a <code>Clone</code> attribute with the passed
	 *         value.
	 */
	Clone createClone(Clone.Value value);

	/**
	 * Creates and returns a <code>Comment</code> attribute with the passed value.
	 * 
	 * @param comment
	 *            The comment
	 * @return Creates and returns a <code>Comment</code> attribute with the passed
	 *         value.
	 */
	Comment createComment(String comment);

	/**
	 * Creates and returns a <code>CompanyName</code> attribute with the passed
	 * value.
	 * 
	 * @param companyName
	 *            The company name
	 * @return Creates and returns a <code>CompanyName</code> attribute with the
	 *         passed value.
	 */
	CompanyName createCompanyName(String companyName);

	/**
	 * Creates and returns a <code>ContactEmail</code> attribute with the passed
	 * value.
	 * 
	 * @param contactEmail
	 *            The contact email
	 * @return Creates and returns a <code>ContactEmail</code> attribute with the
	 *         passed value.
	 */
	ContactEmail createContactEmail(String contactEmail);

	/**
	 * Creates and returns a <code>ContactName</code> attribute with the passed
	 * value.
	 * 
	 * @param contactName
	 *            The contact name
	 * @return Creates and returns a <code>ContactName</code> attribute with the
	 *         passed value.
	 */
	ContactName createContactName(String contactName);

	/**
	 * Creates and returns a <code>ContactPhone</code> attribute with the passed
	 * value.
	 * 
	 * @param contactPhone
	 *            The contact phone
	 * @return Creates and returns a <code>ContactPhone</code> attribute with the
	 *         passed value.
	 */
	ContactPhone createContactPhone(String contactPhone);

	/**
	 * Creates and returns a <code>ContextType</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link ContextType} value
	 * @return Creates and returns a <code>ContextType</code> attribute with the
	 *         passed pre-defined value.
	 */
	ContextType createContextType(ContextType.Value value);

	/**
	 * Creates and returns a <code>ContextType</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link ContextType} value
	 * @return Creates and returns a <code>ContextType</code> attribute with the
	 *         passed user-defined value.
	 */
	ContextType createContextType(String xtendValue);

	/**
	 * Creates and returns a <code>Coord</code> attribute with the passed
	 * coordinates.
	 * 
	 * @param x
	 *            The x coordinate. May be <code>null</code>.
	 * @param y
	 *            The x coordinate. May be <code>null</code>.
	 * @param cx
	 *            The width. May be <code>null</code>.
	 * @param cy
	 *            The height. May be <code>null</code>.
	 * @return Creates and returns a <code>Coord</code> attribute with the passed
	 *         coordinates.
	 */
	Coord createCoord(Integer x, Integer y, Integer cx, Integer cy);

	/**
	 * Creates and returns a <code>CountType</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link CountType} value
	 * @return Creates and returns a <code>CountType</code> attribute with the passed
	 *         pre-defined value.
	 */
	CountType createCountType(CountType.Value value);

	/**
	 * Creates and returns a <code>CountType</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link CountType} value
	 * @return Creates and returns a <code>CountType</code> attribute with the passed
	 *         user-defined value.
	 */
	CountType createCountType(String xtendValue);

	/**
	 * Creates and returns a <code>Crc</code> attribute with the passed value.
	 * 
	 * @param crc
	 *            The checksum
	 * @return Creates and returns a <code>Crc</code> attribute with the passed
	 *         value.
	 */
	Crc createCrc(String crc);

	/**
	 * Creates and returns a <code>CssStyle</code> attribute with the passed value.
	 * 
	 * @param cssStyle
	 *            The CSS style
	 * @return Creates and returns a <code>CssStyle</code> attribute with the passed
	 *         value.
	 */
	CssStyle createCssStyle(String cssStyle);

	/**
	 * Creates and returns a <code>CtypeDelim</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link CtypeDelim} value.
	 * @return Creates and returns a <code>CtypeDelim</code> attribute with the
	 *         passed pre-defined value.
	 */
	CtypeDelim createCtypeDelim(CtypeDelim.Value value);

	/**
	 * Creates and returns a <code>CtypeDelim</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link CtypeDelim} value.
	 * @return Creates and returns a <code>CtypeDelim</code> attribute with the
	 *         passed user-defined value.
	 */
	CtypeDelim createCtypeDelim(String xtendValue);

	/**
	 * Creates and returns a <code>CtypePh</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link CtypePh} value.
	 * @return Creates and returns a <code>CtypePh</code> attribute with the passed
	 *         pre-defined value.
	 */
	CtypePh createCtypePh(CtypePh.Value value);

	/**
	 * Creates and returns a <code>CtypePh</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link CtypePh} value.
	 * @return Creates and returns a <code>CtypePh</code> attribute with the passed
	 *         user-defined value.
	 */
	CtypePh createCtypePh(String xtendValue);

	/**
	 * Creates and returns a <code>DataType</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined {@link DataType} value
	 * @return Creates and returns a <code>DataType</code> attribute with the passed
	 *         pre-defined value.
	 */
	DataType createDataType(DataType.Value value);

	/**
	 * Creates and returns a <code>DataType</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined {@link DataType} value
	 * @return Creates and returns a <code>DataType</code> attribute with the passed
	 *         user-defined value.
	 */
	DataType createDataType(String xtendValue);

	/**
	 * Creates and returns a <code>Date</code> attribute with the passed value.
	 * 
	 * @param date
	 *            The date
	 * @return Creates and returns a <code>Date</code> attribute with the passed
	 *         value.
	 */
	Date createDate(java.util.Date date);

	/**
	 * Creates and returns an <code>EquivText</code> attribute with the passed value.
	 * 
	 * @param equivText
	 *            The equivalent text
	 * @return Creates and returns an <code>EquivText</code> attribute with the
	 *         passed value.
	 */
	EquivText createEquivText(String equivText);

	/**
	 * Creates and returns an <code>EquivTrans</code> attribute with the passed
	 * value.
	 * 
	 * @param value
	 *            The {@link EquivTrans} value
	 * @return Creates and returns an <code>EquivTrans</code> attribute with the
	 *         passed value.
	 */
	EquivTrans createEquivTrans(EquivTrans.Value value);

	/**
	 * Creates and returns and{@link ExtraData} attribute with the passed value.
	 * 
	 * @param extraData
	 *            The extra data
	 * @return Creates and returns an <code>ExtraData</code> attribute with the
	 *         passed value.
	 */
	ExtraData createExtraData(String extraData);

	/**
	 * Creates and returns an <code>ExStyle</code> attribute with the passed value.
	 * 
	 * @param exstyle
	 *            The extended style
	 * @return Creates and returns an <code>ExStyle</code> attribute with the passed
	 *         value.
	 */
	ExStyle createExStyle(String exstyle);

	/**
	 * Creates and returns an <code>ExType</code> attribute with the passed value.
	 * 
	 * @param extype
	 *            The extended type
	 * @return Creates and returns an <code>ExType</code> attribute with the passed
	 *         value.
	 */
	ExType createExType(String extype);

	/**
	 * Creates and returns a <code>Font</code> attribute with the passed value.
	 * 
	 * @param font
	 *            The font
	 * @return Creates and returns a <code>Font</code> attribute with the passed
	 *         value.
	 */
	Font createFont(String font);

	/**
	 * Creates and returns a <code>Form</code> attribute with the passed value.
	 * 
	 * @param form
	 *            The form
	 * @return Creates and returns a <code>Form</code> attribute with the passed
	 *         value.
	 */
	Form createForm(String form);

	/**
	 * Creates and returns a <code>From</code> attribute with the passed value.
	 * 
	 * @param from
	 *            The value identifying an author
	 * @return Creates and returns a <code>From</code> attribute with the passed
	 *         value.
	 */
	From createFrom(String from);

	/**
	 * Creates and returns a <code>HelpId</code> attribute with the passed value.
	 * 
	 * @param helpId
	 *            The help id
	 * @return Creates and returns a <code>HelpId</code> attribute with the passed
	 *         value.
	 */
	HelpId createHelpId(String helpId);

	/**
	 * Creates and returns a <code>Href</code> attribute with the passed value.
	 * 
	 * @param href
	 *            The hypertext reference
	 * @return Creates and returns a <code>Href</code> attribute with the passed
	 *         value.
	 */
	Href createHref(String href);

	/**
	 * Creates and returns an <code>Id</code> attribute with the passed value.
	 * 
	 * @param id
	 *            The id
	 * @return Creates and returns an <code>Id</code> attribute with the passed
	 *         value.
	 */
	Id createId(String id);

	/**
	 * Creates and returns a <code>JobId</code> attribute with the passed value.
	 * 
	 * @param jobId
	 *            The job id
	 * @return Creates and returns a <code>JobId</code> attribute with the passed
	 *         value.
	 */
	JobId createJobId(String jobId);

	/**
	 * Creates and returns a <code>MatchMandatory</code> attribute with the passed
	 * value.
	 * 
	 * @param value
	 *            The {@link MatchMandatory} value
	 * @return Creates and returns a <code>MatchMandatory</code> attribute with the
	 *         passed value.
	 */
	MatchMandatory createMatchMandatory(MatchMandatory.Value value);

	/**
	 * Creates and returns a <code>MatchQuality</code> attribute with he passed
	 * value.
	 * 
	 * @param matchQuality
	 *            The match quality
	 * @return Creates and returns a <code>MatchQuality</code> attribute with he
	 *         passed value.
	 */
	MatchQuality createMatchQuality(String matchQuality);

	/**
	 * Creates and returns a <code>MaxBytes</code> attribute with the passed value.
	 * 
	 * @param maxBytes
	 *            The maximum number of bytes
	 * @return Creates and returns a <code>MaxBytes</code> attribute with the passed
	 *         value.
	 */
	MaxBytes createMaxBytes(String maxBytes);

	/**
	 * Creates and returns a <code>MaxHeight</code> attribute with the passed value.
	 * 
	 * @param maxHeight
	 *            The maximal height
	 * @return Creates and returns a <code>MaxHeight</code> attribute with the passed
	 *         value.
	 */
	MaxHeight createMaxHeight(String maxHeight);

	/**
	 * Creates and returns a <code>MaxWidth</code> attribute with the passed value.
	 * 
	 * @param maxWidth
	 *            The maximal width
	 * @return Creates and returns a <code>MaxWidth</code> attribute with the passed
	 *         value.
	 */
	MaxWidth createMaxWidth(String maxWidth);

	/**
	 * Creates and returns a <code>Menu</code> attribute with the passed value.
	 * 
	 * @param menu
	 *            The menu
	 * @return Creates and returns a <code>Menu</code> attribute with the passed
	 *         value.
	 */
	Menu createMenu(String menu);

	/**
	 * Creates and returns a <code>MenuName</code> attribute with the passed value.
	 * 
	 * @param menuName
	 *            The menu name
	 * @return Creates and returns a <code>MenuName</code> attribute with the passed
	 *         value.
	 */
	MenuName createMenuName(String menuName);

	/**
	 * Creates and returns a <code>MenuOption</code> attribute with the passed value.
	 * 
	 * @param menuOption
	 *            The menu option
	 * @return Creates and returns a <code>MenuOption</code> attribute with the
	 *         passed value.
	 */
	MenuOption createMenuOption(String menuOption);

	/**
	 * Creates and returns a <code>MergedTrans</code> attribute with the passed
	 * value.
	 * 
	 * @param value
	 *            The {@link MergedTrans} value
	 * @return Creates and returns a <code>MergedTrans</code> attribute with the
	 *         passed value.
	 */
	MergedTrans createMergedTrans(MergedTrans.Value value);

	/**
	 * Creates and returns a <code>Mid</code> attribute with the passed value.
	 * 
	 * @param mid
	 *            The marker id
	 * @return Creates and returns a <code>Mid</code> attribute with the passed
	 *         value.
	 */
	Mid createMid(String mid);

	/**
	 * Creates and returns a <code>MimeType</code> attribute with the passed value.
	 * 
	 * @param mimeType
	 *            The mime type
	 * @return Creates and returns a <code>MimeType</code> attribute with the passed
	 *         value.
	 */
	MimeType createMimeType(String mimeType);

	/**
	 * Creates and returns a <code>MinBytes</code> attribute with the passed value.
	 * 
	 * @param minBytes
	 *            The minimum number of bytes
	 * @return Creates and returns a <code>MinBytes</code> attribute with the passed
	 *         value.
	 */
	MinBytes createMinBytes(String minBytes);

	/**
	 * Creates and returns a <code>MinHeight</code> attribute with the passed value.
	 * 
	 * @param minHeight
	 *            The minimal height
	 * @return Creates and returns a <code>MinHeight</code> attribute with the passed
	 *         value.
	 */
	MinHeight createMinHeight(String minHeight);

	/**
	 * Creates and returns a <code>MinWidth</code> attribute with the passed value.
	 * 
	 * @param minWidth
	 *            The minimal width
	 * @return Creates and returns a <code>MinWidth</code> attribute with the passed
	 *         value.
	 */
	MinWidth createMinWidth(String minWidth);

	/**
	 * Creates and returns a <code>Mtype</code> attribute with the passed pre-defined
	 * value.
	 * 
	 * @param value
	 *            The pre-defined marker type
	 * @return Creates and returns a <code>Mtype</code> attribute with the passed
	 *         pre-defined value.
	 */
	Mtype createMtype(Mtype.Value value);

	/**
	 * Creates and returns a <code>Mtype</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined marker type
	 * @return Creates and returns a <code>Mtype</code> attribute with the passed
	 *         user-defined value.
	 */
	Mtype createMtype(String xtendValue);

	/**
	 * Creates and returns a <code>Name</code> attribute with the passed value.
	 * 
	 * @param name
	 *            The name of the named group
	 * @return Creates and returns a <code>Name</code> attribute with the passed
	 *         value.
	 */
	Name createName(String name);

	/**
	 * Creates and returns an <code>Origin</code> attribute with the passed value.
	 * 
	 * @param origin
	 *            The origin
	 * @return Creates and returns an <code>Origin</code> attribute with the passed
	 *         value.
	 */
	Origin createOrigin(String origin);

	/**
	 * Creates and returns an <code>Original</code> attribute with the passed value.
	 * 
	 * @param original
	 *            The original
	 * @return Creates and returns an <code>Original</code> attribute with the passed
	 *         value.
	 */
	Original createOriginal(String original);

	/**
	 * Creates and returns a <code>PhaseName</code> attribute with the passed value.
	 * 
	 * @param phaseName
	 *            The phase name
	 * @return Creates and returns a <code>PhaseName</code> attribute with the passed
	 *         value.
	 */
	PhaseName createPhaseName(String phaseName);

	/**
	 * Creates and returns a <code>Pos</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The position
	 * @return Creates and returns a <code>Pos</code> attribute with the passed
	 *         value.
	 */
	Pos createPos(Pos.Value value);

	/**
	 * Creates and returns a <code>Priority</code> attribute with the passed value.
	 * 
	 * @param priority
	 *            The priority from 1 (highest priority) to 10 (lowest priority)
	 * @return Creates and returns a <code>Priority</code> attribute with the passed
	 *         value.
	 */
	Priority createPriority(int priority);

	/**
	 * Creates and returns a <code>ProcessName</code> attribute with the passed
	 * value.
	 * 
	 * @param processName
	 *            The process name
	 * @return Creates and returns a <code>ProcessName</code> attribute with the
	 *         passed value.
	 */
	ProcessName createProcessName(String processName);

	/**
	 * Creates and returns a <code>ProductName</code> attribute with the passed
	 * value.
	 * 
	 * @param productName
	 *            The product name
	 * @return Creates and returns a <code>ProductName</code> attribute with the
	 *         passed value.
	 */
	ProductName createProductName(String productName);

	/**
	 * Creates and returns a <code>ProductVersion</code> attribute with the passed
	 * value.
	 * 
	 * @param productVersion
	 *            The product version
	 * @return Creates and returns a <code>ProductVersion</code> attribute with the
	 *         passed value.
	 */
	ProductVersion createProductVersion(String productVersion);

	/**
	 * Creates and returns a {@link com.sap.mlt.xliff12.api.attribute.PropType}
	 * attribute with the passed value.
	 * 
	 * @param propType
	 *            The property type
	 * @return Creates and returns a
	 *         {@link com.sap.mlt.xliff12.api.attribute.PropType} attribute with
	 *         the passed value.
	 * @deprecated Because the
	 *             {@link com.sap.mlt.xliff12.api.element.namedgroup.Prop}
	 *             element was DEPRECATED in version 1.1 and this attribute is
	 *             only a member of that element, this attribute is also
	 *             deprecated. Instead, use attributes defined in a namespace
	 *             different from XLIFF. See the Extensibility section for more
	 *             information.
	 */
	com.sap.mlt.xliff12.api.attribute.PropType createPropType(String propType);

	/**
	 * Creates and returns a <code>Purpose</code> attribute with the passed values.
	 * At least one value must be specified.
	 * 
	 * @param values
	 *            Any number of pre-defined {@link Purpose} values.
	 * @param xtendValues
	 *            Any number of user-defined {@link Purpose} values.
	 * @return Creates and returns a <code>Purpose</code> attribute with the passed
	 *         values.
	 */
	Purpose createPurpose(Collection<Purpose.Value> values,
			Collection<String> xtendValues);

	/**
	 * Creates and returns a <code>Reformat</code> attribute with the passed value.
	 * At least one value must be specifed.
	 * 
	 * @param values
	 *            Any number of pre-defined {@link Reformat} values.
	 * @param xtendValues
	 *            Any number of user-defined {@link Reformat} values.
	 * @return Creates and returns a <code>Reformat</code> attribute with the passed
	 *         value.
	 */
	Reformat createReformat(Collection<Reformat.Value> values,
			Collection<String> xtendValues);

	/**
	 * Returns a {@link Reformat} attribute that forbids reformatting of any
	 * property.
	 * 
	 * @return Returns a {@link Reformat} attribute that forbids reformatting of
	 *         any property.
	 */
	Reformat createReformatNo();

	/**
	 * Returns a {@link Reformat} attribute that allows reformatting of all
	 * properties.
	 * 
	 * @return Returns a {@link Reformat} attribute that allows reformatting of
	 *         all properties.
	 */
	Reformat createReformatYes();

	/**
	 * Creates and returns a <code>ResName</code> attribute with the passed value.
	 * 
	 * @param resName
	 *            The resource name
	 * @return Creates and returns a <code>ResName</code> attribute with the passed
	 *         value.
	 */
	ResName createResName(String resName);

	/**
	 * Creates and returns a <code>ResType</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined resource type
	 * @return Creates and returns a <code>ResType</code> attribute with the passed
	 *         pre-defined value.
	 */
	ResType createResType(ResType.Value value);

	/**
	 * Creates and returns a <code>ResType</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined resource type
	 * @return Creates and returns a <code>ResType</code> attribute with the passed
	 *         user-defined value.
	 */
	ResType createResType(String xtendValue);

	/**
	 * Creates and returns a <code>Rid</code> attribute with the passed value.
	 * 
	 * @param rid
	 *            The reference identifier
	 * @return Creates and returns a <code>Rid</code> attribute with the passed
	 *         value.
	 */
	Rid createRid(String rid);

	/**
	 * Creates and returns a <code>SizeUnit</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined size unit
	 * @return Creates and returns a <code>SizeUnit</code> attribute with the passed
	 *         pre-defined value.
	 */
	SizeUnit createSizeUnit(SizeUnit.Value value);

	/**
	 * Creates and returns a <code>SizeUnit</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined size unit
	 * @return Creates and returns a <code>SizeUnit</code> attribute with the passed
	 *         user-defined value.
	 */
	SizeUnit createSizeUnit(String xtendValue);

	/**
	 * Creates and returns a <code>SourceLanguage</code> attribute with the passed
	 * language code that must conform to RFC4646.
	 * 
	 * @param language
	 *            The language code conforming to RFC4646
	 * @return Creates and returns a <code>SourceLanguage</code> attribute with the
	 *         passed language code that must conform to RFC4646.
	 */
	SourceLanguage createSourceLanguage(String language);

	/**
	 * Creates and returns a <code>SourceLanguage</code> attribute with the passed
	 * locale.
	 * 
	 * @param language
	 *            The locale
	 * @return Creates and returns a <code>SourceLanguage</code> attribute with the
	 *         passed locale.
	 */
	SourceLanguage createSourceLanguage(Locale language);

	/**
	 * Creates and returns a <code>State</code> attribute with the passed pre-defined
	 * value.
	 * 
	 * @param value
	 *            The pre-defined state
	 * @return Creates and returns a <code>State</code> attribute with the passed
	 *         pre-defined value.
	 */
	State createState(State.Value value);

	/**
	 * Creates and returns a <code>State</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined state
	 * @return Creates and returns a <code>State</code> attribute with the passed
	 *         user-defined value.
	 */
	State createState(String xtendValue);

	/**
	 * Creates and returns a <code>StateQualifier</code> attribute with the passed
	 * pre-defined value.
	 * 
	 * @param value
	 *            The pre-defined state qualifier
	 * @return Creates and returns a <code>StateQualifier</code> attribute with the
	 *         passed pre-defined value.
	 */
	StateQualifier createStateQualifier(StateQualifier.Value value);

	/**
	 * Creates and returns a <code>StateQualifier</code> attribute with the passed
	 * user-defined value.
	 * 
	 * @param xtendValue
	 *            The user-defined state qualifier
	 * @return Creates and returns a <code>StateQualifier</code> attribute with the
	 *         passed user-defined value.
	 */
	StateQualifier createStateQualifier(String xtendValue);

	/**
	 * Creates and returns a <code>Style</code> attribute with the passed value.
	 * 
	 * @param style
	 *            The resource style of a control
	 * @return Creates and returns a <code>Style</code> attribute with the passed
	 *         value.
	 */
	Style createStyle(String style);

	/**
	 * Creates and returns a <code>TargetLanguage</code> attribute with the passed
	 * language code that must conform to RFC4646.
	 * 
	 * @param language
	 *            A language code conforming to RFC4646
	 * @return Creates and returns a <code>TargetLanguage</code> attribute with the
	 *         passed language code that must conform to RFC4646.
	 */
	TargetLanguage createTargetLanguage(String language);

	/**
	 * Creates and returns a <code>TargetLanguage</code> attribute with the passed
	 * locale.
	 * 
	 * @param language
	 *            A locale
	 * @return Creates and returns a <code>TargetLanguage</code> attribute with the
	 *         passed locale.
	 */
	TargetLanguage createTargetLanguage(Locale language);

	/**
	 * Creates and returns a {@link com.sap.mlt.xliff12.api.attribute.Tool}
	 * attribute with the passed value.
	 * 
	 * @param tool
	 *            The tool
	 * @return Creates and returns a
	 *         {@link com.sap.mlt.xliff12.api.attribute.Tool} attribute with the
	 *         passed value.
	 * 
	 * @deprecated The tool attribute was DEPRECATED in version 1.1. Instead,
	 *             use the {@link Tool} element and a {@link ToolId} attribute
	 */
	com.sap.mlt.xliff12.api.attribute.Tool createTool(String tool);

	/**
	 * Creates and returns a <code>ToolCompany</code> attribute with the passed
	 * value.
	 * 
	 * @param toolCompany
	 *            The tool company
	 * @return Creates and returns a <code>ToolCompany</code> attribute with the
	 *         passed value.
	 */
	ToolCompany createToolCompany(String toolCompany);

	/**
	 * Creates and returns a <code>ToolId</code> attribute with the passed value.
	 * 
	 * @param toolId
	 *            The tool id
	 * @return Creates and returns a <code>ToolId</code> attribute with the passed
	 *         value.
	 */
	ToolId createToolId(String toolId);

	/**
	 * Creates and returns a <code>ToolName</code> attribute with the passed value.
	 * 
	 * @param toolName
	 *            The tool name
	 * @return Creates and returns a <code>ToolName</code> attribute with the passed
	 *         value.
	 */
	ToolName createToolName(String toolName);

	/**
	 * Creates and returns a <code>ToolVersion</code> attribute with the passed
	 * value.
	 * 
	 * @param toolVersion
	 *            The tool version
	 * @return Creates and returns a <code>ToolVersion</code> attribute with the
	 *         passed value.
	 */
	ToolVersion createToolVersion(String toolVersion);

	/**
	 * Creates and returns a <code>Translate</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The attribute value
	 * @return Creates and return a {@link Translate} attribute with the passed
	 *         value.
	 */
	Translate createTranslate(Translate.Value value);

	/**
	 * Creates and returns a {@link com.sap.mlt.xliff12.api.attribute.Ts}
	 * attribute with the passed value.
	 * 
	 * @param ts
	 *            Tool specific data
	 * @return Creates and returns a
	 *         {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute with the
	 *         passed value.
	 * 
	 * @deprecated The {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute
	 *             was DEPRECATED in version 1.1. Instead, use attributes
	 *             defined in a namespace different from XLIFF.
	 */
	com.sap.mlt.xliff12.api.attribute.Ts createTs(String ts);

	/**
	 * Creates and returns a <code>Uid</code> attribute with the passed value.
	 * 
	 * @param uid
	 *            The unique id
	 * @return Creates and returns a <code>Uid</code> attribute with the passed
	 *         value.
	 */
	Uid createUid(String uid);

	/**
	 * Creates and returns a <code>Unit</code> attribute with the passed pre-defined
	 * value.
	 * 
	 * @param value
	 *            The pre-defined value
	 * @return Creates and returns a <code>Unit</code> attribute with the passed
	 *         pre-defined value.
	 */
	Unit createUnit(Unit.Value value);

	/**
	 * Creates and returns a <code>Unit</code> attribute with the passed user-defined
	 * value.
	 * 
	 * @param xtendValue
	 *            The user-defined value
	 * @return Creates and returns a <code>Unit</code> attribute with the passed
	 *         user-defined value.
	 */
	Unit createUnit(String xtendValue);

	/**
	 * Creates and returns a <code>Version</code> attribute with the passed value.
	 * 
	 * @param version
	 *            The XLIFF version
	 * @return Creates and returns a <code>Version</code> attribute with the passed
	 *         value.
	 */
	Version createVersion(Version.Value version);

	/**
	 * Creates and returns a <code>Xid</code> attribute with the passed value.
	 * 
	 * @param xid
	 *            The extern reference identifier
	 * @return Creates and returns a <code>Xid</code> attribute with the passed
	 *         value.
	 */
	Xid createXid(String xid);

	/**
	 * Creates and returns an <code>XmlLang</code> attribute with the passed language
	 * that must conform to RFC4646.
	 * 
	 * @param language
	 *            The language conforming to RFC4646.
	 * @return Creates and returns an <code>XmlLang</code> attribute with the passed
	 *         language that must conform to RFC4646.
	 */
	XmlLang createXmlLang(String language);

	/**
	 * Creates and returns an <code>XmlLang</code> attribute that corresponds to the
	 * passed locale.
	 * 
	 * @param language
	 *            The language
	 * @return Creates and returns an <code>XmlLang</code> attribute that corresponds
	 *         to the passed locale.
	 */
	XmlLang createXmlLang(Locale language);

	/**
	 * Creates and returns an <code>XmlSpace</code> attribute with the passed value.
	 * 
	 * @param value
	 *            The XML space value
	 * @return Creates and returns an <code>XmlSpace</code> attribute with the passed
	 *         value.
	 */
	XmlSpace createXmlSpace(XmlSpace.Value value);

	/**
	 * Creates and returns a non-XLIFF attribute.
	 * 
	 * @param namespaceUri
	 *            The attribute's namespace URI
	 * @param localName
	 *            The attribute's local name
	 * @param value
	 *            The attribute's value
	 * @return Creates and returns a non-XLIFF attribute.
	 */
	NonXliffAttribute createNonXliffAttribute(String namespaceUri,
			String localName, String value);

	/**
	 * Creates and returns a non-XLIFF attribute.
	 * 
	 * @param namespaceUri
	 *            The attribute's namespace URI
	 * @param prefix
	 *            The XML prefix
	 * @param localName
	 *            The attribute's local name
	 * @param value
	 *            The attribute's value
	 * @return Creates and returns a non-XLIFF attribute.
	 */
	NonXliffAttribute createNonXliffAttribute(String namespaceUri,
			String prefix, String localName, String value);

	/**
	 * Creates and returns an attribute that can be used with this API and that
	 * corresponds to the passed attribute from the org.w3c.dom package.
	 * 
	 * @param attr
	 *            An attribute
	 * @return Creates and returns an attribute that can be used with this API
	 *         and that corresponds to the passed attribute from the org.w3c.dom
	 *         package.
	 */
	Attribute createAttribute(Attr attr);
}
