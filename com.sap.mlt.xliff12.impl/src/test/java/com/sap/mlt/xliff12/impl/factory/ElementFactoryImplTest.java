package com.sap.mlt.xliff12.impl.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.Glossary;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.element.header.PhaseGroup;
import com.sap.mlt.xliff12.api.element.header.Reference;
import com.sap.mlt.xliff12.api.element.header.Skl;
import com.sap.mlt.xliff12.api.element.header.Tool;
import com.sap.mlt.xliff12.api.element.inline.Bpt;
import com.sap.mlt.xliff12.api.element.inline.Bx;
import com.sap.mlt.xliff12.api.element.inline.Ept;
import com.sap.mlt.xliff12.api.element.inline.Ex;
import com.sap.mlt.xliff12.api.element.inline.G;
import com.sap.mlt.xliff12.api.element.inline.It;
import com.sap.mlt.xliff12.api.element.inline.Ph;
import com.sap.mlt.xliff12.api.element.inline.Sub;
import com.sap.mlt.xliff12.api.element.inline.X;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.BinSource;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Body;
import com.sap.mlt.xliff12.api.element.structural.Group;
import com.sap.mlt.xliff12.api.element.structural.SegSource;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.element.toplevel.File;
import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.MtypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginalImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PosImpl;
import com.sap.mlt.xliff12.impl.attribute.ProcessNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.SourceLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolNameImpl;
import com.sap.mlt.xliff12.impl.attribute.VersionImpl;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.GlossaryImpl;
import com.sap.mlt.xliff12.impl.element.header.HeaderImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.header.PhaseGroupImpl;
import com.sap.mlt.xliff12.impl.element.header.PhaseImpl;
import com.sap.mlt.xliff12.impl.element.header.ReferenceImpl;
import com.sap.mlt.xliff12.impl.element.header.SklImpl;
import com.sap.mlt.xliff12.impl.element.header.ToolImpl;
import com.sap.mlt.xliff12.impl.element.inline.BptImpl;
import com.sap.mlt.xliff12.impl.element.inline.BxImpl;
import com.sap.mlt.xliff12.impl.element.inline.EptImpl;
import com.sap.mlt.xliff12.impl.element.inline.ExImpl;
import com.sap.mlt.xliff12.impl.element.inline.GImpl;
import com.sap.mlt.xliff12.impl.element.inline.ItImpl;
import com.sap.mlt.xliff12.impl.element.inline.PhImpl;
import com.sap.mlt.xliff12.impl.element.inline.SubImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.element.structural.AltTransImpl;
import com.sap.mlt.xliff12.impl.element.structural.BinSourceImpl;
import com.sap.mlt.xliff12.impl.element.structural.BinTargetImpl;
import com.sap.mlt.xliff12.impl.element.structural.BinUnitImpl;
import com.sap.mlt.xliff12.impl.element.structural.BodyImpl;
import com.sap.mlt.xliff12.impl.element.structural.GroupImpl;
import com.sap.mlt.xliff12.impl.element.structural.SegSourceImpl;
import com.sap.mlt.xliff12.impl.element.structural.SourceImpl;
import com.sap.mlt.xliff12.impl.element.structural.TargetImpl;
import com.sap.mlt.xliff12.impl.element.structural.TransUnitImpl;
import com.sap.mlt.xliff12.impl.element.toplevel.FileImpl;
import com.sap.mlt.xliff12.impl.element.toplevel.XliffImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class ElementFactoryImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testCreateXliffVersionListOfFile() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Xliff xliff = factory.createXliff(new VersionImpl(Version.Value.V1_2),
				createDefaultFiles());
		assertEquals(new XliffImpl(new VersionImpl(Version.Value.V1_2),
				createDefaultFiles()), xliff);
	}

	@Test
	public void testCreateXliffVersionFile() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Xliff xliff = factory.createXliff(new VersionImpl(Version.Value.V1_2),
				createDefaultFile());
		assertEquals(new XliffImpl(new VersionImpl(Version.Value.V1_2),
				createDefaultFiles()), xliff);
	}

	@Test
	public void testCreateFile() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		File file = factory.createFile(new OriginalImpl("abc"),
				new SourceLanguageImpl("en-us"), new DataTypeImpl("xyz"),
				createDefaultBody());
		assertEquals(new FileImpl(new OriginalImpl("abc"),
				new SourceLanguageImpl("en-us"), new DataTypeImpl("xyz"),
				createDefaultBody()), file);
	}

	@Test
	public void testCreateHeader() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Header header = factory.createHeader();
		assertEquals(new HeaderImpl(), header);
	}

	@Test
	public void testCreateSkl() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Skl skl = factory.createSkl(createDefaultInternalFile());
		assertEquals(new SklImpl(createDefaultInternalFile()), skl);
	}

	@Test
	public void testCreateInternalFile() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		InternalFile internalFile = factory.createInternalFile(new TextImpl(
				"text"));
		assertEquals(new InternalFileImpl(new TextImpl("text")), internalFile);
	}

	@Test
	public void testCreateExternalFile() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		ExternalFile externalFile = factory.createExternalFile(new HrefImpl(
				"http://sap.com"));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://sap.com")),
				externalFile);
	}

	@Test
	public void testCreateGlossary() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Glossary glossary = factory.createGlossary(createDefaultInternalFile());
		assertEquals(new GlossaryImpl(createDefaultInternalFile()), glossary);
	}

	@Test
	public void testCreateReference() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Reference reference = factory
				.createReference(createDefaultInternalFile());
		assertEquals(new ReferenceImpl(createDefaultInternalFile()), reference);
	}

	@Test
	public void testCreateNote() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Note note = factory.createNote(new TextImpl("note"));
		assertEquals(new NoteImpl(new TextImpl("note")), note);
	}

	@Test
	public void testCreatePhaseGroup() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		PhaseGroup phaseGroup = factory.createPhaseGroup(createDefaultPhases());
		assertEquals(new PhaseGroupImpl(createDefaultPhases()), phaseGroup);
	}

	@Test
	public void testCreatePhase() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Phase phase = factory.createPhase(new PhaseNameImpl("pn"),
				new ProcessNameImpl("procn"));
		assertEquals(new PhaseImpl(new PhaseNameImpl("pn"),
				new ProcessNameImpl("procn")), phase);
	}

	@Test
	public void testCreateTool() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Tool tool = factory.createTool(new ToolIdImpl("1"), new ToolNameImpl(
				"tn"));
		assertEquals(new ToolImpl(new ToolIdImpl("1"), new ToolNameImpl("tn")),
				tool);
	}

	@Test
	public void testCreateCountGroup() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		CountGroup countGroup = factory.createCountGroup(
				new NameImpl("cgname"), createDefaultCounts());
		assertEquals(new CountGroupImpl(new NameImpl("cgname"),
				createDefaultCounts()), countGroup);
	}

	@Test
	public void testCreateCountCountTypeText() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Count count = factory.createCount(new CountTypeImpl("abc"),
				new TextImpl("3"));
		assertEquals(
				new CountImpl(new CountTypeImpl("abc"), new TextImpl("3")),
				count);
	}

	@Test
	public void testCreateCountCountTypeInt() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Count count = factory.createCount(new CountTypeImpl("abc"), 3);
		assertEquals(
				new CountImpl(new CountTypeImpl("abc"), new TextImpl("3")),
				count);
	}

	@Test
	public void testCreateContextGroup() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		ContextGroup contextGroup = factory
				.createContextGroup(createDefaultContexts());
		assertEquals(new ContextGroupImpl(createDefaultContexts()),
				contextGroup);
	}

	@Test
	public void testCreateContext() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Context context = factory.createContext(new ContextTypeImpl("abc"),
				new TextImpl("xyz"));
		assertEquals(new ContextImpl(new ContextTypeImpl("abc"), new TextImpl(
				"xyz")), context);
	}

	@Test
	public void testCreatePropGroup() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		PropGroup propGroup = factory.createPropGroup(createDefaultProps());
		assertEquals(new PropGroupImpl(createDefaultProps()), propGroup);
	}

	@Test
	public void testCreateProp() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Prop prop = factory.createProp(new PropTypeImpl("abc"), new TextImpl(
				"xyz"));
		assertEquals(
				new PropImpl(new PropTypeImpl("abc"), new TextImpl("xyz")),
				prop);
	}

	@Test
	public void testCreateBody() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Body body = factory.createBody(createDefaultStructuralUnits());
		assertEquals(new BodyImpl(createDefaultStructuralUnits()), body);
	}

	@Test
	public void testCreateGroup() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Group group = factory.createGroup(createDefaultStructuralUnits());
		assertEquals(new GroupImpl(createDefaultStructuralUnits()), group);
	}

	@Test
	public void testCreateTransUnit() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		TransUnit tu = factory.createTransUnit(new IdImpl("1"),
				createDefaultSource());
		assertEquals(new TransUnitImpl(new IdImpl("1"), createDefaultSource()),
				tu);
	}

	@Test
	public void testCreateSourceListOfQextendsTextFragment() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Source source = factory.createSource(createDefaultTextFragments());
		assertEquals(new SourceImpl(createDefaultTextFragments()), source);
	}

	@Test
	public void testCreateSourceString() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Source source = factory.createSource("text");
		assertEquals(new SourceImpl(createDefaultTextFragments()), source);
	}

	@Test
	public void testCreateTargetListOfQextendsTextFragment() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Target target = factory.createTarget(createDefaultTextFragments());
		assertEquals(new TargetImpl(createDefaultTextFragments()), target);
	}

	@Test
	public void testCreateTargetString() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Target target = factory.createTarget("text");
		assertEquals(new TargetImpl(createDefaultTextFragments()), target);
	}

	@Test
	public void testCreateAltTrans() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		AltTrans altTrans = factory.createAltTrans(createDefaultTarget());
		assertEquals(new AltTransImpl(createDefaultTarget()), altTrans);
	}

	@Test
	public void testCreateBinUnit() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		BinUnit binUnit = factory.createBinUnit(new IdImpl("1"),
				new MimeTypeImpl("text/plain"), createDefaultBinSource());
		assertEquals(new BinUnitImpl(new IdImpl("1"), new MimeTypeImpl(
				"text/plain"), createDefaultBinSource()), binUnit);
	}

	@Test
	public void testCreateBinSource() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		BinSource binSource = factory
				.createBinSource(createDefaultInternalFile());
		assertEquals(new BinSourceImpl(createDefaultInternalFile()), binSource);
	}

	@Test
	public void testCreateBinTarget() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		BinTarget binTarget = factory
				.createBinTarget(createDefaultInternalFile());
		assertEquals(new BinTargetImpl(createDefaultInternalFile()), binTarget);
	}

	@Test
	public void testCreateSegSource() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		SegSource segSource = factory
				.createSegSource(createDefaultTextFragments());
		assertEquals(new SegSourceImpl(createDefaultTextFragments()), segSource);
	}

	@Test
	public void testCreateG() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		G g = factory.createG(new IdImpl("1"), createDefaultTextFragments());
		assertEquals(new GImpl(new IdImpl("1"), createDefaultTextFragments()),
				g);
	}

	@Test
	public void testCreateX() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		X x = factory.createX(new IdImpl("1"));
		assertEquals(new XImpl(new IdImpl("1")), x);
	}

	@Test
	public void testCreateBx() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Bx bx = factory.createBx(new IdImpl("1"));
		assertEquals(new BxImpl(new IdImpl("1")), bx);
	}

	@Test
	public void testCreateEx() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Ex ex = factory.createEx(new IdImpl("1"));
		assertEquals(new ExImpl(new IdImpl("1")), ex);
	}

	@Test
	public void testCreatePh() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Ph ph = factory.createPh(new IdImpl("1"), createDefaultCodeFragments());
		assertEquals(new PhImpl(new IdImpl("1"), createDefaultCodeFragments()),
				ph);
	}

	@Test
	public void testCreateBpt() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Bpt bpt = factory.createBpt(new IdImpl("1"),
				createDefaultCodeFragments());
		assertEquals(
				new BptImpl(new IdImpl("1"), createDefaultCodeFragments()), bpt);
	}

	@Test
	public void testCreateEpt() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Ept ept = factory.createEpt(new IdImpl("1"),
				createDefaultCodeFragments());
		assertEquals(
				new EptImpl(new IdImpl("1"), createDefaultCodeFragments()), ept);
	}

	@Test
	public void testCreateIt() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		It it = factory.createIt(new IdImpl("1"), new PosImpl(Pos.Value.OPEN),
				createDefaultCodeFragments());
		assertEquals(new ItImpl(new IdImpl("1"), new PosImpl(Pos.Value.OPEN),
				createDefaultCodeFragments()), it);
	}

	@Test
	public void testCreateSub() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Sub sub = factory.createSub(createDefaultTextFragments());
		assertEquals(new SubImpl(createDefaultTextFragments()), sub);
	}

	@Test
	public void testCreateMrk() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Mrk mrk = factory.createMrk(new MtypeImpl("abc"),
				createDefaultTextFragments());
		assertEquals(new MrkImpl(new MtypeImpl("abc"),
				createDefaultTextFragments()), mrk);
	}

	@Test
	public void testCreateNonXliffElementStringStringCollectionOfQextendsAttributeListOfQextendsNode() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		NonXliffElement nxe = factory.createNonXliffElement("ns", "name",
				createDefaultAttributes(), createDefaultChildren());
		assertEquals(new NonXliffElementImpl("ns", null, "name",
				createDefaultAttributes(), createDefaultChildren()), nxe);
	}

	@Test
	public void testCreateNonXliffElementStringStringStringCollectionOfQextendsAttributeListOfQextendsNode() {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		NonXliffElement nxe = factory.createNonXliffElement("ns", "pre",
				"name", createDefaultAttributes(), createDefaultChildren());
		assertEquals(new NonXliffElementImpl("ns", "pre", "name",
				createDefaultAttributes(), createDefaultChildren()), nxe);
	}

	@Test
	public void testCreateElement() throws ConstraintViolationException {
		ElementFactoryImpl factory = ElementFactoryImpl.getInstance();
		Document doc = Utils.createDocument();
		org.w3c.dom.Element elem;
		Element xliffElem;

		// xliff
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "xliff");
		elem.setAttributeNS(null, "version", "1.2");
		elem.appendChild(createDefaultFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new XliffImpl(new VersionImpl(Version.Value.V1_2),
				createDefaultFiles()), xliffElem);

		// file
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "file");
		elem.setAttributeNS(null, "original", "abc");
		elem.setAttributeNS(null, "source-language", "en-US");
		elem.setAttributeNS(null, "datatype", "x-xyz");
		elem.appendChild(createDefaultBody().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new FileImpl(new OriginalImpl("abc"),
				new SourceLanguageImpl("en-US"), new DataTypeImpl("xyz"),
				createDefaultBody()), xliffElem);

		// header
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "header");
		xliffElem = factory.createElement(elem);
		assertEquals(new HeaderImpl(), xliffElem);

		// skl
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "skl");
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new SklImpl(createDefaultInternalFile()), xliffElem);

		// internal-file
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "internal-file");
		elem.setTextContent("intf");
		xliffElem = factory.createElement(elem);
		assertEquals(new InternalFileImpl(new TextImpl("intf")), xliffElem);

		// external-file
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "external-file");
		elem.setAttributeNS(null, "href", "http://sap.com");
		xliffElem = factory.createElement(elem);
		assertEquals(new ExternalFileImpl(new HrefImpl("http://sap.com")),
				xliffElem);

		// glossary
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "glossary");
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new GlossaryImpl(createDefaultInternalFile()), xliffElem);

		// reference
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "reference");
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new ReferenceImpl(createDefaultInternalFile()), xliffElem);

		// note
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "note");
		elem.setTextContent("textnote");
		xliffElem = factory.createElement(elem);
		assertEquals(new NoteImpl(new TextImpl("textnote")), xliffElem);

		// phase-group
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "phase-group");
		elem.appendChild(createDefaultPhase().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new PhaseGroupImpl(createDefaultPhases()), xliffElem);

		// phase
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "phase");
		elem.setAttributeNS(null, "phase-name", "pn");
		elem.setAttributeNS(null, "process-name", "procn");
		xliffElem = factory.createElement(elem);
		assertEquals(new PhaseImpl(new PhaseNameImpl("pn"),
				new ProcessNameImpl("procn")), xliffElem);

		// tool
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "tool");
		elem.setAttributeNS(null, "tool-id", "ti");
		elem.setAttributeNS(null, "tool-name", "tn");
		xliffElem = factory.createElement(elem);
		assertEquals(
				new ToolImpl(new ToolIdImpl("ti"), new ToolNameImpl("tn")),
				xliffElem);

		// count-group
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "count-group");
		elem.setAttributeNS(null, "name", "cgn");
		elem.appendChild(createDefaultCount().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new CountGroupImpl(new NameImpl("cgn"),
				createDefaultCounts()), xliffElem);

		// count
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "count");
		elem.setAttributeNS(null, "count-type", "total");
		elem.setTextContent("3");
		xliffElem = factory.createElement(elem);
		assertEquals(new CountImpl(new CountTypeImpl(CountType.Value.TOTAL),
				new TextImpl("3")), xliffElem);

		// context-group
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "context-group");
		elem.appendChild(createDefaultContext().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new ContextGroupImpl(createDefaultContexts()), xliffElem);

		// context
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "context");
		elem.setAttributeNS(null, "context-type", "record");
		elem.setTextContent("ctc");
		xliffElem = factory.createElement(elem);
		assertEquals(new ContextImpl(new ContextTypeImpl(
				ContextType.Value.RECORD), new TextImpl("ctc")), xliffElem);

		// prop-group
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "prop-group");
		elem.appendChild(createDefaultProp().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new PropGroupImpl(createDefaultProps()), xliffElem);

		// prop
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "prop");
		elem.setAttributeNS(null, "prop-type", "abc");
		elem.setTextContent("ptc");
		xliffElem = factory.createElement(elem);
		assertEquals(
				new PropImpl(new PropTypeImpl("abc"), new TextImpl("ptc")),
				xliffElem);

		// body
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "body");
		xliffElem = factory.createElement(elem);
		assertEquals(new BodyImpl(new ArrayList<StructuralUnit>()), xliffElem);

		// group
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "group");
		xliffElem = factory.createElement(elem);
		assertEquals(new GroupImpl(new ArrayList<StructuralUnit>()), xliffElem);

		// trans-unit
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "trans-unit");
		elem.setAttributeNS(null, "id", "1");
		elem.appendChild(createDefaultSource().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new TransUnitImpl(new IdImpl("1"), createDefaultSource()),
				xliffElem);

		// source
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "source");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new SourceImpl(createDefaultTextFragments()), xliffElem);

		// target
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "target");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new TargetImpl(createDefaultTextFragments()), xliffElem);

		// alt-trans
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "alt-trans");
		elem.appendChild(createDefaultTarget().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new AltTransImpl(createDefaultTarget()), xliffElem);

		// bin-unit
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-unit");
		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "mime-type", "text/plain");
		elem.appendChild(createDefaultBinSource().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new BinUnitImpl(new IdImpl("1"), new MimeTypeImpl(
				"text/plain"), createDefaultBinSource()), xliffElem);

		// bin-source
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-source");
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new BinSourceImpl(createDefaultInternalFile()), xliffElem);

		// bin-target
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-target");
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		xliffElem = factory.createElement(elem);
		assertEquals(new BinTargetImpl(createDefaultInternalFile()), xliffElem);

		// seg-source
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "seg-source");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new SegSourceImpl(createDefaultTextFragments()), xliffElem);

		// g
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "g");
		elem.setAttributeNS(null, "id", "1");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new GImpl(new IdImpl("1"), createDefaultTextFragments()),
				xliffElem);

		// x
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "x");
		elem.setAttributeNS(null, "id", "1");
		xliffElem = factory.createElement(elem);
		assertEquals(new XImpl(new IdImpl("1")), xliffElem);

		// bx
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bx");
		elem.setAttributeNS(null, "id", "1");
		xliffElem = factory.createElement(elem);
		assertEquals(new BxImpl(new IdImpl("1")), xliffElem);

		// ex
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ex");
		elem.setAttributeNS(null, "id", "1");
		xliffElem = factory.createElement(elem);
		assertEquals(new ExImpl(new IdImpl("1")), xliffElem);

		// ph
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ph");
		elem.setAttributeNS(null, "id", "1");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new PhImpl(new IdImpl("1"), createDefaultCodeFragments()),
				xliffElem);

		// bpt
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bpt");
		elem.setAttributeNS(null, "id", "1");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(
				new BptImpl(new IdImpl("1"), createDefaultCodeFragments()),
				xliffElem);

		// ept
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "ept");
		elem.setAttributeNS(null, "id", "1");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(
				new EptImpl(new IdImpl("1"), createDefaultCodeFragments()),
				xliffElem);

		// it
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "it");
		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "pos", "open");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new ItImpl(new IdImpl("1"), new PosImpl(Pos.Value.OPEN),
				createDefaultCodeFragments()), xliffElem);

		// sub
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "sub");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new SubImpl(createDefaultTextFragments()), xliffElem);

		// mrk
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "mrk");
		elem.setAttributeNS(null, "mtype", "formula");
		elem.setTextContent("text");
		xliffElem = factory.createElement(elem);
		assertEquals(new MrkImpl(new MtypeImpl(Mtype.Value.FORMULA),
				createDefaultTextFragments()), xliffElem);

		// invalid
		elem = doc.createElementNS(XLIFF_12_NAMESPACE, "invalid");
		try {
			factory.createElement(elem);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}

	}

	private List<TextFragment> createDefaultTextFragments() {
		ArrayList<TextFragment> fragments = new ArrayList<TextFragment>();
		fragments.add(new TextImpl("text"));
		return fragments;
	}

	private List<CodeFragment> createDefaultCodeFragments() {
		ArrayList<CodeFragment> fragments = new ArrayList<CodeFragment>();
		fragments.add(new TextImpl("text"));
		return fragments;
	}

	private InternalFile createDefaultInternalFile() {
		return new InternalFileImpl(new TextImpl("intf"));
	}

	private BinSource createDefaultBinSource() {
		return new BinSourceImpl(createDefaultInternalFile());
	}

	private Target createDefaultTarget() {
		return new TargetImpl(createDefaultTextFragments());
	}

	private Source createDefaultSource() {
		return new SourceImpl(createDefaultTextFragments());
	}

	private TransUnit createDefaultTransUnit() {
		return new TransUnitImpl(new IdImpl("1"), createDefaultSource());
	}

	private List<StructuralUnit> createDefaultStructuralUnits() {
		ArrayList<StructuralUnit> sus = new ArrayList<StructuralUnit>();
		sus.add(createDefaultTransUnit());
		return sus;
	}

	private List<Prop> createDefaultProps() {
		ArrayList<Prop> props = new ArrayList<Prop>();
		props.add(createDefaultProp());
		return props;
	}

	private Prop createDefaultProp() {
		return new PropImpl(new PropTypeImpl("abc"), new TextImpl("xyz"));
	}

	private List<Context> createDefaultContexts() {
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts.add(createDefaultContext());
		return contexts;
	}

	private Context createDefaultContext() {
		return new ContextImpl(new ContextTypeImpl("abc"), new TextImpl("xyz"));
	}

	private List<Count> createDefaultCounts() {
		ArrayList<Count> counts = new ArrayList<Count>();
		counts.add(createDefaultCount());
		return counts;
	}

	private Count createDefaultCount() {
		return new CountImpl(new CountTypeImpl("abc"), new TextImpl("3"));
	}

	private List<Phase> createDefaultPhases() {
		ArrayList<Phase> phases = new ArrayList<Phase>();
		phases.add(createDefaultPhase());
		return phases;
	}

	private Phase createDefaultPhase() {
		return new PhaseImpl(new PhaseNameImpl("pn"), new ProcessNameImpl(
				"procn"));
	}

	private Body createDefaultBody() {
		return new BodyImpl(createDefaultStructuralUnits());
	}

	private File createDefaultFile() {
		return new FileImpl(new OriginalImpl("abc"), new SourceLanguageImpl(
				"en-US"), new DataTypeImpl("xyz"), createDefaultBody());
	}

	private List<File> createDefaultFiles() {
		ArrayList<File> files = new ArrayList<File>();
		files.add(createDefaultFile());
		return files;
	}

	private List<Attribute> createDefaultAttributes() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		return attributes;
	}

	private List<Node> createDefaultChildren() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		return nodes;
	}
}
