# 3. `@OneToOne`

## 3.1 `@OneToOne(cascade)`

- cascade : 폭포수

<br>

### 3.1.1 `CascadeType.PERSIST`

- `@OneToOne` 어노테이션이 선언된 필드의 엔티티에 대한 영속성을 해당 엔티티에서 관리하겠다는 의미

<br>

### 3.1.2 `CascadeType.MERGE`

- 영속성 관리 대상 엔티티의 Setter 메서드를 동작 가능하게 함

<br>

### 3.1.3 `CascadeType.REMOVE`

- 영속성 관리 대상 엔티티에 객체 정보를 삭제하는 기능(repository에서의 `delete()`)을 동작 가능하게 함

<br>

### 3.1.4 `CascadeType.ALL`

- 다음 3가지 Action을 한꺼번에 처리해준다.
  - `CascadeType.PERSIST`
  - `CascadeType.MERGE`
  - `CascadeType.REMOVE`