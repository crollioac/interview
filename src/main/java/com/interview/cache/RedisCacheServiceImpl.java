package com.interview.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
@Qualifier("redisCacheService")
public class RedisCacheServiceImpl implements CacheService<String, Object> {

//	@Value("${redis.host}")
	private String host;

//	@Value("${redis.port}")
	private Integer port;

	@Override
	public Set<String> getAllKeys() {

		Jedis jedis = new Jedis(host, port);
		Set<String> keys = jedis.keys("*");
		jedis.close();
		return keys;
	}

	@Override
	public Set<String> getKeys(String pattern) {
		Jedis jedis = new Jedis(host, port);
		Set<String> keys = jedis.keys(pattern);
		jedis.close();
		return keys;
	}

	@Override
	public String get(String key) {
		Jedis jedis = new Jedis(host, port);
		String value = jedis.get(key);
		jedis.close();
		return value;
	}

	@Override
	public boolean deleteKey(String key) {

		boolean isDeleted = false;
		Jedis jedis = new Jedis(host, port);
		Long value = jedis.del(key);
		jedis.close();
		if (value.longValue() == 1l) {
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Map<String, Boolean> deleteKeys(Set<String> keys) {
		Map<String, Boolean> resultMap = new HashMap<>();
		Jedis jedis = new Jedis(host, port);
		Long value;
		for (String key : keys) {
			value = jedis.del(key);
			if (value.longValue() == 1l) {
				resultMap.put(key, true);
			} else {
				resultMap.put(key, false);
			}
		}
		jedis.close();
		return resultMap;
	}

	@Override
	public String flushAll() {
		Jedis jedis = new Jedis(host, port);
		String value = jedis.flushAll();
		jedis.close();
		return value;
	}

	@Override
	public Map<String, Boolean> deleteKeys(String pattern) {

		Set<String> keysToBeDeleted = getKeys(pattern);
		return deleteKeys(keysToBeDeleted);

	}

}
