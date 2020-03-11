package com.springboot.project.friendinfomgntsystem.service;

import com.springboot.project.friendinfomgntsystem.domain.Block;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.repository.BlockRepository;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
    }

}
