package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Comment;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CommentImpl extends XliffAttributeImpl implements Comment {

	public CommentImpl(String comment) {
		super(NAME, comment);
	}
	
}
