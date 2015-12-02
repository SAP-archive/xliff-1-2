package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommentImplTest {

	@Test
	public void testCommentImpl() {
		CommentImpl attr = new CommentImpl("abc");
		assertEquals("abc", attr.getValue());
	}

}
