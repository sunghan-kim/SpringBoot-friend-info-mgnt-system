package com.springboot.project.friendinfomgntsystem.controller;

import com.springboot.project.friendinfomgntsystem.controller.dto.PersonDto;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import com.springboot.project.friendinfomgntsystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Post의 경우에는 Rest 규약 상 상태를 200(ok)가 아닌 201(Created)를 지정할 수 있다.
    public void postPerson(@RequestBody Person person) { // @RequestBody를 사용하면 json 형태의 데이터를 받을 수 있다.
        personService.put(person);

        log.info("person -> {} ", personRepository.findAll());
    }

    @PutMapping("/{id}") // 데이터 수정의 경우 REST 규약 상 @PutMapping을 사용한다. Put의 response status는 200이다.
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
        personService.modify(id, personDto);

        log.info("person -> {} ", personRepository.findAll());
    }

}
