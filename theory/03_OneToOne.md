# 3. `@OneToOne`

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
- `left outer join`으로 하나의 블록으로 쿼리문이 실행됨

<br>

### 3.3.2 `FetchType.LAZY`

```java
@OneToOne(fetch = FetchType.LAZY)
```

