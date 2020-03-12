package com.springboot.project.friendinfomgntsystem.repository;

import com.springboot.project.friendinfomgntsystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

}
