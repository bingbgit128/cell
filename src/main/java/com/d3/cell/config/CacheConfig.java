package com.d3.cell.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<String,Object> caffeineCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(30, TimeUnit.DAYS)
                .initialCapacity(100)
                .maximumSize(3000)
                .build();
    }

}
