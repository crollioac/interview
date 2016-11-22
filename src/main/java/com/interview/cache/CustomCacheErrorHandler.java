package com.interview.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

import com.interview.utils.LogUtils;

public class CustomCacheErrorHandler implements CacheErrorHandler {

	private static final LogUtils logger = new LogUtils(CustomCacheErrorHandler.class);

	@Override
	public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
		logger.error("Error in handleCachePutError = " + exception);
	}

	@Override
	public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
		logger.error("Error in handleCacheGetError = " + exception);
	}

	@Override
	public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
		logger.error("Error in handleCacheEvictError = " + exception);
	}

	@Override
	public void handleCacheClearError(RuntimeException exception, Cache cache) {
		logger.error("Error in handleCacheClearError = " + exception);
	}

}
