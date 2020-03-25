package com.springboot.project.friendinfomgntsystem.service;

import com.springboot.project.friendinfomgntsystem.controller.dto.PersonDto;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.exception.PersonNotFoundException;
import com.springboot.project.friendinfomgntsystem.exception.RenameNotPermittedException;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public void put(PersonDto personDto) {
        Person person = new Person();
        person.set(personDto);
        person.setName(personDto.getName());
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        // orElseThrow : 값이 없을 경우 예외를 throw 한다.

        if (!person.getName().equals(personDto.getName())) {
            throw new RenameNotPermittedException();
        }

        person.set(personDto);

        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, String name) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);

        person.setName(name);

        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);

        person.setDeleted(true);

        personRepository.save(person);
    }
}
