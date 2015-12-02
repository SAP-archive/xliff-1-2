package com.sap.mlt.xliff12.impl.element.toplevel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.BuildNumImpl;
import com.sap.mlt.xliff12.impl.attribute.CategoryImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.DateImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginalImpl;
import com.sap.mlt.xliff12.impl.attribute.ProductNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProductVersionImpl;
import com.sap.mlt.xliff12.impl.attribute.SourceLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.TargetLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.element.header.HeaderImpl;
import com.sap.mlt.xliff12.impl.element.structural.BodyImpl;
import com.sap.mlt.xliff12.impl.element.structural.GroupImpl;
import com.sap.mlt.xliff12.impl.util.DateTime;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class FileImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testFileImplOriginalSourceLanguageDataTypeBody() {
		FileImpl file = createDefaultFile();
		assertEquals(new OriginalImpl("orig"), file.getOriginal());
		assertEquals(new SourceLanguageImpl("en-US"), file.getSourceLanguage());
		assertEquals(new DataTypeImpl(DataType.Value.PLAINTEXT), file.getDataType());
		assertEquals(createDefaultBody(), file.getBody());
	}

	@Test
	public void testFileImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "file");
		elem.setAttributeNS(null, "original", "orig");
		elem.setAttributeNS(null, "source-language", "en-US");
		elem.setAttributeNS(null, "datatype", "plaintext");
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "body"));

		try {
			FileImpl file = new FileImpl(elem);
			assertEquals(new OriginalImpl("orig"), file.getOriginal());
			assertEquals(new SourceLanguageImpl("en-US"), file.getSourceLanguage());
			assertEquals(new DataTypeImpl(DataType.Value.PLAINTEXT), file.getDataType());
			assertEquals(createDefaultBody(), file.getBody());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.removeChild(elem.getFirstChild());
		try {
			new FileImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "header"));
		try {
			new FileImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "body"));
		try {
			FileImpl file = new FileImpl(elem);
			assertEquals(new OriginalImpl("orig"), file.getOriginal());
			assertEquals(new SourceLanguageImpl("en-US"), file.getSourceLanguage());
			assertEquals(new DataTypeImpl(DataType.Value.PLAINTEXT), file.getDataType());
			assertEquals(createDefaultBody(), file.getBody());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		FileImpl file = createDefaultFile();
		ArrayList<Node> expected = new ArrayList<Node>();
		expected.add(createDefaultBody());
		assertEquals(expected, file.getChildren());
		
		file.setHeader(createDefaultHeader());
		expected.add(0, createDefaultHeader());
		assertEquals(expected, file.getChildren());
	}
	
	@Test
	public void testBody() {
		FileImpl file = createDefaultFile();
		
		try {
			file.setBody(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		ArrayList<StructuralUnit> children = new ArrayList<StructuralUnit>();
		children.add(new GroupImpl(new ArrayList<StructuralUnit>()));
		BodyImpl body = new BodyImpl(children);
		file.setBody(body);
		assertEquals(body, file.getBody());
	}
	
	@Test
	public void testBuildNum() {
		FileImpl file = createDefaultFile();
		assertNull(file.getBuildNum());
		
		file.setBuildNum(new BuildNumImpl("1"));
		assertEquals(new BuildNumImpl("1"), file.getBuildNum());
		
		file.setBuildNum(null);
		assertNull(file.getBuildNum());
	}
	
	@Test
	public void testCategory() {
		FileImpl file = createDefaultFile();
		assertNull(file.getCategory());
		
		file.setCategory(new CategoryImpl("categ"));
		assertEquals(new CategoryImpl("categ"), file.getCategory());
		
		file.setCategory(null);
		assertNull(file.getCategory());
	}
	
	@Test
	public void testDataType() {
		FileImpl file = createDefaultFile();

		try {
			file.setDataType(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		file.setDataType(new DataTypeImpl("abc"));
		assertEquals(new DataTypeImpl("abc"), file.getDataType());
	}
	
	@Test
	public void testDate() {
		FileImpl file = createDefaultFile();
		assertNull(file.getDate());

		Date date = DateTime.parseDate("2010-01-01T12:00:00Z");
		file.setDate(new DateImpl(date));
		assertEquals(new DateImpl(date), file.getDate());
		
		file.setDate(null);
		assertNull(file.getDate());
	}
	
	@Test
	public void testHeader() {
		FileImpl file = createDefaultFile();
		assertNull(file.getHeader());
		
		file.setHeader(new HeaderImpl());
		assertEquals(new HeaderImpl(), file.getHeader());
		
		file.setHeader(null);
		assertNull(file.getHeader());
	}
	
	@Test
	public void testNonXliffAttributes() {
		FileImpl file = createDefaultFile();
		Collection<NonXliffAttribute> nonXliffAttributes = file
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		file.setNonXliffAttributes(nxas);

		nonXliffAttributes = file.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		file.setNonXliffAttributes(nxas);

		nonXliffAttributes = file.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		file.setNonXliffAttributes(nxas);
		nonXliffAttributes = file.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}
	
	@Test
	public void testOriginal() {
		FileImpl file = createDefaultFile();

		try {
			file.setOriginal(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		file.setOriginal(new OriginalImpl("abc"));
		assertEquals(new OriginalImpl("abc"), file.getOriginal());
	}
	
	@Test
	public void testProductName() {
		FileImpl file = createDefaultFile();
		assertNull(file.getProductName());
		
		file.setProductName(new ProductNameImpl("abc"));
		assertEquals(new ProductNameImpl("abc"), file.getProductName());
		
		file.setProductName(null);
		assertNull(file.getProductName());
	}
	
	@Test
	public void testProductVersion() {
		FileImpl file = createDefaultFile();
		assertNull(file.getProductVersion());
		
		file.setProductVersion(new ProductVersionImpl("abc"));
		assertEquals(new ProductVersionImpl("abc"), file.getProductVersion());
		
		file.setProductVersion(null);
		assertNull(file.getProductVersion());
	}
	
	@Test
	public void testSourceLanguage() {
		FileImpl file = createDefaultFile();

		try {
			file.setSourceLanguage(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		file.setSourceLanguage(new SourceLanguageImpl("de-DE"));
		assertEquals(new SourceLanguageImpl("de-DE"), file.getSourceLanguage());
	}
	
	@Test
	public void testTargetLanguage() {
		FileImpl file = createDefaultFile();
		assertNull(file.getTargetLanguage());
		
		file.setTargetLanguage(new TargetLanguageImpl("fr-FR"));
		assertEquals(new TargetLanguageImpl("fr-FR"), file.getTargetLanguage());
		
		file.setTargetLanguage(null);
		assertNull(file.getTargetLanguage());
	}
	
	@Test
	public void testTool() {
		FileImpl file = createDefaultFile();
		assertEquals(new ToolImpl("manual"), file.getTool());
		
		file.setTool(new ToolImpl("abc"));
		assertEquals(new ToolImpl("abc"), file.getTool());
		
		file.setTool(null);
		assertEquals(new ToolImpl("manual"), file.getTool());
	}
	
	@Test
	public void testToolId() {
		FileImpl file = createDefaultFile();
		assertNull(file.getToolId());
		
		file.setToolId(new ToolIdImpl("abc"));
		assertEquals(new ToolIdImpl("abc"), file.getToolId());
		
		file.setToolId(null);
		assertNull(file.getToolId());
	}
	
	@Test
	public void testTs() {
		FileImpl file = createDefaultFile();
		assertNull(file.getTs());
		
		file.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), file.getTs());
		
		file.setTs(null);
		assertNull(file.getTs());
	}
	
	@Test
	public void testXmlSpace() {
		FileImpl file = createDefaultFile();
		assertNull(file.getXmlSpace());
		
		file.setXmlSpace(new XmlSpaceImpl(XmlSpace.Value.PRESERVE));
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.PRESERVE), file.getXmlSpace());
		
		file.setXmlSpace(null);
		assertNull(file.getXmlSpace());
	}
	
	@Test
	public void testClone() {
		FileImpl file = createDefaultFile();
		file.setHeader(createDefaultHeader());
		FileImpl clone = (FileImpl) file.clone();
		assertEquals(file, clone);
		assertNotSame(file, clone);
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
	
	private HeaderImpl createDefaultHeader() {
		return new HeaderImpl();
	}

}
