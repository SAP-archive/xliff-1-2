package com.sap.mlt.xliff12.impl.factory;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Href;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.Name;
import com.sap.mlt.xliff12.api.attribute.Original;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Pos;
import com.sap.mlt.xliff12.api.attribute.ProcessName;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.ToolName;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.Glossary;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.element.header.PhaseGroup;
import com.sap.mlt.xliff12.api.element.header.Reference;
import com.sap.mlt.xliff12.api.element.header.Reference.Child;
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
import com.sap.mlt.xliff12.api.factory.ElementFactory;
import com.sap.mlt.xliff12.api.text.Text;
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
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;

@SuppressWarnings("deprecation")
public class ElementFactoryImpl implements ElementFactory {

	private static final ElementFactoryImpl INSTANCE = new ElementFactoryImpl();

	public static ElementFactoryImpl getInstance() {
		return INSTANCE;
	}

	private ElementFactoryImpl() {
	}

	public Xliff createXliff(Version version, List<File> files) {
		return new XliffImpl(version, files);
	}

	public Xliff createXliff(Version version, File file) {
		return new XliffImpl(version, Collections.singletonList(file));
	}

	public File createFile(Original original, SourceLanguage sourceLanguage,
			DataType dataType, Body body) {
		return new FileImpl(original, sourceLanguage, dataType, body);
	}

	public Header createHeader() {
		return new HeaderImpl();
	}

	public Skl createSkl(Skl.Child part) {
		return new SklImpl(part);
	}

	public InternalFile createInternalFile(Text embeddedFile) {
		return new InternalFileImpl(embeddedFile);
	}

	public ExternalFile createExternalFile(Href href) {
		return new ExternalFileImpl(href);
	}

	public Glossary createGlossary(Glossary.Child part) {
		return new GlossaryImpl(part);
	}

	public Reference createReference(Child child) {
		return new ReferenceImpl(child);
	}

	public Note createNote(Text note) {
		return new NoteImpl(note);
	}

	public PhaseGroup createPhaseGroup(List<Phase> phases) {
		return new PhaseGroupImpl(phases);
	}

	public Phase createPhase(PhaseName phaseName, ProcessName processName) {
		return new PhaseImpl(phaseName, processName);
	}

	public Tool createTool(ToolId toolId, ToolName toolName) {
		return new ToolImpl(toolId, toolName);
	}

	public CountGroup createCountGroup(Name name, List<Count> counts) {
		return new CountGroupImpl(name, counts);
	}

	public Count createCount(CountType countType, Text number) {
		return new CountImpl(countType, number);
	}

	public Count createCount(CountType countType, int number) {
		return new CountImpl(countType, new TextImpl(Integer.toString(number)));
	}

	public ContextGroup createContextGroup(List<Context> contexts) {
		return new ContextGroupImpl(contexts);
	}

	public Context createContext(ContextType contextType, Text content) {
		return new ContextImpl(contextType, content);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.element.namedgroup.PropGroup createPropGroup(
			List<com.sap.mlt.xliff12.api.element.namedgroup.Prop> props) {
		return new com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl(
				props);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.element.namedgroup.Prop createProp(
			com.sap.mlt.xliff12.api.attribute.PropType propType, Text content) {
		return new com.sap.mlt.xliff12.impl.element.namedgroup.PropImpl(
				propType, content);
	}

	public Body createBody(List<? extends StructuralUnit> structuralUnits) {
		return new BodyImpl(structuralUnits);
	}

	public Group createGroup(List<? extends StructuralUnit> structuralUnits) {
		return new GroupImpl(structuralUnits);
	}

	public TransUnit createTransUnit(Id id, Source source) {
		return new TransUnitImpl(id, source);
	}

	public Source createSource(List<? extends TextFragment> textFragments) {
		return new SourceImpl(textFragments);
	}

	public Source createSource(String text) {
		return new SourceImpl(Collections.singletonList(new TextImpl(text)));
	}

	public Target createTarget(List<? extends TextFragment> textFragments) {
		return new TargetImpl(textFragments);
	}

	public Target createTarget(String text) {
		return new TargetImpl(Collections.singletonList(new TextImpl(text)));
	}

	public AltTrans createAltTrans(Target target) {
		return new AltTransImpl(target);
	}

	public BinUnit createBinUnit(Id id, MimeType mimeType, BinSource binSource) {
		return new BinUnitImpl(id, mimeType, binSource);
	}

	public BinSource createBinSource(BinSource.Child child) {
		return new BinSourceImpl(child);
	}

	public BinTarget createBinTarget(BinTarget.Child child) {
		return new BinTargetImpl(child);
	}

	public SegSource createSegSource(List<? extends TextFragment> textFragments) {
		return new SegSourceImpl(textFragments);
	}

	public G createG(Id id, List<? extends TextFragment> content) {
		return new GImpl(id, content);
	}

	public X createX(Id id) {
		return new XImpl(id);
	}

	public Bx createBx(Id id) {
		return new BxImpl(id);
	}

	public Ex createEx(Id id) {
		return new ExImpl(id);
	}

	public Ph createPh(Id id, List<? extends CodeFragment> content) {
		return new PhImpl(id, content);
	}

	public Bpt createBpt(Id id, List<? extends CodeFragment> content) {
		return new BptImpl(id, content);
	}

	public Ept createEpt(Id id, List<? extends CodeFragment> content) {
		return new EptImpl(id, content);
	}

	public It createIt(Id id, Pos pos, List<? extends CodeFragment> content) {
		return new ItImpl(id, pos, content);
	}

	public Sub createSub(List<? extends TextFragment> content) {
		return new SubImpl(content);
	}

	public Mrk createMrk(Mtype mtype, List<? extends TextFragment> content) {
		return new MrkImpl(mtype, content);
	}

	public NonXliffElement createNonXliffElement(org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException {
		return new NonXliffElementImpl(xmlElement);
	}

	public NonXliffElement createNonXliffElement(String namespaceUri,
			String name, Collection<? extends Attribute> attributes,
			List<? extends Node> children) {
		return new NonXliffElementImpl(namespaceUri, null, name, attributes,
				children);
	}

	public NonXliffElement createNonXliffElement(String namespaceUri,
			String prefix, String name,
			Collection<? extends Attribute> attributes,
			List<? extends Node> children) {
		return new NonXliffElementImpl(namespaceUri, prefix, name, attributes,
				children);
	}

	public Element createElement(org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException {
		String namespaceUri = xmlElement.getNamespaceURI();
		if (Schemas.XLIFF_12_NAMESPACE.equals(namespaceUri)) {
			return createXliffElement(xmlElement);
		}
		return createNonXliffElement(xmlElement);
	}

	private XliffElement createXliffElement(org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException {
		String name = xmlElement.getLocalName();
		if (Xliff.NAME.equals(name)) {
			return new XliffImpl(xmlElement);
		} else if (File.NAME.equals(name)) {
			return new FileImpl(xmlElement);
		} else if (Header.NAME.equals(name)) {
			return new HeaderImpl(xmlElement);
		} else if (Skl.NAME.equals(name)) {
			return new SklImpl(xmlElement);
		} else if (InternalFile.NAME.equals(name)) {
			return new InternalFileImpl(xmlElement);
		} else if (ExternalFile.NAME.equals(name)) {
			return new ExternalFileImpl(xmlElement);
		} else if (Glossary.NAME.equals(name)) {
			return new GlossaryImpl(xmlElement);
		} else if (Reference.NAME.equals(name)) {
			return new ReferenceImpl(xmlElement);
		} else if (Note.NAME.equals(name)) {
			return new NoteImpl(xmlElement);
		} else if (PhaseGroup.NAME.equals(name)) {
			return new PhaseGroupImpl(xmlElement);
		} else if (Phase.NAME.equals(name)) {
			return new PhaseImpl(xmlElement);
		} else if (Tool.NAME.equals(name)) {
			return new ToolImpl(xmlElement);
		} else if (CountGroup.NAME.equals(name)) {
			return new CountGroupImpl(xmlElement);
		} else if (Count.NAME.equals(name)) {
			return new CountImpl(xmlElement);
		} else if (ContextGroup.NAME.equals(name)) {
			return new ContextGroupImpl(xmlElement);
		} else if (Context.NAME.equals(name)) {
			return new ContextImpl(xmlElement);
		} else if (PropGroup.NAME.equals(name)) {
			return new PropGroupImpl(xmlElement);
		} else if (Prop.NAME.equals(name)) {
			return new PropImpl(xmlElement);
		} else if (Body.NAME.equals(name)) {
			return new BodyImpl(xmlElement);
		} else if (Group.NAME.equals(name)) {
			return new GroupImpl(xmlElement);
		} else if (TransUnit.NAME.equals(name)) {
			return new TransUnitImpl(xmlElement);
		} else if (Source.NAME.equals(name)) {
			return new SourceImpl(xmlElement);
		} else if (Target.NAME.equals(name)) {
			return new TargetImpl(xmlElement);
		} else if (AltTrans.NAME.equals(name)) {
			return new AltTransImpl(xmlElement);
		} else if (BinUnit.NAME.equals(name)) {
			return new BinUnitImpl(xmlElement);
		} else if (BinSource.NAME.equals(name)) {
			return new BinSourceImpl(xmlElement);
		} else if (BinTarget.NAME.equals(name)) {
			return new BinTargetImpl(xmlElement);
		} else if (SegSource.NAME.equals(name)) {
			return new SegSourceImpl(xmlElement);
		} else if (G.NAME.equals(name)) {
			return new GImpl(xmlElement);
		} else if (X.NAME.equals(name)) {
			return new XImpl(xmlElement);
		} else if (Bx.NAME.equals(name)) {
			return new BxImpl(xmlElement);
		} else if (Ex.NAME.equals(name)) {
			return new ExImpl(xmlElement);
		} else if (Ph.NAME.equals(name)) {
			return new PhImpl(xmlElement);
		} else if (Bpt.NAME.equals(name)) {
			return new BptImpl(xmlElement);
		} else if (Ept.NAME.equals(name)) {
			return new EptImpl(xmlElement);
		} else if (It.NAME.equals(name)) {
			return new ItImpl(xmlElement);
		} else if (Sub.NAME.equals(name)) {
			return new SubImpl(xmlElement);
		} else if (Mrk.NAME.equals(name)) {
			return new MrkImpl(xmlElement);
		}
		String msg = MessageFormat.format(
				"''{0}'' is not a valid element of the XLIFF namespace", name);
		throw new IllegalArgumentException(msg);
	}

}
