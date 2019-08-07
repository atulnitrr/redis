package com.redis.jedis.jedis.service;

public interface ProgrammerService {

    void serProgrammer(final String key, final String programmer);

    String getProgrammer(final String key);
}
