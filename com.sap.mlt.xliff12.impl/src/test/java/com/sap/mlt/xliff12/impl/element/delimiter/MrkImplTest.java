package com.sap.mlt.xliff12.impl.element.delimiter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Mtype;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.attribute.CommentImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MidImpl;
import com.sap.mlt.xliff12.impl.attribute.MtypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class MrkImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testMrkImplMtypeListOfQextendsTextFragment() {
		Mtype mtype = new MtypeImpl(Mtype.Value.NAME);
		ArrayList<TextFragment> fragments = new ArrayList<TextFragment>();
		fragments.add(new TextImpl("test"));
		MrkImpl mrk = new MrkImpl(mtype, fragments);

		assertEquals(Mtype.Value.NAME, mrk.getMtype().getEnumValue());
		List<? extends TextFragment> content = mrk.getContent();
		assertEquals(new Integer(1), new Integer(content.size()));
		assertEquals("test", ((Text)content.get(0)).getText());
	}

	@Test
	public void testMrkImplElement() {
		Document doc = Utils.createDocument();
		Element element = doc.createElementNS(XLIFF_12_NAMESPACE, "mrk");
		element.setAttributeNS(null, "mtype", "name");
		element.setTextContent("test");
		try {
			MrkImpl mrk = new MrkImpl(element);
			assertEquals(Mtype.Value.NAME, mrk.getMtype().getEnumValue());
			List<? extends TextFragment> content = mrk.getContent();
			assertEquals(new Integer(1), new Integer(content.size()));
			assertEquals("test", ((Text)content.get(0)).getText());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}
	
	@Test
	public void testGetChildren() {
		MrkImpl mrk = createDefaultMrk();
		List<? extends Node> children = mrk.getChildren();
		assertEquals(new Integer(1), new Integer(children.size()));
		assertEquals("test", ((Text) children.get(0)).getText());
	}
	
	@Test
	public void testComment() {
		MrkImpl mrk = createDefaultMrk();
		assertNull(mrk.getComment());
		mrk.setComment(new CommentImpl("comment"));
		assertEquals(new CommentImpl("comment"), mrk.getComment());
		mrk.setComment(null);
		assertNull(mrk.getComment());
	}
	
	@Test
	public void testContent() {
		MrkImpl mrk = createDefaultMrk();
		List<? extends TextFragment> content = mrk.getContent();
		assertEquals(new Integer(1), new Integer(content.size()));
		assertEquals("test", ((Text)content.get(0)).getText());
		
		ArrayList<TextFragment> newContent = new ArrayList<TextFragment>();
		newContent.add(new TextImpl("Hello "));
		newContent.add(new XImpl(new IdImpl("1")));
		mrk.setContent(newContent);
		content = mrk.getContent();
		assertEquals(new Integer(2), new Integer(content.size()));
		assertEquals("Hello ", ((Text)content.get(0)).getText());
		assertEquals(new XImpl(new IdImpl("1")), content.get(1));		
	}
	
	@Test
	public void testMid() {
		MrkImpl mrk = createDefaultMrk();
		assertNull(mrk.getMid());
		
		mrk.setMid(new MidImpl("1"));
		assertEquals(new MidImpl("1"), mrk.getMid());
		
		mrk.setMid(null);
		assertNull(mrk.getMid());
	}
	
	@Test
	public void testMtype() {
		MrkImpl mrk = createDefaultMrk();
		assertEquals(new MtypeImpl(Mtype.Value.NAME), mrk.getMtype());
		
		try {
			mrk.setMtype(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		
		mrk.setMtype(new MtypeImpl("1"));
		assertEquals(new MtypeImpl("1"), mrk.getMtype());
	}
	
	@Test
	public void testNonXliffAttributes() {
		MrkImpl mrk = createDefaultMrk();
		Collection<NonXliffAttribute> nonXliffAttributes = mrk.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
		
		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		mrk.setNonXliffAttributes(nxas);
		
		nonXliffAttributes = mrk.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns", "pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns", "pre", "name2", "value2")));
		
		nxas.clear();		
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		mrk.setNonXliffAttributes(nxas);
		
		nonXliffAttributes = mrk.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns", "pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2")));
		
		nxas.clear();
		mrk.setNonXliffAttributes(nxas);
		nonXliffAttributes = mrk.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}
	
	@Test
	public void testTs() {
		MrkImpl mrk = createDefaultMrk();
		assertNull(mrk.getTs());
		
		mrk.setTs(new TsImpl("1"));
		assertEquals(new TsImpl("1"), mrk.getTs());
		
		mrk.setTs(null);
		assertNull(mrk.getTs());
	}
	
	@Test
	public void testPlainText() {
		MrkImpl mrk = createDefaultMrk();
		assertEquals("test", mrk.getPlainText());
	}
	
	@Test
	public void testClone() {
		MrkImpl mrk = createDefaultMrk();
		MrkImpl clone = (MrkImpl) mrk.clone();
		assertEquals(mrk, clone);
		assertNotSame(mrk, clone);
	}
	
	private MrkImpl createDefaultMrk() {
		Mtype mtype = new MtypeImpl(Mtype.Value.NAME);
		ArrayList<TextFragment> fragments = new ArrayList<TextFragment>();
		fragments.add(new TextImpl("test"));
		MrkImpl mrk = new MrkImpl(mtype, fragments);
		return mrk;
	}

}
