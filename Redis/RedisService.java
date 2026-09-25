package com.mft.indexing.DataQuery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public <T> T getValue(String key, Class<T> clazz) {

        try{
        Object value = redisTemplate.opsForValue().get(key);
        if (value != null ) {
            String jsonString  =  value.toString();
            return objectMapper.readValue(jsonString, clazz);

        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setValue(String key, Object value,Long timeoutInSeconds) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonObject = objectMapper.writeValueAsString(value); // Serialize the object to JSON
        redisTemplate.opsForValue().set(key, jsonObject,timeoutInSeconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
