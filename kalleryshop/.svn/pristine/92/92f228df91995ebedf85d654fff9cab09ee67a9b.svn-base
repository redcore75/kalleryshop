package kr.co.redcore.handler;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class TokenHandler {
	@Autowired
	private CacheManager cacheManager;

	public String generate() {
		Cache cache = cacheManager.getCache("tokens");
		String token = UUID.randomUUID().toString();
		cache.put(token, token);
		
		return token;
	}
}
