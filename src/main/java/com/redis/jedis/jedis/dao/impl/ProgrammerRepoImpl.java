package com.redis.jedis.jedis.dao.impl;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.redis.jedis.jedis.dao.ProgrammerRepo;



@Repository
public class ProgrammerRepoImpl implements ProgrammerRepo {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setProgrammer(final String idKey, final String programmer) {

        redisTemplate.opsForValue().set(idKey, programmer);
        redisTemplate.expire(idKey, 20 , TimeUnit.SECONDS);


    }



    @Override
    public String getProgrammer(final String key) {
        return  (String) redisTemplate.opsForValue().get(key);
    }
}
