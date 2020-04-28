package com.opsbible.app.controller;

import com.opsbible.app.entity.Person;
import com.opsbible.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    public String addPerson(@RequestBody Person person){

        System.out.println(person.getName());
        personService.insertPerson(person);
        return "ok";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    public String getPerson(@RequestBody Person person){
        return personService.getPerson(person.getId());
    }
}
