package com.sap.mlt.xliff12.impl.factory;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

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
import com.sap.mlt.xliff12.api.attribute.PropType;
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
import com.sap.mlt.xliff12.api.attribute.Tool;
import com.sap.mlt.xliff12.api.attribute.ToolCompany;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.api.attribute.ToolVersion;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.Uid;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.base.XmlAttribute;
import com.sap.mlt.xliff12.api.factory.AttributeFactory;
import com.sap.mlt.xliff12.impl.attribute.AltTransTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.AnnotatesImpl;
import com.sap.mlt.xliff12.impl.attribute.ApprovedImpl;
import com.sap.mlt.xliff12.impl.attribute.AssocImpl;
import com.sap.mlt.xliff12.impl.attribute.BuildNumImpl;
import com.sap.mlt.xliff12.impl.attribute.CategoryImpl;
import com.sap.mlt.xliff12.impl.attribute.CharClassImpl;
import com.sap.mlt.xliff12.impl.attribute.CloneImpl;
import com.sap.mlt.xliff12.impl.attribute.CommentImpl;
import com.sap.mlt.xliff12.impl.attribute.CompanyNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactEmailImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ContactPhoneImpl;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CoordImpl;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.CssStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypeDelimImpl;
import com.sap.mlt.xliff12.impl.attribute.CtypePhImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.DateImpl;
import com.sap.mlt.xliff12.impl.attribute.EquivTextImpl;
import com.sap.mlt.xliff12.impl.attribute.EquivTransImpl;
import com.sap.mlt.xliff12.impl.attribute.ExStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.ExTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ExtraDataImpl;
import com.sap.mlt.xliff12.impl.attribute.FontImpl;
import com.sap.mlt.xliff12.impl.attribute.FormImpl;
import com.sap.mlt.xliff12.impl.attribute.FromImpl;
import com.sap.mlt.xliff12.impl.attribute.HelpIdImpl;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.JobIdImpl;
import com.sap.mlt.xliff12.impl.attribute.MatchMandatoryImpl;
import com.sap.mlt.xliff12.impl.attribute.MatchQualityImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuNameImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuOptionImpl;
import com.sap.mlt.xliff12.impl.attribute.MergedTransImpl;
import com.sap.mlt.xliff12.impl.attribute.MidImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.MinBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MinHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MinWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.MtypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginalImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PosImpl;
import com.sap.mlt.xliff12.impl.attribute.PriorityImpl;
import com.sap.mlt.xliff12.impl.attribute.ProcessNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProductNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProductVersionImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.PurposeImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.RidImpl;
import com.sap.mlt.xliff12.impl.attribute.SizeUnitImpl;
import com.sap.mlt.xliff12.impl.attribute.SourceLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.StateImpl;
import com.sap.mlt.xliff12.impl.attribute.StateQualifierImpl;
import com.sap.mlt.xliff12.impl.attribute.StyleImpl;
import com.sap.mlt.xliff12.impl.attribute.TargetLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolCompanyImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolVersionImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.UidImpl;
import com.sap.mlt.xliff12.impl.attribute.UnitImpl;
import com.sap.mlt.xliff12.impl.attribute.VersionImpl;
import com.sap.mlt.xliff12.impl.attribute.XidImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.DateTime;

@SuppressWarnings("deprecation")
public final class AttributeFactoryImpl implements AttributeFactory {

	private static final AttributeFactoryImpl INSTANCE = new AttributeFactoryImpl();

	public static AttributeFactoryImpl getInstance() {
		return INSTANCE;
	}

	private AttributeFactoryImpl() {
	}

	public AltTransType createAltTransType(AltTransType.Value value) {
		return new AltTransTypeImpl(value);
	}

	public AltTransType createAltTransType(String xtendValue) {
		return new AltTransTypeImpl(xtendValue);
	}

	public Annotates createAnnotates(Annotates.Value value) {
		return new AnnotatesImpl(value);
	}

	public Approved createApproved(Approved.Value value) {
		return new ApprovedImpl(value);
	}

	public Assoc createAssoc(Assoc.Value value) {
		return new AssocImpl(value);
	}

	public BuildNum createBuildNum(String buildNum) {
		return new BuildNumImpl(buildNum);
	}

	public Category createCategory(String category) {
		return new CategoryImpl(category);
	}

	public CharClass createCharClass(String charClass) {
		return new CharClassImpl(charClass);
	}

	public Clone createClone(Clone.Value value) {
		return new CloneImpl(value);
	}

	public Comment createComment(String comment) {
		return new CommentImpl(comment);
	}

	public CompanyName createCompanyName(String companyName) {
		return new CompanyNameImpl(companyName);
	}

	public ContactEmail createContactEmail(String contactEmail) {
		return new ContactEmailImpl(contactEmail);
	}

	public ContactName createContactName(String contactName) {
		return new ContactNameImpl(contactName);
	}

	public ContactPhone createContactPhone(String contactPhone) {
		return new ContactPhoneImpl(contactPhone);
	}

	public ContextType createContextType(ContextType.Value value) {
		return new ContextTypeImpl(value);
	}

	public ContextType createContextType(String xtendValue) {
		return new ContextTypeImpl(xtendValue);
	}

	public Coord createCoord(Integer x, Integer y, Integer cx, Integer cy) {
		return new CoordImpl(x, y, cx, cy);
	}

	public CountType createCountType(CountType.Value value) {
		return new CountTypeImpl(value);
	}

	public CountType createCountType(String xtendValue) {
		return new CountTypeImpl(xtendValue);
	}

	public Crc createCrc(String crc) {
		return new CrcImpl(crc);
	}

	public CssStyle createCssStyle(String cssStyle) {
		return new CssStyleImpl(cssStyle);
	}

	public CtypeDelim createCtypeDelim(CtypeDelim.Value value) {
		return new CtypeDelimImpl(value);
	}

	public CtypeDelim createCtypeDelim(String xtendValue) {
		return new CtypeDelimImpl(xtendValue);
	}

	public CtypePh createCtypePh(CtypePh.Value value) {
		return new CtypePhImpl(value);
	}

	public CtypePh createCtypePh(String xtendValue) {
		return new CtypePhImpl(xtendValue);
	}

	public DataType createDataType(DataType.Value value) {
		return new DataTypeImpl(value);
	}

	public DataType createDataType(String xtendValue) {
		return new DataTypeImpl(xtendValue);
	}

	public Date createDate(java.util.Date date) {
		return new DateImpl(date);
	}

	public EquivText createEquivText(String equivText) {
		return new EquivTextImpl(equivText);
	}

	public EquivTrans createEquivTrans(EquivTrans.Value value) {
		return new EquivTransImpl(value);
	}

	public ExtraData createExtraData(String extraData) {
		return new ExtraDataImpl(extraData);
	}

	public ExStyle createExStyle(String exstyle) {
		return new ExStyleImpl(exstyle);
	}

	public ExType createExType(String extype) {
		return new ExTypeImpl(extype);
	}

	public Font createFont(String font) {
		return new FontImpl(font);
	}

	public Form createForm(String form) {
		return new FormImpl(form);
	}

	public From createFrom(String from) {
		return new FromImpl(from);
	}

	public HelpId createHelpId(String helpId) {
		return new HelpIdImpl(helpId);
	}

	public Href createHref(String href) {
		return new HrefImpl(href);
	}

	public Id createId(String id) {
		return new IdImpl(id);
	}

	public JobId createJobId(String jobId) {
		return new JobIdImpl(jobId);
	}

	public MatchMandatory createMatchMandatory(MatchMandatory.Value value) {
		return new MatchMandatoryImpl(value);
	}

	public MatchQuality createMatchQuality(String matchQuality) {
		return new MatchQualityImpl(matchQuality);
	}

	public MaxBytes createMaxBytes(String maxBytes) {
		return new MaxBytesImpl(maxBytes);
	}

	public MaxHeight createMaxHeight(String maxHeight) {
		return new MaxHeightImpl(maxHeight);
	}

	public MaxWidth createMaxWidth(String maxWidth) {
		return new MaxWidthImpl(maxWidth);
	}

	public Menu createMenu(String menu) {
		return new MenuImpl(menu);
	}

	public MenuName createMenuName(String menuName) {
		return new MenuNameImpl(menuName);
	}

	public MenuOption createMenuOption(String menuOption) {
		return new MenuOptionImpl(menuOption);
	}

	public Mid createMid(String mid) {
		return new MidImpl(mid);
	}

	public MergedTrans createMergedTrans(MergedTrans.Value value) {
		return new MergedTransImpl(value);
	}

	public MimeType createMimeType(String mimeType) {
		return new MimeTypeImpl(mimeType);
	}

	public MinBytes createMinBytes(String minBytes) {
		return new MinBytesImpl(minBytes);
	}

	public MinHeight createMinHeight(String minHeight) {
		return new MinHeightImpl(minHeight);
	}

	public MinWidth createMinWidth(String minWidth) {
		return new MinWidthImpl(minWidth);
	}

	public Mtype createMtype(Mtype.Value value) {
		return new MtypeImpl(value);
	}

	public Mtype createMtype(String xtendValue) {
		return new MtypeImpl(xtendValue);
	}

	public Name createName(String name) {
		return new NameImpl(name);
	}

	public Origin createOrigin(String origin) {
		return new OriginImpl(origin);
	}

	public Original createOriginal(String original) {
		return new OriginalImpl(original);
	}

	public PhaseName createPhaseName(String phaseName) {
		return new PhaseNameImpl(phaseName);
	}

	public Pos createPos(Pos.Value value) {
		return new PosImpl(value);
	}

	public Priority createPriority(int priority) {
		return new PriorityImpl(priority);
	}

	public ProcessName createProcessName(String processName) {
		return new ProcessNameImpl(processName);
	}

	public ProductName createProductName(String productName) {
		return new ProductNameImpl(productName);
	}

	public ProductVersion createProductVersion(String productVersion) {
		return new ProductVersionImpl(productVersion);
	}

	/**
	 * @deprecated
	 */
	public PropType createPropType(String propType) {
		return new PropTypeImpl(propType);
	}

	public Purpose createPurpose(Collection<Purpose.Value> values,
			Collection<String> xtendValues) {
		return new PurposeImpl(values, xtendValues);
	}

	public Reformat createReformat(Collection<Reformat.Value> values,
			Collection<String> xtendValues) {
		return new ReformatImpl(values, xtendValues);
	}

	public Reformat createReformatNo() {
		return new ReformatYesNoImpl(false);
	}

	public Reformat createReformatYes() {
		return new ReformatYesNoImpl(true);
	}

	public ResName createResName(String resName) {
		return new ResNameImpl(resName);
	}

	public ResType createResType(ResType.Value value) {
		return new ResTypeImpl(value);
	}

	public ResType createResType(String xtendValue) {
		return new ResTypeImpl(xtendValue);
	}

	public Rid createRid(String rid) {
		return new RidImpl(rid);
	}

	public SizeUnit createSizeUnit(SizeUnit.Value value) {
		return new SizeUnitImpl(value);
	}

	public SizeUnit createSizeUnit(String xtendValue) {
		return new SizeUnitImpl(xtendValue);
	}

	public SourceLanguage createSourceLanguage(String language) {
		return new SourceLanguageImpl(language);
	}

	public SourceLanguage createSourceLanguage(Locale language) {
		return new SourceLanguageImpl(language);
	}

	public State createState(State.Value value) {
		return new StateImpl(value);
	}

	public State createState(String xtendValue) {
		return new StateImpl(xtendValue);
	}

	public StateQualifier createStateQualifier(StateQualifier.Value value) {
		return new StateQualifierImpl(value);
	}

	public StateQualifier createStateQualifier(String xtendValue) {
		return new StateQualifierImpl(xtendValue);
	}

	public Style createStyle(String style) {
		return new StyleImpl(style);
	}

	public TargetLanguage createTargetLanguage(String language) {
		return new TargetLanguageImpl(language);
	}

	public TargetLanguage createTargetLanguage(Locale language) {
		return new TargetLanguageImpl(language);
	}

	/**
	 * @deprecated
	 */
	public Tool createTool(String tool) {
		return new ToolImpl(tool);
	}

	public ToolCompany createToolCompany(String toolCompany) {
		return new ToolCompanyImpl(toolCompany);
	}

	public ToolId createToolId(String toolId) {
		return new ToolIdImpl(toolId);
	}

	public ToolName createToolName(String toolName) {
		return new ToolNameImpl(toolName);
	}

	public ToolVersion createToolVersion(String toolVersion) {
		return new ToolVersionImpl(toolVersion);
	}

	public Translate createTranslate(Translate.Value value) {
		return new TranslateImpl(value);
	}

	/**
	 * @deprecated
	 */
	public Ts createTs(String ts) {
		return new TsImpl(ts);
	}

	public Uid createUid(String uid) {
		return new UidImpl(uid);
	}

	public Unit createUnit(Unit.Value value) {
		return new UnitImpl(value);
	}

	public Unit createUnit(String xtendValue) {
		return new UnitImpl(xtendValue);
	}

	public Version createVersion(Version.Value value) {
		return new VersionImpl(value);
	}

	public Xid createXid(String xid) {
		return new XidImpl(xid);
	}

	public XmlLang createXmlLang(String language) {
		return new XmlLangImpl(language);
	}

	public XmlLang createXmlLang(Locale language) {
		return new XmlLangImpl(language);
	}

	public XmlSpace createXmlSpace(XmlSpace.Value value) {
		return new XmlSpaceImpl(value);
	}

	public NonXliffAttribute createNonXliffAttribute(String namespaceUri,
			String name, String value) {
		return new NonXliffAttributeImpl(namespaceUri, "", name, value);
	}

	public NonXliffAttribute createNonXliffAttribute(String namespaceUri,
			String prefix, String name, String value) {
		return new NonXliffAttributeImpl(namespaceUri, prefix, name, value);
	}

	public Attribute createAttribute(Attr attr) {
		String namespaceUri = attr.getNamespaceURI();
		if (namespaceUri == null) {
			Element owner = attr.getOwnerElement();
			if (owner != null) {
				namespaceUri = owner.getNamespaceURI();
			}
		}

		if ((namespaceUri == null)
				|| Schemas.XLIFF_12_NAMESPACE.equals(namespaceUri)) {
			return createXliffAttribute(attr);
		} else if (Schemas.XML_NAMESPACE.equals(namespaceUri)) {
			return createXmlAttribute(attr);
		} else {
			return createNonXliffAttribute(namespaceUri, attr.getPrefix(), attr
					.getLocalName(), attr.getValue());
		}
	}

	private XliffAttribute createXliffAttribute(Attr attr) {
		String name = attr.getLocalName();
		String value = attr.getValue();
		String xtend = null;
		if (value.startsWith("x-") && (value.length() > 2)) {
			xtend = value.substring(2);
		}

		if (AltTransType.NAME.equals(name)) {
			return createAltTransTypeFromValue(value, xtend);
		} else if (Annotates.NAME.equals(name)) {
			return createAnnotatesFromValue(value);
		} else if (Approved.NAME.equals(name)) {
			return createApprovedFromValue(value);
		} else if (Assoc.NAME.equals(name)) {
			return createAssocFromValue(value);
		} else if (BuildNum.NAME.equals(name)) {
			return createBuildNum(value);
		} else if (Category.NAME.equals(name)) {
			return createCategory(value);
		} else if (CharClass.NAME.equals(name)) {
			return createCharClass(value);
		} else if (Clone.NAME.equals(name)) {
			return createCloneFromValue(value);
		} else if (Comment.NAME.equals(name)) {
			return createComment(value);
		} else if (CompanyName.NAME.equals(name)) {
			return createCompanyName(value);
		} else if (ContactEmail.NAME.equals(name)) {
			return createContactEmail(value);
		} else if (ContactName.NAME.equals(name)) {
			return createContactName(value);
		} else if (ContactPhone.NAME.equals(name)) {
			return createContactPhone(value);
		} else if (ContextType.NAME.equals(name)) {
			return createContextTypeFromValue(value, xtend);
		} else if (Coord.NAME.equals(name)) {
			return createCoordFromValue(value);
		} else if (CountType.NAME.equals(name)) {
			return createCountTypeFromValue(value, xtend);
		} else if (Crc.NAME.equals(name)) {
			return createCrc(value);
		} else if (CssStyle.NAME.equals(name)) {
			return createCssStyle(value);
		} else if (CtypeDelim.NAME.equals(name)) {
			return createCtypeFromValue(value, xtend);
		} else if (DataType.NAME.equals(name)) {
			return createDataTypeFromValue(value, xtend);
		} else if (Date.NAME.equals(name)) {
			return createDateFromValue(value);
		} else if (EquivText.NAME.equals(name)) {
			return createEquivText(value);
		} else if (EquivTrans.NAME.equals(name)) {
			return createEquivTransFromValue(value);
		} else if (ExStyle.NAME.equals(name)) {
			return createExStyle(value);
		} else if (ExtraData.NAME.equals(name)) {
			return createExtraData(value);
		} else if (ExType.NAME.equals(name)) {
			return createExType(value);
		} else if (Font.NAME.equals(name)) {
			return createFont(value);
		} else if (Form.NAME.equals(name)) {
			return createForm(value);
		} else if (From.NAME.equals(name)) {
			return createFrom(value);
		} else if (HelpId.NAME.equals(name)) {
			return createHelpId(value);
		} else if (Href.NAME.equals(name)) {
			return createHref(value);
		} else if (Id.NAME.equals(name)) {
			return createId(value);
		} else if (JobId.NAME.equals(name)) {
			return createJobId(value);
		} else if (MatchMandatory.NAME.equals(name)) {
			return createMatchMandatoryFromValue(value);
		} else if (MatchQuality.NAME.equals(name)) {
			return createMatchQuality(value);
		} else if (MaxBytes.NAME.equals(name)) {
			return createMaxBytes(value);
		} else if (MaxHeight.NAME.equals(name)) {
			return createMaxHeight(value);
		} else if (MaxWidth.NAME.equals(name)) {
			return createMaxWidth(value);
		} else if (Menu.NAME.equals(name)) {
			return createMenu(value);
		} else if (MenuName.NAME.equals(name)) {
			return createMenuName(value);
		} else if (MenuOption.NAME.equals(name)) {
			return createMenuOption(value);
		} else if (MergedTrans.NAME.equals(name)) {
			return createMergedTransFromValue(value);
		} else if (Mid.NAME.equals(name)) {
			return createMid(value);
		} else if (MimeType.NAME.equals(name)) {
			return createMimeType(value);
		} else if (MinBytes.NAME.equals(name)) {
			return createMinBytes(value);
		} else if (MinHeight.NAME.equals(name)) {
			return createMinHeight(value);
		} else if (MinWidth.NAME.equals(name)) {
			return createMinWidth(value);
		} else if (Mtype.NAME.equals(name)) {
			return createMtypeFromValue(value, xtend);
		} else if (Name.NAME.equals(name)) {
			return createName(value);
		} else if (Origin.NAME.equals(name)) {
			return createOrigin(value);
		} else if (Original.NAME.equals(name)) {
			return createOriginal(value);
		} else if (PhaseName.NAME.equals(name)) {
			return createPhaseName(value);
		} else if (Pos.NAME.equals(name)) {
			return createPosFromValue(value);
		} else if (Priority.NAME.equals(name)) {
			return createPriorityFromValue(value);
		} else if (ProcessName.NAME.equals(name)) {
			return createProcessName(value);
		} else if (ProductName.NAME.equals(name)) {
			return createProductName(value);
		} else if (ProductVersion.NAME.equals(name)) {
			return createProductVersion(value);
		} else if (PropType.NAME.equals(name)) {
			return createPropType(value);
		} else if (Purpose.NAME.equals(name)) {
			return createPurposeFromValue(value);
		} else if (Reformat.NAME.equals(name)) {
			return createReformatFromValue(value);
		} else if (ResName.NAME.equals(name)) {
			return createResName(value);
		} else if (ResType.NAME.equals(name)) {
			return createResTypeFromValue(value, xtend);
		} else if (Rid.NAME.equals(name)) {
			return createRid(value);
		} else if (SizeUnit.NAME.equals(name)) {
			return createSizeUnitFromValue(value, xtend);
		} else if (SourceLanguage.NAME.equals(name)) {
			return createSourceLanguage(value);
		} else if (State.NAME.equals(name)) {
			return createStateFromValue(value, xtend);
		} else if (StateQualifier.NAME.equals(name)) {
			return createStateQualifierFromValue(value, xtend);
		} else if (Style.NAME.equals(name)) {
			return createStyle(value);
		} else if (TargetLanguage.NAME.equals(name)) {
			return createTargetLanguage(value);
		} else if (Tool.NAME.equals(name)) {
			return createTool(value);
		} else if (ToolCompany.NAME.equals(name)) {
			return createToolCompany(value);
		} else if (ToolId.NAME.equals(name)) {
			return createToolId(value);
		} else if (ToolName.NAME.equals(name)) {
			return createToolName(value);
		} else if (ToolVersion.NAME.equals(name)) {
			return createToolVersion(value);
		} else if (Translate.NAME.equals(name)) {
			return createTranslateFromValue(value);
		} else if (Ts.NAME.equals(name)) {
			return createTs(value);
		} else if (Uid.NAME.equals(name)) {
			return createUid(value);
		} else if (Unit.NAME.equals(name)) {
			return createUnitFromValue(value, xtend);
		} else if (Version.NAME.equals(name)) {
			return createVersionFromValue(value);
		} else if (Xid.NAME.equals(name)) {
			return createXid(value);
		}
		String msg = MessageFormat
				.format(
						"''{0}'' is not a valid attribute of the XLIFF namespace",
						name);
		throw new IllegalArgumentException(msg);
	}

	private AltTransType createAltTransTypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createAltTransType(xtend);
		}
		for (AltTransType.Value v : AltTransType.Value.values()) {
			if (v.toString().equals(value)) {
				return createAltTransType(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value,
				AltTransType.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Annotates createAnnotatesFromValue(String value) {
		for (Annotates.Value v : Annotates.Value.values()) {
			if (v.toString().equals(value)) {
				return createAnnotates(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Annotates.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Approved createApprovedFromValue(String value) {
		for (Approved.Value v : Approved.Value.values()) {
			if (v.toString().equals(value)) {
				return createApproved(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Approved.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Assoc createAssocFromValue(String value) {
		for (Assoc.Value v : Assoc.Value.values()) {
			if (v.toString().equals(value)) {
				return createAssoc(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Assoc.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Clone createCloneFromValue(String value) {
		for (Clone.Value v : Clone.Value.values()) {
			if (v.toString().equals(value)) {
				return createClone(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Clone.NAME);
		throw new IllegalArgumentException(msg);
	}

	private ContextType createContextTypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createContextType(xtend);
		}
		for (ContextType.Value v : ContextType.Value.values()) {
			if (v.toString().equals(value)) {
				return createContextType(v);
			}
		}
		String msg = MessageFormat
				.format("''{0}'' is not a valid ''{1}'' value", value,
						ContextType.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Coord createCoordFromValue(String value) {
		String[] comps = value.split(";");
		if (comps.length != 4) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid ''{1}'' value", value, Coord.NAME);
			throw new IllegalArgumentException(msg);
		}

		Integer[] ints = new Integer[4];
		for (int i = 0; i < 4; ++i) {
			String comp = comps[i];
			if ("#".equals(comp)) {
				ints[i] = null;
			} else {
				try {
					ints[i] = new Integer(comp);
				} catch (NumberFormatException e) {
					//$JL-EXC$
					String msg = MessageFormat.format(
							"''{0}'' is not a valid ''{1}'' value", value,
							Coord.NAME);
					throw new IllegalArgumentException(msg, e);
				}
			}
		}
		return createCoord(ints[0], ints[1], ints[2], ints[3]);
	}

	private CountType createCountTypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createCountType(xtend);
		}
		for (CountType.Value v : CountType.Value.values()) {
			if (v.toString().equals(value)) {
				return createCountType(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, CountType.NAME);
		throw new IllegalArgumentException(msg);
	}
	
	private XliffAttribute createCtypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createCtypeDelim(xtend);
		}
		for (CtypeDelim.Value v : CtypeDelim.Value.values()) {
			if (v.toString().equals(value)) {
				return createCtypeDelim(v);
			}
		}
		for (CtypePh.Value v : CtypePh.Value.values()) {
			if (v.toString().equals(value)) {
				return createCtypePh(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, CtypeDelim.NAME);
		throw new IllegalArgumentException(msg);
	}

	private DataType createDataTypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createDataType(xtend);
		}
		for (DataType.Value v : DataType.Value.values()) {
			if (v.toString().equals(value)) {
				return createDataType(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, DataType.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Date createDateFromValue(String value) {
		java.util.Date date = DateTime.parseDate(value);
		return createDate(date);
	}

	private EquivTrans createEquivTransFromValue(String value) {
		for (EquivTrans.Value v : EquivTrans.Value.values()) {
			if (v.toString().equals(value)) {
				return createEquivTrans(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, EquivTrans.NAME);
		throw new IllegalArgumentException(msg);
	}

	private MatchMandatory createMatchMandatoryFromValue(String value) {
		for (MatchMandatory.Value v : MatchMandatory.Value.values()) {
			if (v.toString().equals(value)) {
				return createMatchMandatory(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value,
				MatchMandatory.NAME);
		throw new IllegalArgumentException(msg);
	}

	private MergedTrans createMergedTransFromValue(String value) {
		for (MergedTrans.Value v : MergedTrans.Value.values()) {
			if (v.toString().equals(value)) {
				return createMergedTrans(v);
			}
		}
		String msg = MessageFormat
				.format("''{0}'' is not a valid ''{1}'' value", value,
						MergedTrans.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Mtype createMtypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createMtype(xtend);
		}
		for (Mtype.Value v : Mtype.Value.values()) {
			if (v.toString().equals(value)) {
				return createMtype(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Mtype.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Pos createPosFromValue(String value) {
		for (Pos.Value v : Pos.Value.values()) {
			if (v.toString().equals(value)) {
				return createPos(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Pos.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Priority createPriorityFromValue(String value) {
		try {
			int priority = Integer.parseInt(value);
			if ((priority < 1) || (priority > 10)) {
				String msg = MessageFormat.format(
						"''{0}'' is not a valid ''{1}'' value", value,
						Priority.NAME);
				throw new IllegalArgumentException(msg);
			}
			return createPriority(priority);
		} catch (NumberFormatException e) {
			//$JL-EXC$
			String msg = MessageFormat.format(
					"''{0}'' is not a valid ''{1}'' value", value,
					Priority.NAME);
			throw new IllegalArgumentException(msg, e);
		}
	}

	private Purpose createPurposeFromValue(String value) {
		String[] entries = value.split(" ");
		ArrayList<Purpose.Value> values = new ArrayList<Purpose.Value>();
		ArrayList<String> xtendValues = new ArrayList<String>();
		for (String entry : entries) {
			entry = entry.trim();
			if (entry.length() == 0) {
				continue;
			}
			if ((entry.length() > 2) && entry.startsWith("x-")) {
				xtendValues.add(entry.substring(2));
			} else {
				Purpose.Value purpose = null;
				for (Purpose.Value v : Purpose.Value.values()) {
					if (v.toString().equals(entry)) {
						purpose = v;
						break;
					}
				}
				if (purpose == null) {
					String msg = MessageFormat.format(
							"''{0}'' is not a valid ''{1}'' value", entry,
							Purpose.NAME);
					throw new IllegalArgumentException(msg);
				}
				values.add(purpose);
			}
		}
		return createPurpose(values, xtendValues);
	}

	private Reformat createReformatFromValue(String value) {
		if ("yes".equals(value)) {
			return createReformatYes();
		}
		if ("no".equals(value)) {
			return createReformatNo();
		}

		String[] entries = value.split(" ");
		ArrayList<Reformat.Value> values = new ArrayList<Reformat.Value>();
		ArrayList<String> xtendValues = new ArrayList<String>();
		for (String entry : entries) {
			entry = entry.trim();
			if (entry.length() == 0) {
				continue;
			}
			if ((entry.length() > 2) && entry.startsWith("x-")) {
				xtendValues.add(entry.substring(2));
			} else {
				Reformat.Value reformat = null;
				for (Reformat.Value v : Reformat.Value.values()) {
					if (v.toString().equals(entry)) {
						reformat = v;
						break;
					}
				}
				if (reformat == null) {
					String msg = MessageFormat.format(
							"''{0}'' is not a valid ''{1}'' value", entry,
							Reformat.NAME);
					throw new IllegalArgumentException(msg);
				}
				values.add(reformat);
			}
		}
		return createReformat(values, xtendValues);
	}

	private ResType createResTypeFromValue(String value, String xtend) {
		if (xtend != null) {
			return createResType(xtend);
		}
		for (ResType.Value v : ResType.Value.values()) {
			if (v.toString().equals(value)) {
				return createResType(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, ResType.NAME);
		throw new IllegalArgumentException(msg);
	}

	private SizeUnit createSizeUnitFromValue(String value, String xtend) {
		if (xtend != null) {
			return createSizeUnit(xtend);
		}
		for (SizeUnit.Value v : SizeUnit.Value.values()) {
			if (v.toString().equals(value)) {
				return createSizeUnit(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, SizeUnit.NAME);
		throw new IllegalArgumentException(msg);
	}

	private State createStateFromValue(String value, String xtend) {
		if (xtend != null) {
			return createState(xtend);
		}
		for (State.Value v : State.Value.values()) {
			if (v.toString().equals(value)) {
				return createState(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, State.NAME);
		throw new IllegalArgumentException(msg);
	}

	private StateQualifier createStateQualifierFromValue(String value,
			String xtend) {
		if (xtend != null) {
			return createStateQualifier(xtend);
		}
		for (StateQualifier.Value v : StateQualifier.Value.values()) {
			if (v.toString().equals(value)) {
				return createStateQualifier(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value,
				StateQualifier.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Translate createTranslateFromValue(String value) {
		for (Translate.Value v : Translate.Value.values()) {
			if (v.toString().equals(value)) {
				return createTranslate(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Translate.NAME);
		throw new IllegalArgumentException(msg);
	}

	private Unit createUnitFromValue(String value, String xtend) {
		if (xtend != null) {
			return createUnit(xtend);
		}
		for (Unit.Value v : Unit.Value.values()) {
			if (v.toString().equals(value)) {
				return createUnit(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Unit.NAME);
		throw new IllegalArgumentException(msg);
	}

	private XliffAttribute createVersionFromValue(String value) {
		for (Version.Value v : Version.Value.values()) {
			if (v.toString().equals(value)) {
				return createVersion(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid ''{1}'' value", value, Version.NAME);
		throw new IllegalArgumentException(msg);
	}

	private XmlAttribute createXmlAttribute(Attr attr) {
		String name = attr.getLocalName();
		String value = attr.getValue();
		if (XmlSpace.NAME.equals(name)) {
			return createXmlSpaceFromValue(value);
		} else if (XmlLang.NAME.equals(name)) {
			return createXmlLang(value);
		} else {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid attribute of the XML namespace",
					name);
			throw new IllegalArgumentException(msg);
		}
	}

	private XmlSpace createXmlSpaceFromValue(String value) {
		for (XmlSpace.Value v : XmlSpace.Value.values()) {
			if (v.toString().equals(value)) {
				return createXmlSpace(v);
			}
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid xml:space value", value);
		throw new IllegalArgumentException(msg);
	}
}
