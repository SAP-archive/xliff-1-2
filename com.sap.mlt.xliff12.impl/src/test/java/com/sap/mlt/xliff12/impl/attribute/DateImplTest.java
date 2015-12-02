package com.sap.mlt.xliff12.impl.attribute;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class DateImplTest {

	@Test
	public void testDateImpl() {
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		calendar.set(2010, 5, 4, 23, 12, 34);
		DateImpl attr = new DateImpl(calendar.getTime());
		assertEquals(calendar.getTime(), attr.getDate());
	}

}
