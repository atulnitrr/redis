package com.redis.jedis.jedis.dao;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.redis.jedis.jedis.model.Programmer;


@Repository
public interface ProgrammerRepo {

    void setProgrammer(final String idKey, String programmer);

    String getProgrammer(final String key);

    void addToProgrammerList(final Programmer programmer);

    List<Programmer> getProgrammerList();

    Long getProgrammerListCount();



//    SET

    void addToProgrammerSet(final Programmer ...programmers);

    Set<Programmer> getProgrammerSet();

    boolean isSetMember(final Programmer programmer);


}
