package com.opsbible.app.service;

import com.opsbible.app.entity.Person;

public interface PersonService {
    int insertPerson(Person person);
    String getPerson(Integer id);
}
