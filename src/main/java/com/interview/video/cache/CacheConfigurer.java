package com.interview.video.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
@EnableCaching
public class CacheConfigurer extends CachingConfigurerSupport {

//	@Value("${redis.host}")
	private String host;

//	@Value("${redis.port}")
	private Integer port;

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

		// Defaults
		redisConnectionFactory.setHostName(host);
		redisConnectionFactory.setPort(port);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(cf);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// Number of seconds before expiration per cache
		Map<String, Long> cacheExpiryMap = new HashMap<>();
		cacheExpiryMap.put(CacheName.DELIVERY_DATES_CACHE, 300l);
		cacheManager.setExpires(cacheExpiryMap);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(0);

		return cacheManager;
	}

	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		return new CustomCacheErrorHandler();
	}

}
