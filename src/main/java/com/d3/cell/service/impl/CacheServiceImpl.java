package com.d3.cell.service.impl;

import com.d3.cell.service.CacheService;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    Cache<String, Object> caffeineCache;

    @Override
    public Map<String, Object> getCaches() {
        Map<String, Object> map = new HashMap<>();
        Set<Map.Entry<String, Object>> set = caffeineCache.asMap().entrySet();
        return caffeineCache.asMap();
    }

    @Override
    public Map<String, Object> getCache(String key) {
        Map<String, Object> map = new HashMap<>();
        if(!StringUtils.isEmpty(caffeineCache.getIfPresent(key))) {
            map.put(key,caffeineCache.getIfPresent(key));
        } else {
            map.put(key,false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateCache(String key, Object o) {
        Map<String, Object> map = new HashMap<>();
        try {
            caffeineCache.put(key,o);
            map.put(key,caffeineCache.getIfPresent(key));
        } catch (Exception e) {
            e.printStackTrace();
            map.put(key,false);
        }

        return map;
    }

    @Override
    public Map<String, Object> deleteCache(String key) {
        Map<String, Object> map = new HashMap<>();
        try {
            caffeineCache.asMap().remove(key);
            map.put(key, false);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(key,false);
        }
        return map;
    }

    @Override
    public void deleteAll() {
        caffeineCache.invalidateAll();
    }
}
