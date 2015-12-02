package com.sap.mlt.xliff12.impl.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.attribute.AltTransType;
import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.api.attribute.MergedTrans;
import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.attribute.Purpose;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
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
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class AttributeFactoryImplTest {

	private static final String XML_NAMESPACE = "http://www.w3.org/XML/1998/namespace";

	@Test
	public void testFactoryMethods() {

		AttributeFactoryImpl factory = AttributeFactoryImpl.getInstance();

		Document doc = Utils.createDocument();
		Attr attr;
		Attribute xliffAttr;

		// alttranstype
		attr = doc.createAttributeNS(null, "alttranstype");
		attr.setValue("accepted");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new AltTransTypeImpl(AltTransType.Value.ACCEPTED),
				xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new AltTransTypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// annotates
		attr = doc.createAttributeNS(null, "annotates");
		attr.setValue("source");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new AnnotatesImpl(Annotates.Value.SOURCE), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// approved
		attr = doc.createAttributeNS(null, "approved");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ApprovedImpl(Approved.Value.YES), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// assoc
		attr = doc.createAttributeNS(null, "assoc");
		attr.setValue("following");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new AssocImpl(Assoc.Value.FOLLOWING), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// build-num
		attr = doc.createAttributeNS(null, "build-num");
		attr.setValue("123");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new BuildNumImpl("123"), xliffAttr);

		// category
		attr = doc.createAttributeNS(null, "category");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CategoryImpl("abc"), xliffAttr);

		// charclass
		attr = doc.createAttributeNS(null, "charclass");
		attr.setValue("ascii");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CharClassImpl("ascii"), xliffAttr);

		// clone
		attr = doc.createAttributeNS(null, "clone");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CloneImpl(Clone.Value.YES), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// comment
		attr = doc.createAttributeNS(null, "comment");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CommentImpl("abc"), xliffAttr);

		// company-name
		attr = doc.createAttributeNS(null, "company-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CompanyNameImpl("abc"), xliffAttr);

		// contact-email
		attr = doc.createAttributeNS(null, "contact-email");
		attr.setValue("abc@xyz.com");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ContactEmailImpl("abc@xyz.com"), xliffAttr);

		// contact-name
		attr = doc.createAttributeNS(null, "contact-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ContactNameImpl("abc"), xliffAttr);

		// contact-phone
		attr = doc.createAttributeNS(null, "contact-phone");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ContactPhoneImpl("abc"), xliffAttr);

		// context-type
		attr = doc.createAttributeNS(null, "context-type");
		attr.setValue("numparams");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ContextTypeImpl(ContextType.Value.NUMPARAMS),
				xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ContextTypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// coord
		attr = doc.createAttributeNS(null, "coord");
		attr.setValue("0;0;#;#");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CoordImpl(0, 0, null, null), xliffAttr);
		try {
			attr.setValue("1;2;3");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			attr.setValue("1;2;abc;6");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// count-type
		attr = doc.createAttributeNS(null, "count-type");
		attr.setValue("total");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CountTypeImpl(CountType.Value.TOTAL), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CountTypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// crc
		attr = doc.createAttributeNS(null, "crc");
		attr.setValue("123");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CrcImpl("123"), xliffAttr);

		// css-style
		attr = doc.createAttributeNS(null, "css-style");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CssStyleImpl("abc"), xliffAttr);

		// ctype
		attr = doc.createAttributeNS(null, "ctype");
		attr.setValue("lb");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CtypePhImpl(CtypePh.Value.LB), xliffAttr);
		attr.setValue("bold");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CtypeDelimImpl(CtypeDelim.Value.BOLD), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new CtypeDelimImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// datatype
		attr = doc.createAttributeNS(null, "datatype");
		attr.setValue("csv");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new DataTypeImpl(DataType.Value.CSV), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new DataTypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// date
		GregorianCalendar calendar = new GregorianCalendar(TimeZone
				.getTimeZone("GMT"));
		calendar.set(2010, 5, 4, 23, 12, 34);
		attr = doc.createAttributeNS(null, "date");
		attr.setValue("2010-06-04T23:12:34Z");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new DateImpl(calendar.getTime()), xliffAttr);

		// equiv-text
		attr = doc.createAttributeNS(null, "equiv-text");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new EquivTextImpl("abc"), xliffAttr);

		// equiv-trans
		attr = doc.createAttributeNS(null, "equiv-trans");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new EquivTransImpl(EquivTrans.Value.YES), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// exstyle
		attr = doc.createAttributeNS(null, "exstyle");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ExStyleImpl("abc"), xliffAttr);

		// extradata
		attr = doc.createAttributeNS(null, "extradata");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ExtraDataImpl("abc"), xliffAttr);

		// extype
		attr = doc.createAttributeNS(null, "extype");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ExTypeImpl("abc"), xliffAttr);

		// font
		attr = doc.createAttributeNS(null, "font");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new FontImpl("abc"), xliffAttr);

		// form
		attr = doc.createAttributeNS(null, "form");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new FormImpl("abc"), xliffAttr);

		// from
		attr = doc.createAttributeNS(null, "from");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new FromImpl("abc"), xliffAttr);

		// help-id
		attr = doc.createAttributeNS(null, "help-id");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new HelpIdImpl("abc"), xliffAttr);

		// href
		attr = doc.createAttributeNS(null, "href");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new HrefImpl("abc"), xliffAttr);

		// id
		attr = doc.createAttributeNS(null, "id");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new IdImpl("abc"), xliffAttr);

		// job-id
		attr = doc.createAttributeNS(null, "job-id");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new JobIdImpl("abc"), xliffAttr);

		// match-mandatory
		attr = doc.createAttributeNS(null, "match-mandatory");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MatchMandatoryImpl(MatchMandatory.Value.YES),
				xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// match-quality
		attr = doc.createAttributeNS(null, "match-quality");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MatchQualityImpl("abc"), xliffAttr);

		// maxbytes
		attr = doc.createAttributeNS(null, "maxbytes");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MaxBytesImpl("abc"), xliffAttr);

		// maxheight
		attr = doc.createAttributeNS(null, "maxheight");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MaxHeightImpl("abc"), xliffAttr);

		// maxwidth
		attr = doc.createAttributeNS(null, "maxwidth");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MaxWidthImpl("abc"), xliffAttr);

		// menu
		attr = doc.createAttributeNS(null, "menu");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MenuImpl("abc"), xliffAttr);

		// menu-name
		attr = doc.createAttributeNS(null, "menu-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MenuNameImpl("abc"), xliffAttr);

		// menu-option
		attr = doc.createAttributeNS(null, "menu-option");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MenuOptionImpl("abc"), xliffAttr);

		// mid
		attr = doc.createAttributeNS(null, "mid");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MidImpl("abc"), xliffAttr);

		// merged-trans
		attr = doc.createAttributeNS(null, "merged-trans");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MergedTransImpl(MergedTrans.Value.YES), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// mime-type
		attr = doc.createAttributeNS(null, "mime-type");
		attr.setValue("text/plain");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MimeTypeImpl("text/plain"), xliffAttr);

		// minbytes
		attr = doc.createAttributeNS(null, "minbytes");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MinBytesImpl("abc"), xliffAttr);

		// minheight
		attr = doc.createAttributeNS(null, "minheight");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MinHeightImpl("abc"), xliffAttr);

		// minwidth
		attr = doc.createAttributeNS(null, "minwidth");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MinWidthImpl("abc"), xliffAttr);

		// mtype
		attr = doc.createAttributeNS(null, "mtype");
		attr.setValue("equation");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MtypeImpl(Mtype.Value.EQUATION), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new MtypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// name
		attr = doc.createAttributeNS(null, "name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new NameImpl("abc"), xliffAttr);

		// origin
		attr = doc.createAttributeNS(null, "origin");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new OriginImpl("abc"), xliffAttr);

		// original
		attr = doc.createAttributeNS(null, "original");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new OriginalImpl("abc"), xliffAttr);

		// phase-name
		attr = doc.createAttributeNS(null, "phase-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new PhaseNameImpl("abc"), xliffAttr);

		// pos
		attr = doc.createAttributeNS(null, "pos");
		attr.setValue("close");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new PosImpl(Pos.Value.CLOSE), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// priority
		attr = doc.createAttributeNS(null, "priority");
		attr.setValue("4");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new PriorityImpl(4), xliffAttr);
		try {
			attr.setValue("-4");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// process-name
		attr = doc.createAttributeNS(null, "process-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ProcessNameImpl("abc"), xliffAttr);

		// product-name
		attr = doc.createAttributeNS(null, "product-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ProductNameImpl("abc"), xliffAttr);

		// product-version
		attr = doc.createAttributeNS(null, "product-version");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ProductVersionImpl("abc"), xliffAttr);

		// prop-type
		attr = doc.createAttributeNS(null, "prop-type");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new PropTypeImpl("abc"), xliffAttr);

		// purpose
		attr = doc.createAttributeNS(null, "purpose");
		attr.setValue("location x-xyz  information x-abc");
		xliffAttr = factory.createAttribute(attr);
		ArrayList<Purpose.Value> purposeValues = new ArrayList<Purpose.Value>();
		ArrayList<String> purposeXtends = new ArrayList<String>();
		purposeValues.add(Purpose.Value.LOCATION);
		purposeValues.add(Purpose.Value.INFORMATION);
		purposeXtends.add("xyz");
		purposeXtends.add("abc");
		assertEquals(new PurposeImpl(purposeValues, purposeXtends), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// reformat
		attr = doc.createAttributeNS(null, "reformat");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ReformatYesNoImpl(true), xliffAttr);
		attr.setValue("no");
		xliffAttr = factory.createAttribute(attr);
		attr.setValue("font x-xyz  style x-abc");
		ArrayList<Reformat.Value> reformatValues = new ArrayList<Reformat.Value>();
		ArrayList<String> reformatXtends = new ArrayList<String>();
		reformatValues.add(Reformat.Value.FONT);
		reformatValues.add(Reformat.Value.STYLE);
		reformatXtends.add("xyz");
		reformatXtends.add("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ReformatImpl(reformatValues, reformatXtends),
				xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// resname
		attr = doc.createAttributeNS(null, "resname");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ResNameImpl("abc"), xliffAttr);

		// restype
		attr = doc.createAttributeNS(null, "restype");
		attr.setValue("label");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ResTypeImpl(ResType.Value.LABEL), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ResTypeImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// rid
		attr = doc.createAttributeNS(null, "rid");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new RidImpl("abc"), xliffAttr);

		// size-unit
		attr = doc.createAttributeNS(null, "size-unit");
		attr.setValue("em");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new SizeUnitImpl(SizeUnit.Value.EM), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new SizeUnitImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// source-language
		attr = doc.createAttributeNS(null, "source-language");
		attr.setValue("de-AT");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new SourceLanguageImpl("de-AT"), xliffAttr);

		// state
		attr = doc.createAttributeNS(null, "state");
		attr.setValue("signed-off");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new StateImpl(State.Value.SIGNED_OFF), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new StateImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// state-qualifier
		attr = doc.createAttributeNS(null, "state-qualifier");
		attr.setValue("leveraged-tm");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new StateQualifierImpl(StateQualifier.Value.LEVERAGED_TM),
				xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new StateQualifierImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// style
		attr = doc.createAttributeNS(null, "style");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new StyleImpl("abc"), xliffAttr);

		// target-language
		attr = doc.createAttributeNS(null, "target-language");
		attr.setValue("de-AT");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new TargetLanguageImpl("de-AT"), xliffAttr);

		// tool
		attr = doc.createAttributeNS(null, "tool");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ToolImpl("abc"), xliffAttr);

		// tool-company
		attr = doc.createAttributeNS(null, "tool-company");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ToolCompanyImpl("abc"), xliffAttr);

		// tool-id
		attr = doc.createAttributeNS(null, "tool-id");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ToolIdImpl("abc"), xliffAttr);

		// tool-name
		attr = doc.createAttributeNS(null, "tool-name");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ToolNameImpl("abc"), xliffAttr);

		// tool-version
		attr = doc.createAttributeNS(null, "tool-version");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new ToolVersionImpl("abc"), xliffAttr);

		// translate
		attr = doc.createAttributeNS(null, "translate");
		attr.setValue("yes");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new TranslateImpl(Translate.Value.YES), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// ts
		attr = doc.createAttributeNS(null, "ts");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new TsImpl("abc"), xliffAttr);

		// uid
		attr = doc.createAttributeNS(null, "uid");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new UidImpl("abc"), xliffAttr);

		// unit
		attr = doc.createAttributeNS(null, "unit");
		attr.setValue("line");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new UnitImpl(Unit.Value.LINE), xliffAttr);
		attr.setValue("x-xtended");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new UnitImpl("xtended"), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// version
		attr = doc.createAttributeNS(null, "version");
		attr.setValue("1.1");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new VersionImpl(Version.Value.V1_1), xliffAttr);
		try {
			attr.setValue("invalid");
			xliffAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// xid
		attr = doc.createAttributeNS(null, "xid");
		attr.setValue("abc");
		xliffAttr = factory.createAttribute(attr);
		assertEquals(new XidImpl("abc"), xliffAttr);

		// invalid attribute
		attr = doc.createAttributeNS(null, "invalid");
		attr.setValue("invalid");
		try {
			factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		Attribute xmlAttr;

		// xml:space
		attr = doc.createAttributeNS(XML_NAMESPACE, "xml:space");
		attr.setValue("preserve");
		xmlAttr = factory.createAttribute(attr);
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.PRESERVE), xmlAttr);
		try {
			attr.setValue("invalid");
			xmlAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// xml:lang
		attr = doc.createAttributeNS(XML_NAMESPACE, "xml:lang");
		attr.setValue("ja-JP");
		xmlAttr = factory.createAttribute(attr);
		assertEquals(new XmlLangImpl("ja-JP"), xmlAttr);
		try {
			attr.setValue("invalid");
			xmlAttr = factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// invalid attribute
		attr = doc.createAttributeNS(XML_NAMESPACE, "invalid");
		attr.setValue("invalid");
		try {
			factory.createAttribute(attr);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

		// non-XLIFF-attribute
		attr = doc.createAttributeNS("ns", "pre:name");
		attr.setValue("value");
		factory.createAttribute(attr);
		Attribute nxa = factory.createAttribute(attr);
		assertEquals(new NonXliffAttributeImpl("ns", "pre", "name", "value"),
				nxa);

		assertEquals(new NonXliffAttributeImpl("ns", null, "name", "value"),
				factory.createNonXliffAttribute("ns", "name", "value"));
		
		// CtypePh attribute
		CtypePh ctypePh = factory.createCtypePh("xtend");
		assertEquals(new CtypePhImpl("xtend"), ctypePh);
		
		// Language/locale tests
		SourceLanguage sl = factory.createSourceLanguage(Locale.US);
		assertEquals(new SourceLanguageImpl(Locale.US), sl);
		TargetLanguage tl = factory.createTargetLanguage(Locale.US);
		assertEquals(new TargetLanguageImpl(Locale.US), tl);
		XmlLang xl = factory.createXmlLang(Locale.US);
		assertEquals(new XmlLangImpl(Locale.US), xl);
	}

}
