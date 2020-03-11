# 3. `@OneToOne`

- 아래의 Action들은 `@OneToOne` Relation 뿐만 아니라 다른 여러 종류의 Relation에서도 동일하게 제공되는 기능들이다.

<br>

## 3.1 `cascade`

```java
@OneToOne(cascade = ...)
```

- cascade : 폭포수
- default Cascade Type 없음

<br>

### 3.1.1 `CascadeType.PERSIST`

```java
@OneToOne(cascade = CascadeType.PERSIST)
```

- @OneToOne` 어노테이션이 선언된 필드의 엔티티에 대한 영속성을 해당 엔티티에서 관리하겠다는 의미

<br>

### 3.1.2 `CascadeType.MERGE`

```java
@OneToOne(cascade = CascadeType.MERGE)
```

- 영속성 관리 대상 엔티티의 Setter 메서드를 동작 가능하게 함

<br>

### 3.1.3 `CascadeType.REMOVE`

```java
@OneToOne(cascade = CascadeType.REMOVE)
```

- 영속성 관리 대상 엔티티에 객체 정보를 삭제하는 기능(repository에서의 `delete()`)을 동작 가능하게 함

<br>

### 3.1.4 `CascadeType.ALL`

```java
@OneToOne(cascade = CascadeType.ALL)
```

- 다음 3가지 Action을 한꺼번에 처리해준다.
  - `CascadeType.PERSIST`
  - `CascadeType.MERGE`
  - `CascadeType.REMOVE`

<br>

## 3.2 `orphanRemoval`

```java
@OneToOne(orphanRemoval = true/false)
```

- default orphanRemoval : false

<br>

### 3.2.1 `orphanRemoval = true`

```java
@OneToOne(orphanRemoval = true)
```

- 해당 엔티티에 `@OneToOne`이 선언된 필드가 해제(`null`이 할당)되는 순간, 필드의 엔티티 객체도 함께 삭제

- 불필요한 엔티티 관리 가능

<br>

## 3.3 `fetch`

```java
@OneToOne(fetch)
```

<br>

### 3.3.1 `FetchType.EAGER`

```java
@OneToOne(fetch = FetchType.EAGER)
```

- default Fetch Type
- `SELECT`문이 `left outer join`으로 하나의 블록으로 실행됨

<br>

### 3.3.2 `FetchType.LAZY`

```java
@OneToOne(fetch = FetchType.LAZY)
```

- `SELECT` 문이 두 개로 분리되어 실행됨

- 해당 엔티티를 `SELECT`할 때는 `@OneToOne`이 지정된 필드의 엔티티를 `SELECT`하지 않고 해당 엔티티가 필요한 시점에 `SELECT`를 하게 된다.
- 필드에 `@ToString.Exclude`를 지정하면 불필요한 출력을 줄일 수 있다.

<br>

## 3.4 `optional`

```java
@OneToOne(optional = true/false)
```

- default optional : true

<br>

### 3.4.1 `optional = false`

```java
@OneToOne(fetch = FetchType.EAGER, optional = false)
```

- `@OneToOne` 이 선언된 필드의 엔티티는 항상 필요하다는 의미이다. (optional 이 아니다.)