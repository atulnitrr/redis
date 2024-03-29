package com.redis.jedis.jedis.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.redis.jedis.jedis.dao.ProgrammerRepo;
import com.redis.jedis.jedis.model.Programmer;


@Repository
public class ProgrammerRepoImpl implements ProgrammerRepo {

    private static final String REDIS_LIST_KEY = "ProgrammerList";
    private static final String REDIS_SET_KEY = "ProgrammerSet";
    private static final String REDIS_HASH_KEY = "ProgrammerHash";


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

    @Override
    public void addToProgrammerList(final Programmer programmer) {

        redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);

    }

    @Override
    public List<Programmer> getProgrammerList() {
        List<Programmer> programmers = redisTemplate.opsForList()
                .range(REDIS_LIST_KEY, 0, -1)
                .stream()
                .map(prog -> (Programmer) prog)
                .collect(Collectors.toList());
        return programmers;
    }

    @Override
    public Long getProgrammerListCount() {
        Long v = redisTemplate.opsForList().size(REDIS_LIST_KEY);
        long count = redisTemplate.opsForList().range(REDIS_LIST_KEY, 0,-1).stream().count();
        System.out.println( "count --> "  + count);
        System.out.println( "v --> "  + v);
        return v;
    }

    @Override
    public void addToProgrammerSet(final Programmer... programmers) {
        redisTemplate.opsForSet().add(REDIS_SET_KEY, programmers);
    }

    @Override
    public Set<Programmer> getProgrammerSet() {
        return redisTemplate.opsForSet()
                .members(REDIS_SET_KEY)
                .stream()
                .map( prog -> (Programmer) prog)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isSetMember(final Programmer programmer) {
        return redisTemplate.opsForSet().isMember(REDIS_SET_KEY, programmer);
    }

    @Override
    public void saveToHash(final Programmer programmer) {
        redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);

    }

    @Override public void updateHash(final Programmer programmer) {
        redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);

    }

    @Override public Map<Integer, Programmer> findAllInHash() {
//        return redisTemplate.opsForHash().entries(REDIS_HASH_KEY).entrySet().stream().map(objectObjectEntry -> (Map<Integer, Programmer>) objectObjectEntry).collect(
//                Collectors.toMap());
        return null;
    }

    @Override
    public Programmer findInHash(final int id) {
        return (Programmer) redisTemplate.opsForHash().get(REDIS_HASH_KEY, id);
    }

    @Override
    public void deleteInHash(final int id) {
        redisTemplate.opsForHash().delete(REDIS_HASH_KEY, id);

    }

}
