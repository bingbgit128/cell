package com.d3.cell.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Value("${zdy.cache.initialCapacity}")
    private Integer initialCapacity;
    @Value("${zdy.cache.time}")
    private Integer time;
    @Value("${zdy.cache.maximumSize}")
    private Integer maximumSize;
    @Bean
    public Cache<String,Object> caffeineCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(time, TimeUnit.DAYS)
                .initialCapacity(initialCapacity)
                .maximumSize(maximumSize)
                .build();
    }

}
