package com.interview.video.cache;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public interface CacheService<K, V> {

	Set<K> getAllKeys();

	Set<K> getKeys(String pattern);

	V get(K key);

	boolean deleteKey(K key);

	Map<K, Boolean> deleteKeys(Set<K> keys);
	
	Map<K, Boolean> deleteKeys(String pattern);

	String flushAll();

}
