package com.springboot.project.friendinfomgntsystem.service;

import com.springboot.project.friendinfomgntsystem.domain.Person;
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

    public List<Person> getPeopleExcludeBlocks() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);

        log.info("person : {}", person);

        return person;
    }

    @Transactional
    public void put(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, Person person) {
        Person personAtDb = personRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다."));
        // orElseThrow : 값이 없을 경우 예외를 throw 한다.

        personAtDb.setName(person.getName());
        personAtDb.setPhoneNumber(person.getPhoneNumber());
        personAtDb.setJob(person.getJob());
        personAtDb.setBirthday(person.getBirthday());
        personAtDb.setAddress(person.getAddress());
        personAtDb.setBloodType(person.getBloodType());
        personAtDb.setHobby(person.getHobby());
        personAtDb.setAge(person.getAge());

        personRepository.save(personAtDb);
    }
}
