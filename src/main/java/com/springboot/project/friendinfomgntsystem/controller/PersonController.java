package com.springboot.project.friendinfomgntsystem.controller;

import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Person getPerson(@RequestParam(required = false, defaultValue = "1") Long id) {
        return personService.getPerson(id);
    }

}
