package com.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, ItemDto> itemRedisTemplate(
            RedisConnectionFactory connectionFactory
    ) {
        RedisTemplate<String, ItemDto> template = new RedisTemplate<>();  // 1
        template.setConnectionFactory(connectionFactory);                 // 2
        template.setKeySerializer(RedisSerializer.string());              // 3-a
        template.setValueSerializer(RedisSerializer.json());              // 3-b
        return template;                                                  // 4
    }
}
