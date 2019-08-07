package com.redis.jedis.jedis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.redis.jedis.jedis.dao.ProgrammerRepo;
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
}
