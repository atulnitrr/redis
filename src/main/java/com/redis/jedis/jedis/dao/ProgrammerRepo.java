package com.redis.jedis.jedis.dao;

import org.springframework.stereotype.Repository;


@Repository
public interface ProgrammerRepo {

    void setProgrammer(final String idKey, String programmer);

    String getProgrammer(final String key);

}
