# 1. WAS 실행 및 종료

## 1.1 WAS 실행

- 터미널에서 `bootRun` 명령을 통해 WAS 실행

  ```
  gradlew.bat bootRun
  ```

- 다음과 같은 내용이 보이면 임베디드된 톰캣 서버가 정상적으로 실행된 것이다.

  ```
  Started FriendInfoMgntSystemApplication in 3.196 seconds (JVM running for 3.664)
  ```

- SpringBoot에서는 톰캣 서버를 임베디드해서 사용할 수 있게 되어 있다.

- 브라우저에서 `http://localhost:8080`으로 실행된 WAS에 접속할 수 있다.
- SpringBoot에서는 기본적으로 톰캣 포트를 `8080`으로 잡고 있다.

<br>

## 1.2 WAS 종료

- 터미널에서 `Ctrl + c`를 통해 실행 중인 WAS를 종료시킬 수 있다.

<br>

## 1.3 Intellij WAS 실행 시 브라우저 실행 설정

- `test` 디렉토리 하위에 `hello.http` 파일 생성

