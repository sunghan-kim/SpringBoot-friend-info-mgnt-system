package com.springboot.project.friendinfomgntsystem.repository;

import com.springboot.project.friendinfomgntsystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = ?1 and person.birthday.dayOfBirthday = ?2")
    List<Person> findByMonthOfBirthday(int monthOfBirthday, int dayOfBirthday);

}
