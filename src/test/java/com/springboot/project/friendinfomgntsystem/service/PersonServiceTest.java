package com.springboot.project.friendinfomgntsystem.service;

import com.springboot.project.friendinfomgntsystem.domain.Person;
import com.springboot.project.friendinfomgntsystem.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks // 테스트 대상이 되는 클래스에 지정
    private PersonService personService;

    @Mock // 테스트 대상이 되는 클래스에서 Autowired 되는 클래스들에 지정
    private PersonRepository personRepository;

    @Test
    void getPeopleByName() {
        // personRepository.findByName() 이 실제로 호출되는 것이 아니라 호출되었다고 가정하는 것이다. (Mock)
        when(personRepository.findByName("martin"))
                .thenReturn(Lists.newArrayList(new Person("martin")));

        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void getPerson() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("martin")));

        Person person = personService.getPerson(1L);

        assertThat(person.getName()).isEqualTo("martin");
    }

    @Test
    void getPersonIfNotFound() {
        // Mock Test를 통해 DB 작업 없이 간단하게 Test를 구현할 수 있다.
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty()); // null

        Person person = personService.getPerson(1L);

        assertThat(person).isNull();
    }

}