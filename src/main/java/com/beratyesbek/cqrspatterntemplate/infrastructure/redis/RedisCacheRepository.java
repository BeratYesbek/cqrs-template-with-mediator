package com.beratyesbek.cqrspatterntemplate.infrastructure.redis;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class RedisCacheRepository {
	private HashOperations<String, String, Object> hashOperations;
	private final RedisTemplate<String, Object> redisTemplate;

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	public void save(String key, String hashKey, Object cacheData, Long ttl) {
		hashOperations.put(key, hashKey, cacheData);
		if (ttl != null) {
			redisTemplate.expire(key, ttl, TimeUnit.MINUTES);
		}
	}

	public List<Object> findAll(String key) {
		return hashOperations.values(key);
	}

	public Optional<Object> findByHashKey(String key, String hashKey) {
		return Optional.ofNullable(hashOperations.get(key, hashKey));
	}

	public void delete(String key, String hashKey) {
		hashOperations.delete(key, hashKey);
	}

	public void deleteAllKeysWithPrefix(String keyPrefix) {
		List<String> otpCountKeys = findKeysByPattern(keyPrefix);
		for (String otpCountKey : otpCountKeys) {
			redisTemplate.delete(otpCountKey);
		}
	}

	public void saveAsPair(String key, Object value, Long ttl) {
		redisTemplate.opsForValue().set(key, value);
		if (ttl != null) {
			redisTemplate.expire(key, ttl, TimeUnit.MINUTES);
		}
	}

	private List<String> findKeysByPattern(String pattern) {
		return Objects.requireNonNull(redisTemplate.keys(pattern)).stream().toList();
	}
}
