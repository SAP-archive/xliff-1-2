package com.sap.mlt.xliff12.impl.element.toplevel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.element.toplevel.File;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginalImpl;
import com.sap.mlt.xliff12.impl.attribute.SourceLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.VersionImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.element.structural.BodyImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class XliffImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testXliffImplVersionListOfFile() {
		XliffImpl xliff = createDefaultXliff();
		assertEquals(new VersionImpl(Version.Value.V1_2), xliff.getVersion());
		assertEquals(createDefaultFile(), xliff.getFiles().get(0));
	}

	@Test
	public void testXliffImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "xliff");
		elem.setAttributeNS(null, "version", "1.2");
		elem.appendChild(createDefaultFile().asXmlNode(doc));
		
		try {
			XliffImpl xliff = new XliffImpl(elem);
			assertEquals(new VersionImpl(Version.Value.V1_2), xliff.getVersion());
			assertEquals(createDefaultFile(), xliff.getFiles().get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new XliffImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.appendChild(doc.createTextNode("abc"));
		try {
			new XliffImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			XliffImpl xliff = new XliffImpl(elem);
			assertEquals(new VersionImpl(Version.Value.V1_2), xliff.getVersion());
			assertEquals(createDefaultFile(), xliff.getFiles().get(0));
			NonXliffElement nxe = xliff.getNonXliffElements().get(0);
			assertEquals("ns", nxe.getNamespaceUri());
			assertEquals("name", nxe.getName());
			elem.removeChild(elem.getLastChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.removeChild(elem.getFirstChild());
		try {
			new XliffImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		XliffImpl xliff = createDefaultXliff();
		List<? extends Node> children = xliff.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals(createDefaultFile(), children.get(0));
	}
	
	@Test
	public void testFiles() {
		XliffImpl xliff = createDefaultXliff();
		
		try {
			xliff.setFiles(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultFile(), xliff.getFiles().get(0));
		
		ArrayList<File> files = new ArrayList<File>();
		try {
			xliff.setFiles(files);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultFile(), xliff.getFiles().get(0));
		
		files.add(createDefaultFile());
		files.add(createDefaultFile());
		xliff.setFiles(files);
		assertEquals(new Integer(2), new Integer(xliff.getFiles().size()));
		assertEquals(createDefaultFile(), xliff.getFiles().get(0));
		assertEquals(createDefaultFile(), xliff.getFiles().get(1));
	}
	
	@Test
	public void testGetNonXliffElements() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "xliff");
		elem.setAttributeNS(null, "version", "1.2");
		elem.appendChild(createDefaultFile().asXmlNode(doc));
		
		try {
			XliffImpl xliff = new XliffImpl(elem);
			assertTrue(xliff.getNonXliffElements().isEmpty());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			XliffImpl xliff = new XliffImpl(elem);
			NonXliffElement nxe = xliff.getNonXliffElements().get(0);
			assertEquals("ns", nxe.getNamespaceUri());
			assertEquals("name", nxe.getName());
			elem.removeChild(elem.getLastChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testVersion() {
		XliffImpl xliff = createDefaultXliff();

		try {
			xliff.setVersion(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		xliff.setVersion(new VersionImpl(Version.Value.V1_1));
		assertEquals(new VersionImpl(Version.Value.V1_1), xliff.getVersion());
	}
	
	@Test
	public void testXmlLang() {
		XliffImpl xliff = createDefaultXliff();
		assertNull(xliff.getXmlLang());
		
		xliff.setXmlLang(new XmlLangImpl("fr-FR"));
		assertEquals(new XmlLangImpl("fr-FR"), xliff.getXmlLang());
		
		xliff.setXmlLang(null);
		assertNull(xliff.getXmlLang());
	}
	
	@Test
	public void testNonXliffAttributes() {
		XliffImpl xliff = createDefaultXliff();
		Collection<NonXliffAttribute> nonXliffAttributes = xliff
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		xliff.setNonXliffAttributes(nxas);

		nonXliffAttributes = xliff.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		xliff.setNonXliffAttributes(nxas);

		nonXliffAttributes = xliff.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		xliff.setNonXliffAttributes(nxas);
		nonXliffAttributes = xliff.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}
	
	@Test
	public void testClone() {
		XliffImpl xliff = createDefaultXliff();
		XliffImpl clone = (XliffImpl) xliff.clone();
		assertEquals(xliff, clone);
		assertNotSame(xliff, clone);
	}
	
	private XliffImpl createDefaultXliff() {
		VersionImpl version = new VersionImpl(Version.Value.V1_2);
		ArrayList<File> files = new ArrayList<File>();
		files.add(createDefaultFile());
		XliffImpl xliff = new XliffImpl(version, files);
		return xliff;
	}
	
	private FileImpl createDefaultFile() {
		OriginalImpl original = new OriginalImpl("orig");
		SourceLanguageImpl sourceLanguage = new SourceLanguageImpl("en-US");
		DataTypeImpl dataType = new DataTypeImpl(DataType.Value.PLAINTEXT); 
		BodyImpl body = createDefaultBody();
		FileImpl file = new FileImpl(original, sourceLanguage, dataType, body);
		return file;
	}
	
	private BodyImpl createDefaultBody() {
		return new BodyImpl(new ArrayList<StructuralUnit>());
	}
}
