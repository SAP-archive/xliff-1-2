package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class BinSourceImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBinSourceImplChild() {
		BinSourceImpl bs = createDefaultBinSource();
		assertEquals(createDefaultInternalFile(), bs.getChild());
	}

	@Test
	public void testBinSourceImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-source");
		try {
			new BinSourceImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultExternalFile().asXmlNode(doc));
		try {
			BinSourceImpl ref = new BinSourceImpl(elem);
			assertEquals(createDefaultExternalFile(), ref.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		try {
			BinSourceImpl ref = new BinSourceImpl(elem);
			assertEquals(createDefaultInternalFile(), ref.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new BinSourceImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		BinSourceImpl bs = createDefaultBinSource();
		assertEquals(createDefaultInternalFile(), bs.getChildren().get(0));
	}

	@Test
	public void testChild() {
		BinSourceImpl bs = createDefaultBinSource();

		try {
			bs.setChild(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		bs.setChild(new InternalFileImpl(new TextImpl("abc")));
		assertEquals(new InternalFileImpl(new TextImpl("abc")), bs.getChild());

		bs.setChild(new ExternalFileImpl(new HrefImpl("http://www.sap.com")));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com")),
				bs.getChild());
	}

	@Test
	public void testNonXliffAttributes() {
		BinSourceImpl bs = createDefaultBinSource();
		Collection<NonXliffAttribute> nonXliffAttributes = bs
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		bs.setNonXliffAttributes(nxas);

		nonXliffAttributes = bs.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		bs.setNonXliffAttributes(nxas);

		nonXliffAttributes = bs.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		bs.setNonXliffAttributes(nxas);
		nonXliffAttributes = bs.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testTs() {
		BinSourceImpl bs = createDefaultBinSource();
		bs.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), bs.getTs());
		bs.setTs(null);
		assertNull(bs.getTs());
	}
	
	@Test
	public void testClone() {
		BinSourceImpl binSourceTrans = createDefaultBinSource();
		BinSourceImpl clone = (BinSourceImpl) binSourceTrans.clone();
		assertEquals(binSourceTrans, clone);
		assertNotSame(binSourceTrans, clone);
	}	

	private BinSourceImpl createDefaultBinSource() {
		return new BinSourceImpl(createDefaultInternalFile());
	}

	private InternalFileImpl createDefaultInternalFile() {
		return new InternalFileImpl(new TextImpl("intf"));
	}

	private ExternalFileImpl createDefaultExternalFile() {
		return new ExternalFileImpl(new HrefImpl("http://sap.com"));
	}

}
