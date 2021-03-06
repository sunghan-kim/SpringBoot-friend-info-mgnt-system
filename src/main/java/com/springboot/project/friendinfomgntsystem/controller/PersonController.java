package com.springboot.project.friendinfomgntsystem.controller;

import com.springboot.project.friendinfomgntsystem.controller.dto.PersonDto;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Page<Person> getAll(@PageableDefault Pageable pageable) {
        return personService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Post의 경우에는 Rest 규약 상 상태를 200(ok)가 아닌 201(Created)를 지정할 수 있다.
    public void postPerson(@RequestBody @Valid PersonDto personDto) { // @RequestBody를 사용하면 json 형태의 데이터를 받을 수 있다.
        personService.put(personDto);
    }

    @PutMapping("/{id}") // 데이터 수정의 경우 REST 규약 상 @PutMapping을 사용한다. Put의 response status는 200이다. Put은 전체 데이터 변경
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
        personService.modify(id, personDto);
    }

    @PatchMapping("/{id}") // Patch : 일부 데이터만 변경
    public void modifyPerson(@PathVariable Long id, String name) {
        personService.modify(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }
}
