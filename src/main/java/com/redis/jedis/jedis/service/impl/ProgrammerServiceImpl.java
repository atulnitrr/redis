package com.redis.jedis.jedis.service.impl;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.redis.jedis.jedis.dao.ProgrammerRepo;
import com.redis.jedis.jedis.model.Programmer;
import com.redis.jedis.jedis.service.ProgrammerService;



@Service
public class ProgrammerServiceImpl implements ProgrammerService {


    @Autowired
    private ProgrammerRepo programmerRepo;


    @Override
    public void serProgrammer(final String key, final String programmer) {
        programmerRepo.setProgrammer(key, programmer);

    }

    @Override
    public String getProgrammer(final String key) {
        return programmerRepo.getProgrammer(key);
    }

    @Override
    public void addToProgrammerList(final Programmer programmer) {

        programmerRepo.addToProgrammerList(programmer);

    }

    @Override
    public List<Programmer> getProgrammerList() {
        return programmerRepo.getProgrammerList();
    }

    @Override
    public long getProgrammerListSize() {
        return programmerRepo.getProgrammerListCount();
    }

    @Override
    public void addProgrammerToSet(final Programmer... programmers) {
        programmerRepo.addToProgrammerSet(programmers);
    }

    @Override
    public Set<Programmer> getProgrammersSet() {
        return programmerRepo.getProgrammerSet();
    }

    @Override
    public boolean isMemberOfSet(final Programmer programmer) {
        return programmerRepo.isSetMember(programmer);
    }

}
