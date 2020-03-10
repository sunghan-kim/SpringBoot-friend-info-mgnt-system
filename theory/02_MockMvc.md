# 2. MockMvc 테스트 만들기

## 2.1 Junit5에서 사용하는 주요 annotation 및 메서드

### 2.1.1 `@Test`

- `org.junit.jupiter.api`의 `@Test`를 사용해야 junit5에서 사용이 가능하다.

<br>

### 2.1.2 `assertThat()`

- static method로 사용된다.

  - static method : 클래스를 생략하고 static method를 호출할 수 있다.
  - 테스트 코드에서는 static method를 사용하는 경우가 많다.

- `org.assertj.core.api.Assertions` 를 사용한다. 

- **특정 클래스의 특정 메서드의 실행 결과를 확인하기 위해 주로 사용된다.**

  ```java
  assertThat(Class.Method).isEqualTo("String value");
  ```

<br>

## 2.2 SpringBoot에서 활용하는 주요 annotation 및 기능

### 2.2.1 `@Autowired`

- 해당 필드에 대해 SpringContext에서 bean을 주입하겠다는  의미이다.

<br>

## 2.3 MockMvc Test

- Spring에서 제공하는 테스트
- 모의 http request와 response를 만들어서 테스트를 진행하는 것이 MockMvc Test이다.
- `HelloWorldControllerTest.java`의 `mockMvcTest()` 메서드 참고