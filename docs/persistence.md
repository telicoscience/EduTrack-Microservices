# Persistência de Dados — EduTrack Microservices

Este documento registra a implementação inicial da camada de persistência do `student-service`.

---

## Objetivo

Substituir a lógica temporária em memória por uma estrutura de persistência real utilizando:

- PostgreSQL
- Spring Data JPA
- Hibernate
- Repository Pattern

Antes desta etapa, os dados dos alunos eram simulados diretamente no `StudentService` usando listas em memória.

---

## Problema anterior

A aplicação utilizava dados fake:

```java
List.of(
    new Student(1L, "João"),
    new Student(2L, "Maria")
);
```

Essa abordagem era útil para aprender os conceitos iniciais de:

- Controller
- Service Layer
- DTO
- Validação
- JSON
- Testes unitários

Porém, ela tinha limitações importantes:

- Os dados não eram persistidos
- Toda reinicialização da aplicação perdia o estado
- Não havia consulta real ao banco
- Não havia Repository Layer
- O sistema ainda não simulava um backend corporativo real

---

## Solução adotada

A persistência passou a ser preparada com PostgreSQL e Spring Data JPA.

O `student-service` agora possui:

- Configuração de conexão com PostgreSQL
- Classe `Student` marcada como entidade JPA
- Repositório `StudentRepository`
- Hibernate inicializado no startup da aplicação
- Banco `student_db` rodando em container Docker

---

## Fluxo arquitetural esperado

```text
HTTP Request
↓
StudentController
↓
StudentService
↓
StudentRepository
↓
PostgreSQL
```

A responsabilidade de cada camada é:

| Camada | Responsabilidade |
|---|---|
| Controller | Receber requisições HTTP |
| Service | Executar regras de negócio |
| Repository | Acessar o banco de dados |
| PostgreSQL | Persistir os dados |

---

## Configuração do banco

O banco do `student-service` é iniciado via Docker Compose.

Trecho relevante do `docker-compose.yml`:

```yaml
student-db:
  image: postgres:16
  container_name: edutrack-student-db
  environment:
    POSTGRES_DB: student_db
    POSTGRES_USER: postgres
    POSTGRES_PASSWORD: postgres
  ports:
    - "5433:5432"
  volumes:
    - student_db_data:/var/lib/postgresql/data
```

---

## Configuração da aplicação

Arquivo:

```text
student-service/src/main/resources/application.properties
```

Configuração atual:

```properties
spring.application.name=student-service
server.port=8081

spring.datasource.url=jdbc:postgresql://localhost:5433/student_db
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Entity JPA

A classe `Student` foi transformada em uma entidade JPA.

Arquivo:

```text
student-service/src/main/java/br/com/telico/student_service/model/Student.java
```

Conceitos aplicados:

```java
@Entity
@Table(name = "students")
public class Student {
}
```

Campos principais:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
```

---

## Repository Layer

Foi criado o repositório:

```text
student-service/src/main/java/br/com/telico/student_service/repository/StudentRepository.java
```

Estrutura:

```java
public interface StudentRepository extends JpaRepository<Student, Long> {
}
```

Esse repositório fornece operações prontas como:

- `findAll()`
- `findById(id)`
- `save(entity)`
- `deleteById(id)`

---

## Conceitos aprendidos

### JPA

JPA é uma especificação Java para persistência de dados. Ela define como objetos Java podem ser mapeados para tabelas de banco de dados.

---

### Hibernate

Hibernate é uma implementação da JPA. No projeto, ele é responsável por transformar operações com objetos Java em comandos SQL executados no PostgreSQL.

---

### ORM

ORM significa Object-Relational Mapping.

A ideia é mapear:

```text
Classe Java -> Tabela do banco
Objeto Java -> Linha da tabela
Atributo -> Coluna
```

Exemplo:

```text
Student -> students
id      -> id
name    -> name
```

---

### Repository Pattern

O Repository Pattern separa a lógica de acesso a dados da regra de negócio.

Assim, o `StudentService` não precisa saber detalhes de SQL, conexão ou comandos de banco. Ele usa o `StudentRepository`.

---

## Evidência de funcionamento

Ao iniciar a aplicação, o Spring detectou o repositório JPA:

```text
Found 1 JPA repository interface.
```

Também foi confirmada a conexão com o PostgreSQL:

```text
Database JDBC URL [jdbc:postgresql://localhost:5433/student_db]
Database driver: PostgreSQL JDBC Driver
Database dialect: PostgreSQLDialect
```

---

## Próximos passos

- Injetar `StudentRepository` no `StudentService`
- Substituir dados fake por `repository.findAll()`
- Salvar alunos com `repository.save()`
- Buscar aluno por ID com `repository.findById()`
- Criar testes adaptados para persistência
- Avaliar uso de Testcontainers futuramente

---

## Status

A infraestrutura de persistência está configurada e o repositório JPA já é reconhecido pela aplicação.

A próxima etapa é conectar o `StudentService` ao `StudentRepository` para que os endpoints passem a utilizar dados reais do PostgreSQL.