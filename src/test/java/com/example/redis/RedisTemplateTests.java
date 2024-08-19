package com.example.redis;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTemplateTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringOpsTest() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("simplekey", "simplevalue");
        System.out.println(ops.get("simplekey"));
        ops.set("greeting", "hello redis!");
        System.out.println(ops.get("greeting"));
    }

    @Test
    public void stringSetOpsTest() {
        SetOperations<String, String> setOps = stringRedisTemplate.opsForSet();
        setOps.add("hobbies", "games");
        setOps.add("hobbies", "coding");
        setOps.add("hobbies", "alcohol");
        setOps.add("hobbies", "games");
        System.out.println(setOps.size("hobbies"));
    }

    @Test
    public void redisOpsTest() {
        stringRedisTemplate.expire("simplekey", 5, TimeUnit.SECONDS);
        stringRedisTemplate.expire("greeting", 10, TimeUnit.SECONDS);
        stringRedisTemplate.expire("hobbies", 15, TimeUnit.SECONDS);
    }
}