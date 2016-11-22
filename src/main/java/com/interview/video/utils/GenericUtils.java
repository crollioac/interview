package com.interview.video.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public class GenericUtils {

	private GenericUtils() {
		super();
	}

	public static String getStackTrace(Throwable ex) {
		StringWriter sw = new StringWriter(1024);
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		pw.flush();
		return sw.toString();
	}

	public static String toString(Object obj) {
		return (obj == null) ? null : obj.toString();
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	public static boolean notEmpty(String str) {
		return str != null && !str.trim().isEmpty();
	}

	public static boolean notEmpty(List<?> list) {
		return list != null && !list.isEmpty();
	}

	public static List<String> getListOfStrings(List<Object> objList) {
		if (objList != null) {
			List<String> strList = new ArrayList<>(objList.size());
			for (Object object : objList) {
				strList.add(Objects.toString(object, null));
			}
			return strList;
		} else {
			return null;
		}
	}

	public static <T> T getNonNullValue(T field, T defaultValue) {
		if (field == null) {
			return defaultValue;
		}
		return field;
	}

	public static String getRequestParameter(HttpServletRequest request, String key, String defaultValue) {
		String value = request.getParameter(key);
		if (value == null || value == "null") {
			return defaultValue;
		}
		return value;
	}

}
