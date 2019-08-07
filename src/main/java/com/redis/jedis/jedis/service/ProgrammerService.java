package com.redis.jedis.jedis.service;

import java.util.List;
import java.util.Set;
import com.redis.jedis.jedis.model.Programmer;


public interface ProgrammerService {

    void serProgrammer(final String key, final String programmer);

    String getProgrammer(final String key);


    void addToProgrammerList(final Programmer programmer);

    List<Programmer> getProgrammerList();

    long getProgrammerListSize();

    void addProgrammerToSet(final Programmer ...programmers);

    Set<Programmer> getProgrammersSet();

    boolean isMemberOfSet(final Programmer programmer);




}
