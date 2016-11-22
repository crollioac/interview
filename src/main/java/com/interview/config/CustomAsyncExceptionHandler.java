package com.interview.config;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import com.interview.utils.LogUtils;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	private static final LogUtils logger = new LogUtils(CustomAsyncExceptionHandler.class);

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		logger.error("Exception message - " + ex.getMessage() + " Method name - " + method.getName());
		for (Object param : params) {
			logger.error("Parameter value - " + param);
		}
	}

}
