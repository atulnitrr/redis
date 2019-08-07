package com.redis.jedis.jedis.service;

import java.util.List;
import com.redis.jedis.jedis.model.Programmer;


public interface ProgrammerService {

    void serProgrammer(final String key, final String programmer);

    String getProgrammer(final String key);


    void addToProgrammerList(final Programmer programmer);

    List<Programmer> getProgrammerList();

    long getProgrammerListSize();

}
