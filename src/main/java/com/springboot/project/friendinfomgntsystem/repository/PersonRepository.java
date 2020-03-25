package com.springboot.project.friendinfomgntsystem.repository;

import com.springboot.project.friendinfomgntsystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select person from Person person where person.address = :name") // PersonServiceTest 실행 시 실제 PersonRepository가 실행되지 않는 것 확인
    List<Person> findByName(@Param("name") String name);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);

    @Query(value = "select * from Person person where person.deleted = true", nativeQuery = true) // nativeQuery : Entity를 사용하지 않는 쿼리
    List<Person> findPeopleDeleted();
}
