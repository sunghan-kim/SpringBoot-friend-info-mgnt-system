package com.springboot.project.friendinfomgntsystem.service;

import com.springboot.project.friendinfomgntsystem.domain.Block;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.repository.BlockRepository;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
        result.forEach(System.out::println);
    }

    private void givenPeople() {
         givenPerson("martin", 10, "A");
         givenPerson("david", 9, "B");
         givenPerson("dennis", 8, "O");
         givenPerson("martin", 11, "AB");
    }

    private void givenBlocks() {
        givenBlock("martin");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlock(String name) {
        blockRepository.save(new Block(name));
    }

}