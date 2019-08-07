package com.redis.jedis.jedis.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.jedis.jedis.model.Programmer;
import com.redis.jedis.jedis.service.ProgrammerService;


@RestController

@RequestMapping(path = "/jedis")
public class ProgrammerController {


    @Autowired
    private ProgrammerService programmerService;



    @PostMapping
    public void addTopic(@RequestBody final Programmer programmer) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        programmerService.serProgrammer(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
    }


    @GetMapping(path = "/{id}")
    public String get(@PathVariable(name = "id") final String id) {
        return programmerService.getProgrammer(id);
    }


}
