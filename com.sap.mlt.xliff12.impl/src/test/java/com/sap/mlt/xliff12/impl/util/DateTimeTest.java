package com.sap.mlt.xliff12.impl.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class DateTimeTest {

	@Test
	public void testCreate() {
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		calendar.set(2010, 5, 4, 23, 12, 34);
		String isoDateTime = DateTime.create(calendar.getTime());
		assertEquals("2010-06-04T23:12:34Z", isoDateTime);
	}

	@Test
	public void testParseDate() {
		Date date = DateTime.parseDate("2010-06-04T23:12:34Z");
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		calendar.setTime(date);
		assertEquals(new Integer(2010), new Integer(calendar.get(Calendar.YEAR)));
		assertEquals(new Integer(5), new Integer(calendar.get(Calendar.MONTH)));
		assertEquals(new Integer(4), new Integer(calendar.get(Calendar.DAY_OF_MONTH)));
		assertEquals(new Integer(23), new Integer(calendar.get(Calendar.HOUR_OF_DAY)));
		assertEquals(new Integer(12), new Integer(calendar.get(Calendar.MINUTE)));
		assertEquals(new Integer(34), new Integer(calendar.get(Calendar.SECOND)));
		
		date = DateTime.parseDate("2012-02-29T24:00:00.000+02:00");
		calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		calendar.setTime(date);
		assertEquals(new Integer(2012), new Integer(calendar.get(Calendar.YEAR)));
		assertEquals(new Integer(1), new Integer(calendar.get(Calendar.MONTH)));
		assertEquals(new Integer(29), new Integer(calendar.get(Calendar.DAY_OF_MONTH)));
		assertEquals(new Integer(22), new Integer(calendar.get(Calendar.HOUR_OF_DAY)));
		assertEquals(new Integer(0), new Integer(calendar.get(Calendar.MINUTE)));
		assertEquals(new Integer(0), new Integer(calendar.get(Calendar.SECOND)));
		
		date = DateTime.parseDate("2012-12-31T24:00:00.000+02:00");
		calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		calendar.setTime(date);
		assertEquals(new Integer(2012), new Integer(calendar.get(Calendar.YEAR)));
		assertEquals(new Integer(11), new Integer(calendar.get(Calendar.MONTH)));
		assertEquals(new Integer(31), new Integer(calendar.get(Calendar.DAY_OF_MONTH)));
		assertEquals(new Integer(22), new Integer(calendar.get(Calendar.HOUR_OF_DAY)));
		assertEquals(new Integer(0), new Integer(calendar.get(Calendar.MINUTE)));
		assertEquals(new Integer(0), new Integer(calendar.get(Calendar.SECOND)));

		try {
			DateTime.parseDate("2010-06-04T221:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010-06-04T22:121:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010-06-04T22:12:34");
		} catch (IllegalArgumentException e) {
			//$JL-EXC$
			fail("Did not expect IllegalArgumentException");
		}
		try {
			DateTime.parseDate("-2010-06-04T22:12:34Z");
		} catch (IllegalArgumentException e) {
			//$JL-EXC$
			fail("Did not expect IllegalArgumentException");
		}
		try {
			DateTime.parseDate("2010-06-04T22:12:34Z4");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010-06-04T22:12:34-5:00");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010-06-04T22:12:34k");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010-0604T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2010");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("104-06-04T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("02104-06-04T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2104-06-04T22:12:34+121:00");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("2104-06-04T22:12:34+12:001");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0000-06-04T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-13-04T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-32T22:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-31T25:12:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-31T21:62:34Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-31T21:52:74Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-31T21:52:14+15:00");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("0001-12-31T21:52:14+05:62");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("1w23-12-31T21:52:14Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("1023-a2-31T21:52:14Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		try {
			DateTime.parseDate("4000000000-12-31T21:52:14Z");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

}
