package com.sap.mlt.xliff12.impl.text;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.sap.mlt.xliff12.test.util.Utils;

public class TextImplTest {

	@Test
	public void testHashCode() {
		TextImpl text1 = new TextImpl("abc");
		TextImpl text2 = new TextImpl("abc");
		assertEquals(new Integer(text1.hashCode()), new Integer(text2
				.hashCode()));
	}

	@Test
	public void testTextImpl() {
		new TextImpl("a");
		new TextImpl("");
		try {
			new TextImpl(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			new TextImpl("te\fxt\f");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetText() {
		TextImpl text = new TextImpl("abc");
		assertEquals("abc", text.getText());
	}

	@Test
	public void testGetPlainText() {
		TextImpl text = new TextImpl("abc");
		assertEquals("abc", text.getPlainText());
	}

	@Test
	public void testAsXmlNode() {
		TextImpl text = new TextImpl("abc");
		Node node = text.asXmlNode(Utils.createDocument());
		assertTrue(node instanceof Text);
		assertEquals("abc", node.getTextContent());
	}

	@Test
	public void testEqualsObject() {
		TextImpl text1 = new TextImpl("abc");
		TextImpl text2 = new TextImpl("abc");
		TextImpl text3 = new TextImpl("abcd");
		assertEquals(text1, text1);
		assertEquals(text1, text2);
		assertFalse(text1.equals(text3));
		assertFalse(text1.equals("abc"));
		assertFalse(text1.equals(null));
	}

	@Test
	public void testToString() {
		TextImpl text = new TextImpl("abc");
		assertEquals("abc", text.toString());
	}

}
