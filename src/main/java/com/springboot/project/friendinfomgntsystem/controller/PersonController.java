package com.springboot.project.friendinfomgntsystem.controller;

import com.springboot.project.friendinfomgntsystem.controller.dto.PersonDto;
import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.exception.PersonNotFoundException;
import com.springboot.project.friendinfomgntsystem.exception.RenameNotPermittedException;
import com.springboot.project.friendinfomgntsystem.exception.dto.ErrorResponse;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import com.springboot.project.friendinfomgntsystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Post의 경우에는 Rest 규약 상 상태를 200(ok)가 아닌 201(Created)를 지정할 수 있다.
    public void postPerson(@RequestBody PersonDto personDto) { // @RequestBody를 사용하면 json 형태의 데이터를 받을 수 있다.
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

    @ExceptionHandler(value = RenameNotPermittedException.class)
    public ResponseEntity<ErrorResponse> handleRenameNoPermittedException(RenameNotPermittedException ex) {
        return new ResponseEntity<>(ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST); // BAD_REQUEST : 400
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException ex) {
        return new ResponseEntity<>(ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        log.error("서버오류 : {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 오류가 발생하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR); // INTERNAL_SERVER_ERROR : 500
    }
}
