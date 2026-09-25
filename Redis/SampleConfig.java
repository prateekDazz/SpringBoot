package com.mft.indexing.DataQuery.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleConfig {
@Autowired
    private RedisTemplate redisTemplate;

@PostConstruct
    public void init() {
        System.out.println("Redis configuration initialized.");
        redisTemplate.opsForValue().set("testKey", "testValue");
    System.out.println("Value for 'testKey' in Redis: " + redisTemplate.opsForValue().get("testKey"));
    System.out.println("Value for 'name' in Redis: " + redisTemplate.opsForValue().get("name"));
//    get name
        // You can add any additional initialization logic here if needed
    }

}
