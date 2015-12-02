package com.sap.mlt.xliff12.api.factory;

import java.util.Collection;
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
import com.sap.mlt.xliff12.api.text.Text;

/**
 * XLIFF element factory.
 * 
 * Use an instance of this factory to create XLIFF elements. On creation of
 * elements you have to pass all mandatory attributes and child elements. You
 * can set/add optional attributes and child elements by using the appropriate
 * setter methods of the created elements.
 * 
 * @author D049314
 */
public interface ElementFactory {

	/**
	 * Creates and returns an <code>Xliff</code> element.
	 * 
	 * @param version
	 *            The version of the XLIFF
	 * @param files
	 *            The files the XLIFF will contain
	 * @return Creates and returns an <code>Xliff</code> element.
	 */
	Xliff createXliff(Version version, List<File> files);

	/**
	 * Creates and returns an <code>Xliff</code> element. Convenience method
	 * that calls {@link #createXliff(Version, List)} with a list containing the
	 * passed file.
	 * 
	 * @param version
	 *            The version of the XLIFF
	 * @param file
	 *            The file that will be contained in the XLIFF
	 * @return Creates and returns an <code>Xliff</code> element.
	 */
	Xliff createXliff(Version version, File file);

	/**
	 * Creates and returns a <code>File</code> element.
	 * 
	 * @param original
	 *            The original attribute
	 * @param sourceLanguage
	 *            The source language attribute
	 * @param dataType
	 *            The datatype attribute
	 * @param body
	 *            The body element
	 * @return Creates and returns a <code>File</code> element.
	 */
	File createFile(Original original, SourceLanguage sourceLanguage,
			DataType dataType, Body body);

	/**
	 * Creates and returns a <code>Header</code> element.
	 * 
	 * @return Creates and returns a header element.
	 */
	Header createHeader();

	/**
	 * Creates and returns a <code>Skl</code> element.
	 * 
	 * @param child
	 *            The skeleton's child (either a {@link InternalFile} or
	 *            {@link ExternalFile})
	 * @return Creates and returns a <code>Skl</code> element.
	 */
	Skl createSkl(Skl.Child child);

	/**
	 * Creates and returns an <code>InternalFile</code> element.
	 * 
	 * @param embeddedFile
	 *            The file embedded in the internal file element
	 * @return Creates and returns an <code>InternalFile</code> element.
	 */
	InternalFile createInternalFile(Text embeddedFile);

	/**
	 * Creates and returns an <code>ExternalFile</code> element.
	 * 
	 * @param href
	 *            The hypertext reference to the embedded file
	 * @return Creates and returns an <code>ExternalFile</code> element.
	 */
	ExternalFile createExternalFile(Href href);

	/**
	 * Creates and returns a <code>Glossary</code> element.
	 * 
	 * @param child
	 *            The glossary's child (either a {@link InternalFile} or
	 *            {@link ExternalFile})
	 * @return Creates and returns a <code>Glossary</code> element.
	 */
	Glossary createGlossary(Glossary.Child child);

	/**
	 * Creates and returns a <code>Reference</code> element.
	 * 
	 * @param child
	 *            The reference's child (either a {@link InternalFile} or
	 *            {@link ExternalFile})
	 * @return Creates and returns a <code>Reference</code> element.
	 */
	Reference createReference(Reference.Child child);

	/**
	 * Creates and returns a <code>Note</code> element.
	 * 
	 * @param note
	 *            The note's content
	 * @return Creates and returns a <code>Note</code> element.
	 */
	Note createNote(Text note);

	/**
	 * Creates and returns a <code>PhaseGroup</code> element.
	 * 
	 * @param phases
	 *            A list of one or more phases contained in this phase group.
	 * @return Creates and returns a <code>PhaseGroup</code> element.
	 */
	PhaseGroup createPhaseGroup(List<Phase> phases);

	/**
	 * Creates and returns a <code>Phase</code> element.
	 * 
	 * @param phaseName
	 *            The phase name
	 * @param processName
	 *            The process name
	 * @return Creates and returns a <code>Phase</code> element.
	 */
	Phase createPhase(PhaseName phaseName, ProcessName processName);

	/**
	 * Creates and returns a <code>Tool</code> element.
	 * 
	 * @param toolId
	 *            The tool-id attribute
	 * @param toolName
	 *            The tool name
	 * @return Creates and returns a <code>Tool</code> element.
	 */
	Tool createTool(ToolId toolId, ToolName toolName);

	/**
	 * Creates and returns a <code>CountGroup</code> element.
	 * 
	 * @param name
	 *            The count-group's name attribute
	 * @param counts
	 *            One or more {@link Count} elements
	 * @return Creates and returns a <code>CountGroup</code> element.
	 */
	CountGroup createCountGroup(Name name, List<Count> counts);

	/**
	 * Creates and returns a <code>Count</code> element.
	 * 
	 * @param countType
	 *            The count type attribute
	 * @param number
	 *            The count number
	 * @return Creates and returns a <code>Count</code> element.
	 */
	Count createCount(CountType countType, Text number);

	/**
	 * Creates and returns a <code>Count</code> element.
	 * 
	 * @param countType
	 *            The count type attribute
	 * @param number
	 *            The count number
	 * @return Creates and returns a <code>Count</code> element.
	 */
	Count createCount(CountType countType, int number);

	/**
	 * Creates and returns a <code>ContextGroup</code> element.
	 * 
	 * @param contexts
	 *            One or more {@link Context} elements
	 * @return Creates and returns a <code>ContextGroup</code> element.
	 */
	ContextGroup createContextGroup(List<Context> contexts);

	/**
	 * Creates and returns a <code>Context</code> element.
	 * 
	 * @param contextType
	 *            The context type attribute
	 * @param content
	 *            The content text
	 * @return Creates and returns a <code>Context</code> element.
	 */
	Context createContext(ContextType contextType, Text content);

	/**
	 * Creates and returns a <code>PropGroup</code> element.
	 * 
	 * @param props
	 *            One or more
	 *            {@link com.sap.mlt.xliff12.api.element.namedgroup.Prop}
	 *            elements
	 * @return Creates and returns a
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup}
	 *         element.
	 * 
	 * @deprecated The <code>PropGroup</code> element was DEPRECATED in version
	 *             1.1. Instead, use attributes defined in a namespace different
	 *             from XLIFF.
	 */
	com.sap.mlt.xliff12.api.element.namedgroup.PropGroup createPropGroup(
			List<com.sap.mlt.xliff12.api.element.namedgroup.Prop> props);

	/**
	 * Creates and returns a <code>Prop</code> element.
	 * 
	 * @param propType
	 *            The property type attribute
	 * @param content
	 *            the property's content
	 * @return Creates and returns a
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.Prop} element.
	 * 
	 * @deprecated The <code>Prop</code> element was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	com.sap.mlt.xliff12.api.element.namedgroup.Prop createProp(
			com.sap.mlt.xliff12.api.attribute.PropType propType, Text content);

	/**
	 * Creates and returns a <code>Body</code> element.
	 * 
	 * @param structuralUnits
	 *            A list of {@link StructuralUnit}s the body will contain (can
	 *            contain {@link TransUnit}s, {@link Group}s and {@link BinUnit}
	 *            s)
	 * @return Creates and returns a <code>Body</code> element.
	 */
	Body createBody(List<? extends StructuralUnit> structuralUnits);

	/**
	 * Creates and returns a <code>Group</code> element.
	 * 
	 * @param structuralUnits
	 *            A list of {@link StructuralUnit}s the group will contain (can
	 *            contain {@link TransUnit}s, {@link Group}s and {@link BinUnit}
	 *            s)
	 * @return Creates and returns a <code>Group</code> element.
	 */
	Group createGroup(List<? extends StructuralUnit> structuralUnits);

	/**
	 * Creates and returns a <code>TransUnit</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param source
	 *            The {@link Source} element
	 * @return Creates and returns a <code>TransUnit</code> element.
	 */
	TransUnit createTransUnit(Id id, Source source);

	/**
	 * Creates and returns a <code>Source</code> element.
	 * 
	 * @param textFragments
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates and returns a <code>Source</code> element.
	 */
	Source createSource(List<? extends TextFragment> textFragments);

	/**
	 * Creates and returns a <code>Source</code> element with the passed text.
	 * Convenience method.
	 * 
	 * @param text
	 *            The text the source will contain
	 * @return Creates and returns a <code>Source</code> element with the passed
	 *         text.
	 */
	Source createSource(String text);

	/**
	 * Creates and returns a <code>Target</code> element.
	 * 
	 * @param textFragments
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates and returns a <code>Target</code> element.
	 */
	Target createTarget(List<? extends TextFragment> textFragments);

	/**
	 * Creates and returns a <code>Target</code> element with the passed text.
	 * Convenience method.
	 * 
	 * @param text
	 *            The text the target will contain
	 * @return Creates and returns a <code>Target</code> element with the passed
	 *         text.
	 */
	Target createTarget(String text);

	/**
	 * Creates and returns an <code>AltTrans</code> element.
	 * 
	 * @param target
	 *            The {@link Target} element the {@link AltTrans} element will
	 *            contain
	 * @return Creates and returns an <code>AltTrans</code> element.
	 */
	AltTrans createAltTrans(Target target);

	/**
	 * Creates and returns a <code>BinUnit</code> element.
	 * 
	 * @param id
	 *            The element's id attribute
	 * @param mimeType
	 *            The element's mime type attribute
	 * @param binSource
	 *            The {@link BinSource} element
	 * @return Creates and returns a <code>BinUnit</code> element.
	 */
	BinUnit createBinUnit(Id id, MimeType mimeType, BinSource binSource);

	/**
	 * Creates and returns a <code>BinSource</code> element.
	 * 
	 * @param child
	 *            The element's child (either an {@link ExternalFile} or an
	 *            {@link InternalFile})
	 * @return Creates and returns a <code>BinSource</code> element.
	 */
	BinSource createBinSource(BinSource.Child child);

	/**
	 * Creates and returns a <code>BinTarget</code> element.
	 * 
	 * @param child
	 *            The element's child (either an {@link ExternalFile} or an
	 *            {@link InternalFile})
	 * @return Creates and returns a <code>BinTarget</code> element.
	 */
	BinTarget createBinTarget(BinTarget.Child child);

	/**
	 * Creates and returns a <code>SegSource</code> element.
	 * 
	 * @param textFragments
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates a {@link SegSource} element.
	 */
	SegSource createSegSource(List<? extends TextFragment> textFragments);

	/**
	 * Creates and returns a <code>G</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param content
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates and returns a <code>G</code> element.
	 */
	G createG(Id id, List<? extends TextFragment> content);

	/**
	 * Creates and returns an <code>X</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @return Creates and returns an <code>X</code> element.
	 */
	X createX(Id id);

	/**
	 * Creates and returns a <code>Bx</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @return Creates and returns a <code>Bx</code> element.
	 */
	Bx createBx(Id id);

	/**
	 * Creates and returns an <code>Ex</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @return Creates and returns an <code>Ex</code> element.
	 */
	Ex createEx(Id id);

	/**
	 * Creates and returns a <code>Ph</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param content
	 *            A list of {@link CodeFragment}s the element will contain (can
	 *            contain any number of {@link Text}s and {@link Sub}s)
	 * @return Creates and returns a <code>Ph</code> element.
	 */
	Ph createPh(Id id, List<? extends CodeFragment> content);

	/**
	 * Creates and returns a <code>Bpt</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param content
	 *            A list of {@link CodeFragment}s the element will contain (can
	 *            contain any number of {@link Text}s and {@link Sub}s)
	 * @return Creates and returns a <code>Bpt</code> element.
	 */
	Bpt createBpt(Id id, List<? extends CodeFragment> content);

	/**
	 * Creates and returns a <code>Ept</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param content
	 *            A list of {@link CodeFragment}s the element will contain (can
	 *            contain any number of {@link Text}s and {@link Sub}s)
	 * @return Creates and returns a <code>Ept</code> element.
	 */
	Ept createEpt(Id id, List<? extends CodeFragment> content);

	/**
	 * Creates and returns an <code>It</code> element.
	 * 
	 * @param id
	 *            The id attribute
	 * @param pos
	 *            The pos attribute
	 * @param content
	 *            A list of {@link CodeFragment}s the element will contain (can
	 *            contain any number of {@link Text}s and {@link Sub}s)
	 * @return Creates and returns a <code>It</code> element.
	 */
	It createIt(Id id, Pos pos, List<? extends CodeFragment> content);

	/**
	 * Creates and returns a <code>Sub</code> element.
	 * 
	 * @param content
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates and returns a <code>Sub</code> element.
	 */
	Sub createSub(List<? extends TextFragment> content);

	/**
	 * Creates and returns a <code>Mrk</code> element.
	 * 
	 * @param mtype
	 *            The marker type attribute
	 * @param content
	 *            A list of {@link TextFragment}s the element will contain (can
	 *            contain any number of {@link Text}s, {@link Bpt}s, {@link Ept}
	 *            s, {@link Bx}s, {@link Ex}s, {@link G}s, {@link It}s,
	 *            {@link Mrk}s, {@link Ph}s and {@link X}s)
	 * @return Creates and returns a <code>Mrk</code> element.
	 */
	Mrk createMrk(Mtype mtype, List<? extends TextFragment> content);

	/**
	 * Creates and returns a non-XLIFF element.
	 * 
	 * @param namespaceUri
	 *            The element's namespace URI
	 * @param name
	 *            The element's local name
	 * @param attributes
	 *            The element's attributes
	 * @param children
	 *            The element's child nodes
	 * @return Creates and returns a non-XLIFF element.
	 */
	NonXliffElement createNonXliffElement(String namespaceUri, String name,
			Collection<? extends Attribute> attributes,
			List<? extends Node> children);

	/**
	 * Creates and returns a non-XLIFF element.
	 * 
	 * @param namespaceUri
	 *            The element's namespace URI
	 * @param prefix
	 *            The element's prefix. May be <code>null</code>.
	 * @param name
	 *            The element's local name
	 * @param attributes
	 *            The element's attributes
	 * @param children
	 *            The element's child nodes
	 * @return Creates and returns a non-XLIFF element.
	 */
	NonXliffElement createNonXliffElement(String namespaceUri, String prefix,
			String name, Collection<? extends Attribute> attributes,
			List<? extends Node> children);

	/**
	 * Creates and returns an non XLIFF-element that can be used with this API
	 * and that corresponds to the passed element from the org.w3c.dom package.
	 * 
	 * @param xmlElement
	 *            An element
	 * @return Creates and returns an element that can be used with this API and
	 *         that corresponds to the passed element from the org.w3c.dom
	 *         package.
	 * @throws ConstraintViolationException
	 *             Occurs if the passed element element belongs to the XLIFF
	 *             namespace or if one of its children belongs to XLIFF's
	 *             namespace and has invalid content (e.g. if mandatory XLIFF
	 *             attributes are missing on XLIFF elements)
	 */
	NonXliffElement createNonXliffElement(org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException;

	/**
	 * Creates and returns an element that can be used with this API and that
	 * corresponds to the passed element from the org.w3c.dom package.
	 * 
	 * @param xmlElement
	 *            An element
	 * @return Creates and returns an element that can be used with this API and
	 *         that corresponds to the passed element from the org.w3c.dom
	 *         package.
	 * @throws ConstraintViolationException
	 *             Occurs if the passed element or one of its children belong to
	 *             XLIFF's namespace and have invalid content (e.g. if mandatory
	 *             XLIFF attributes are missing on XLIFF elements)
	 */
	Element createElement(org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException;
}
