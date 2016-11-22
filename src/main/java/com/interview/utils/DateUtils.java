package com.interview.utils;

import static com.interview.utils.GenericUtils.getStackTrace;
import static com.interview.utils.GenericUtils.isEmpty;
import static com.interview.utils.GenericUtils.notEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {

	private static final LogUtils logger = new LogUtils(DateUtils.class);

	private DateUtils() {
		super();
	}

	public static String getCurrentTime(String timeFormat, String timeZone) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		LocalDateTime now;
		if (notEmpty(timeZone)) {
			now = LocalDateTime.now(ZoneId.of(timeZone));
		} else {
			now = LocalDateTime.now();
		}
		return now.format(formatter);
	}

	public static String getTime(String timeFormat, String timeZone, int days) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
		LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone)).plusDays(days);
		return now.format(formatter);
	}

	public static boolean isTimeZoneValid(String timeZone) {
		boolean isValid = false;
		try {
			ZoneId.of(timeZone);
			isValid = true;
		} catch (Exception ex) {
			logger.error("Not a valid timeZone. TimeZone = " + timeZone + ". Exception = " + getStackTrace(ex));
		}
		return isValid;
	}

	public static boolean isWithinGivenDays(String date, int givenDays, String dateFormat, String timeZone) {
		boolean isWithin = false;

		LocalDate now = LocalDate.now(ZoneId.of(timeZone));
		LocalDate givenDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));

		long daysBetween = ChronoUnit.DAYS.between(now, givenDate);

		if (daysBetween <= givenDays) {
			isWithin = true;
		}

		return isWithin;
	}

	public static Long daysFromNow(String date, String dateFormat, String timeZone) {

		if (isEmpty(date)) {
			return null;
		}

		LocalDate now = LocalDate.now(ZoneId.of(timeZone));
		LocalDate givenDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));

		return ChronoUnit.DAYS.between(now, givenDate);
	}

}
