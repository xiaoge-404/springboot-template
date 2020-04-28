package com.opsbible.app.service.impl;

import com.opsbible.app.entity.Person;
import com.opsbible.app.mapper.PersonMapper;
import com.opsbible.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insertPerson(Person person){
        return personMapper.insert(person);
    }

    @Override
    public String getPerson(Integer id){
        return personMapper.select(id);
    }
}
