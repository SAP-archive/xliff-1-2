package com.sap.mlt.xliff12.impl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateTime {

	private static final SimpleDateFormat DT_FORMAT;

	static {
		DT_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		DT_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	public static String create(Date date) {
		Assert.notNull(date, "date");
		synchronized (DT_FORMAT) {
			return DT_FORMAT.format(date);
		}
	}

	public static Date parseDate(String s) throws IllegalArgumentException {
		DateTime instance = new DateTime();
		int[] date = instance.parse(s);
		GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		cal.set(date[0], date[1]-1, date[2], date[3], date[4], date[5]);
		cal.set(Calendar.MILLISECOND, date[6]);
		return cal.getTime();
	}

	private DateTime() {
	}

	// define constants
	private final static int CY = 0, M = 1, D = 2, h = 3, m = 4, s = 5, ms = 6,
			utc = 7, hh = 0, mm = 1;

	// size for all objects must have the same fields:
	// CCYY, MM, DD, h, m, s, ms + timeZone
	private final static int TOTAL_SIZE = 8;

	/**
	 * Parses, validates and computes normalized version of dateTime object
	 * 
	 * @param str
	 *            The lexical representation of dateTime object
	 *            CCYY-MM-DDThh:mm:ss.sss with possible time zone Z or
	 *            (-),(+)hh:mm
	 * @param date
	 *            uninitialized date object
	 * @return normalized dateTime representation
	 */
	private int[] parse(String str) throws IllegalArgumentException {
		try {
			int len = str.length();
			int[] date = new int[TOTAL_SIZE];
			int[] timeZone = new int[2];

			int end = indexOf(str, 0, len, 'T');

			// both time and date
			getDate(str, 0, end, date);
			getTime(str, end + 1, len, date, timeZone);

			// validate and normalize

			// REVISIT: do we need SchemaDateTimeException?
			validateDateTime(date, timeZone);

			if (date[utc] != 0 && date[utc] != 'Z') {
				normalize(date, timeZone);
			}
			return date;
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Parses time hh:mm:ss.sss and time zone if any
	 * 
	 * @param start
	 * @param end
	 * @param data
	 * @exception RuntimeException
	 */
	private void getTime(String buffer, int start, int end, int[] data,
			int[] timeZone) throws RuntimeException {

		int stop = start + 2;

		// get hours (hh)
		data[h] = parseInt(buffer, start, stop);

		// get minutes (mm)

		if (buffer.charAt(stop++) != ':') {
			throw new IllegalArgumentException("Error in parsing time zone");
		}
		start = stop;
		stop = stop + 2;
		data[m] = parseInt(buffer, start, stop);

		// get seconds (ss)
		if (buffer.charAt(stop++) != ':') {
			throw new IllegalArgumentException("Error in parsing time zone");
		}
		start = stop;
		stop = stop + 2;
		data[s] = parseInt(buffer, start, stop);

		if (stop == end)
			return;

		// get miliseconds (ms)
		start = stop;
		int milisec = buffer.charAt(start) == '.' ? start : -1;

		// find UTC sign if any
		int sign = findUTCSign(buffer, start, end);

		// parse miliseconds
		if (milisec != -1) {
			// The end of millisecond part is between . and
			// either the end of the UTC sign
			start = sign < 0 ? end : sign;
			data[ms] = parseInt(buffer, milisec + 1, start);
		}

		// parse UTC time zone (hh:mm)
		if (sign > 0) {
			if (start != sign)
				throw new IllegalArgumentException("Error in parsing time zone");
			getTimeZone(buffer, data, sign, end, timeZone);
		} else if (start != end) {
			throw new IllegalArgumentException("Error in parsing time zone");
		}
	}

	/**
	 * Parses date CCYY-MM-DD
	 * 
	 * @param start
	 * @param end
	 * @param data
	 * @exception RuntimeException
	 */
	private int getDate(String buffer, int start, int end, int[] date)
			throws RuntimeException {

		start = getYearMonth(buffer, start, end, date);

		if (buffer.charAt(start++) != '-') {
			throw new IllegalArgumentException("CCYY-MM must be followed by '-' sign");
		}
		int stop = start + 2;
		date[D] = parseInt(buffer, start, stop);
		return stop;
	}

	/**
	 * Parses date CCYY-MM
	 * 
	 * @param start
	 * @param end
	 * @param data
	 * @exception RuntimeException
	 */
	private int getYearMonth(String buffer, int start, int end, int[] date)
			throws RuntimeException {

		if (buffer.charAt(0) == '-') {
			// REVISIT: date starts with preceding '-' sign
			// do we have to do anything with it?
			//
			start++;
		}
		int i = indexOf(buffer, start, end, '-');
		if (i == -1)
			throw new IllegalArgumentException("Year separator is missing or misplaced");
		int length = i - start;
		if (length < 4) {
			throw new IllegalArgumentException("Year must have 'CCYY' format");
		} else if (length > 4 && buffer.charAt(start) == '0') {
			throw new IllegalArgumentException(
			        "Leading zeros are required if the year value would otherwise have fewer than four digits;"
			                + " otherwise they are forbidden");
		}
		date[CY] = parseIntYear(buffer, i);
		if (buffer.charAt(i) != '-') {
			throw new IllegalArgumentException("CCYY must be followed by '-' sign");
		}
		start = ++i;
		i = start + 2;
		date[M] = parseInt(buffer, start, i);
		return i; // fStart points right after the MONTH
	}

	/**
	 * Parses time zone: 'Z' or {+,-} followed by hh:mm
	 * 
	 * @param data
	 * @param sign
	 * @exception RuntimeException
	 */
	private void getTimeZone(String buffer, int[] data, int sign, int end,
			int[] timeZone) throws RuntimeException {
		data[utc] = buffer.charAt(sign);

		if (buffer.charAt(sign) == 'Z') {
			if (end > (++sign)) {
				throw new IllegalArgumentException("Error in parsing time zone");
			}
			return;
		}
		if (sign <= (end - 6)) {

			// parse [hh]
			int stop = ++sign + 2;
			timeZone[hh] = parseInt(buffer, sign, stop);
			if (buffer.charAt(stop++) != ':') {
				throw new IllegalArgumentException("Error in parsing time zone");
			}

			// parse [ss]
			timeZone[mm] = parseInt(buffer, stop, stop + 2);

			if (stop + 2 != end) {
				throw new IllegalArgumentException("Error in parsing time zone");
			}

		} else {
			throw new IllegalArgumentException("Error in parsing time zone");
		}
	}

	/**
	 * Computes index of given char within StringBuffer
	 * 
	 * @param start
	 * @param end
	 * @param ch
	 *            character to look for in StringBuffer
	 * @return index of ch within StringBuffer
	 */
	private int indexOf(String buffer, int start, int end, char ch) {
		for (int i = start; i < end; i++) {
			if (buffer.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Validates given date/time object accoring to W3C PR Schema [D.1 ISO 8601
	 * Conventions]
	 * 
	 * @param data
	 */
	private void validateDateTime(int[] data, int[] timeZone) {

		// REVISIT: should we throw an exception for not valid dates
		// or reporting an error message should be sufficient?
		if (data[CY] == 0) {
			throw new IllegalArgumentException(
					"The year \"0000\" is an illegal year value");

		}

		if (data[M] < 1 || data[M] > 12) {
			throw new IllegalArgumentException("The month must have values 1 to 12");

		}

		// validate days
		if (data[D] > maxDayInMonthFor(data[CY], data[M]) || data[D] < 1) {
			throw new IllegalArgumentException("The day must have values 1 to 31");
		}

		// validate hours
		if (data[h] > 23 || data[h] < 0) {
			if (data[h] == 24 && data[m] == 0 && data[s] == 0 && data[ms] == 0) {
				data[h] = 0;
				if (++data[D] > maxDayInMonthFor(data[CY], data[M])) {
					data[D] = 1;
					if (++data[M] > 12) {
						data[M] = 1;
						if (++data[CY] == 0)
							data[CY] = 1;
					}
				}
			} else {
				throw new IllegalArgumentException(
						"Hour must have values 0-23, unless 24:00:00");
			}
		}

		// validate
		if (data[m] > 59 || data[m] < 0) {
			throw new IllegalArgumentException("Minute must have values 0-59");
		}

		// validate
		if (data[s] > 60 || data[s] < 0) {
			throw new IllegalArgumentException("Second must have values 0-60");

		}

		// validate
		if (timeZone[hh] > 14 || timeZone[hh] < -14) {
			throw new IllegalArgumentException("Time zone should have range -14..+14");
		}

		// validate
		if (timeZone[mm] > 59 || timeZone[mm] < -59) {
			throw new IllegalArgumentException("Minute must have values 0-59");
		}
	}

	/**
	 * Return index of UTC char: 'Z', '+', '-'
	 * 
	 * @param start
	 * @param end
	 * @return index of the UTC character that was found
	 */
	private int findUTCSign(String buffer, int start, int end) {
		int c;
		for (int i = start; i < end; i++) {
			c = buffer.charAt(i);
			if (c == 'Z' || c == '+' || c == '-') {
				return i;
			}

		}
		return -1;
	}

	/**
	 * Given start and end position, parses string value
	 * 
	 * @param value
	 *            string to parse
	 * @param start
	 *            Start position
	 * @param end
	 *            end position
	 * @return return integer representation of characters
	 */
	private int parseInt(String buffer, int start, int end)
			throws NumberFormatException {
		// REVISIT: more testing on this parsing needs to be done.
		int radix = 10;
		int result = 0;
		int digit = 0;
		int limit = -Integer.MAX_VALUE;
		int multmin = limit / radix;
		int i = start;
		do {
			digit = getDigit(buffer.charAt(i));
			if (digit < 0)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			if (result < multmin)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			result *= radix;
			if (result < limit + digit)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			result -= digit;

		} while (++i < end);
		return -result;
	}

	// parse Year differently to support negative value.
	private int parseIntYear(String buffer, int end) {
		int radix = 10;
		int result = 0;
		boolean negative = false;
		int i = 0;
		int limit;
		int multmin;
		int digit = 0;

		if (buffer.charAt(0) == '-') {
			negative = true;
			limit = Integer.MIN_VALUE;
			i++;

		} else {
			limit = -Integer.MAX_VALUE;
		}
		multmin = limit / radix;
		while (i < end) {
			digit = getDigit(buffer.charAt(i++));
			if (digit < 0)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			if (result < multmin)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			result *= radix;
			if (result < limit + digit)
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
			result -= digit;
		}

		if (negative) {
			if (i > 1)
				return result;
			else
				throw new NumberFormatException("'" + buffer.toString()
						+ "' has wrong format");
		}
		return -result;

	}

	/**
	 * If timezone present - normalize dateTime [E Adding durations to
	 * dateTimes]
	 * 
	 * @param date
	 *            CCYY-MM-DDThh:mm:ss+03
	 * @return CCYY-MM-DDThh:mm:ssZ
	 */
	private void normalize(int[] date, int[] timeZone) {

		// REVISIT: we have common code in addDuration() for durations
		// should consider reorganizing it.
		//

		// add minutes (from time zone)
		int negate = 1;
		if (date[utc] == '+') {
			negate = -1;
		}
		int temp = date[m] + negate * timeZone[mm];
		int carry = fQuotient(temp, 60);
		date[m] = mod(temp, 60, carry);

		// add hours
		temp = date[h] + negate * timeZone[hh] + carry;
		carry = fQuotient(temp, 24);
		date[h] = mod(temp, 24, carry);

		date[D] = date[D] + carry;

		while (true) {
			temp = maxDayInMonthFor(date[CY], date[M]);
			if (date[D] < 1) {
				date[D] = date[D] + maxDayInMonthFor(date[CY], date[M] - 1);
				carry = -1;
			} else if (date[D] > temp) {
				date[D] = date[D] - temp;
				carry = 1;
			} else {
				break;
			}
			temp = date[M] + carry;
			date[M] = modulo(temp, 1, 13);
			date[CY] = date[CY] + fQuotient(temp, 1, 13);
		}
		date[utc] = 'Z';
	}

	/**
	 * Given {year,month} computes maximum number of days for given month
	 * 
	 * @param year
	 * @param month
	 * @return integer containg the number of days in a given month
	 */
	private int maxDayInMonthFor(int year, int month) {
		// validate days
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 31;
		}
	}

	private boolean isLeapYear(int year) {

		// REVISIT: should we take care about Julian calendar?
		return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
	}

	//
	// help function described in W3C PR Schema [E Adding durations to
	// dateTimes]
	//
	private int mod(int a, int b, int quotient) {
		// modulo(a, b) = a - fQuotient(a,b)*b
		return (a - quotient * b);
	}

	//
	// help function described in W3C PR Schema [E Adding durations to
	// dateTimes]
	//
	private int fQuotient(int a, int b) {

		// fQuotient(a, b) = the greatest integer less than or equal to a/b
		return (int) Math.floor((float) a / b);
	}

	//
	// help function described in W3C PR Schema [E Adding durations to
	// dateTimes]
	//
	private int modulo(int temp, int low, int high) {
		// modulo(a - low, high - low) + low
		int a = temp - low;
		int b = high - low;
		return (mod(a, b, fQuotient(a, b)) + low);
	}

	//
	// help function described in W3C PR Schema [E Adding durations to
	// dateTimes]
	//
	private int fQuotient(int temp, int low, int high) {
		// fQuotient(a - low, high - low)

		return fQuotient(temp - low, high - low);
	}

	// if the character is in the range 0x30 ~ 0x39, return its int value (0~9),
	// otherwise, return -1
	private static final int getDigit(char ch) {
		return isDigit(ch) ? ch - '0' : -1;
	}

	// check whether the character is in the range 0x30 ~ 0x39
	private static final boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
}
