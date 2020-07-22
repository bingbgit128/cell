package com.d3.cell.service;

import java.util.Map;

public interface CacheService {
    public Map<String,Object> getCaches();
    public Map<String,Object> getCache(String key);

    public Map<String,Object> updateCache(String key,Object map);

    public Map<String,Object> deleteCache(String key);

    public void deleteAll();
}
