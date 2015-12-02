package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.DateTime;

public class DateImpl extends XliffAttributeImpl implements Date {

	public DateImpl(java.util.Date date) {
		super(NAME, DateTime.create(date));
		this.date = date;
	}
	
	private java.util.Date date;
	
	public java.util.Date getDate() {
		return date;
	}
}
