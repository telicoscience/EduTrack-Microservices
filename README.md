# EduTrack Microservices

Sistema educacional desenvolvido com arquitetura de microsserviços utilizando Java e Spring Boot.

---

# Objetivo

Este projeto foi criado como um projeto de portfólio para consolidar conhecimentos em backend moderno e arquitetura de microsserviços utilizando Java e Spring Boot.

O foco principal é desenvolver uma aplicação pequena, incremental e explicável tecnicamente em entrevistas, demonstrando:

- Arquitetura em camadas
- APIs REST
- Microsserviços
- Docker
- PostgreSQL
- Mensageria
- Testes automatizados
- Boas práticas de backend

O projeto também serve como trilha prática de aprendizagem em backend enterprise.

---

# Stack Tecnológica

## Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

## Banco de Dados

- PostgreSQL

## Microsserviços e Infraestrutura

- RabbitMQ
- Spring Cloud Gateway
- Docker
- Docker Compose

## Testes

- JUnit
- Mockito

## Documentação

- OpenAPI / Swagger

## DevOps

- GitHub Actions

---

# Arquitetura do Projeto

O sistema está sendo desenvolvido utilizando arquitetura de microsserviços, onde cada domínio possui responsabilidade própria e independência estrutural.

## Microsserviços previstos

| Serviço | Responsabilidade |
|---|---|
| student-service | Gestão de alunos |
| classroom-service | Gestão de turmas e matrículas |
| activity-service | Gestão de atividades |
| grade-service | Gestão de notas e médias |
| notification-service | Consumo de eventos e notificações |
| api-gateway | Gateway centralizado da aplicação |

---

# Estrutura Atual do Projeto

```text
edutrack-microservices/
├── README.md
├── docker-compose.yml
├── docs/
│   ├── architecture.md
│   ├── endpoints.md
│   └── diagrams/
├── student-service/
├── classroom-service/
├── activity-service/
├── grade-service/
├── notification-service/
└── api-gateway/
```

---

# Status Atual do Desenvolvimento

Atualmente o projeto possui o `student-service` implementado com lógica simulada em memória, endpoints REST básicos, validação, tratamento de erros e testes unitários iniciais.

## Funcionalidades já implementadas

- Estrutura inicial Spring Boot
- Endpoints REST básicos
- Controller Layer
- Service Layer
- DTO Layer
- Injeção de Dependência
- Serialização automática JSON
- Organização em camadas
- Modelo orientado a objetos inicial
- Bean Validation
- Tratamento global de exceções
- Testes unitários do Service Layer

---

# Endpoints já implementados

## Listar alunos

```http
GET /students
```

### Exemplo de resposta

```json
[
  {
    "id": 1,
    "name": "João"
  },
  {
    "id": 2,
    "name": "Maria"
  }
]
```

---

## Buscar aluno por ID

```http
GET /students/{id}
```

### Exemplo

```http
GET /students/1
```

### Resposta

```json
{
  "id": 1,
  "name": "João"
}
```

---

## Buscar aluno por nome

```http
GET /students/search?name=ana
```

### Resposta

```json
[
  {
    "id": 1,
    "name": "Ana"
  }
]
```

---

## Criar aluno

```http
POST /students
```

### Body

```json
{
  "name": "Carlos"
}
```

### Resposta

```json
{
  "id": 3,
  "name": "Carlos"
}
```

---

# Validação e tratamento de erros

O projeto já possui validação básica de entrada utilizando Bean Validation.

## Exemplo de requisição inválida

```http
POST /students
```

### Body inválido

```json
{
  "name": ""
}
```

### Resposta

```json
{
  "error": "Validation failed",
  "fields": {
    "name": "não deve estar em branco"
  },
  "status": 400
}
```

O tratamento global de erros é realizado utilizando:

- `@RestControllerAdvice`
- `@ExceptionHandler`
- `MethodArgumentNotValidException`

---

# Conceitos já implementados

O projeto já demonstra:

- REST APIs
- Spring Controllers
- Service Layer
- DTO Pattern
- Dependency Injection
- Inversion of Control (IoC)
- JSON Serialization
- Bean Validation
- Global Exception Handling
- Path Variables
- Query Parameters
- Request Body
- Arquitetura em camadas
- Programação Orientada a Objetos
- Docker Compose inicial
- Unit Testing com JUnit

---

# Testes implementados

Atualmente o projeto possui testes unitários básicos do `StudentService`.

## Testes existentes

- `shouldReturnAllStudents`
- `shouldReturnStudentById`
- `shouldSearchStudentByName`
- `shouldCreateStudent`

## Executar testes

```bash
cd student-service
./mvnw test
```

---

# Roadmap Técnico

## Sprint 1 — student-service

- [x] Criar estrutura Spring Boot
- [x] Criar endpoints REST iniciais
- [x] Criar model `Student`
- [x] Criar Service Layer
- [x] Injeção de dependência
- [x] DTOs
- [x] Validação
- [x] Tratamento global de exceções
- [x] Testes unitários básicos
- [ ] Integração com PostgreSQL

---

## Sprint 2 — Persistência com PostgreSQL

- [ ] Configuração do banco PostgreSQL
- [ ] Integração Spring Data JPA
- [ ] Hibernate
- [ ] Entity `Student`
- [ ] Repository Layer
- [ ] Persistência real no banco
- [ ] Migração da lógica fake em memória

---

## Sprint 3 — classroom-service

- [ ] CRUD de turmas
- [ ] Matrículas
- [ ] Relacionamento aluno/turma

---

## Sprint 4 — activity-service

- [ ] Cadastro de atividades
- [ ] Tipos de atividade
- [ ] Integração com turmas

---

## Sprint 5 — grade-service

- [ ] Lançamento de notas
- [ ] Cálculo de médias
- [ ] Histórico acadêmico

---

## Sprint 6 — RabbitMQ

- [ ] Eventos entre serviços
- [ ] Publicação e consumo de mensagens

---

## Sprint 7 — notification-service

- [ ] Consumo de eventos
- [ ] Simulação de notificações

---

## Sprint 8 — API Gateway

- [ ] Gateway centralizado
- [ ] Roteamento de serviços

---

## Sprint 9 — Qualidade e DevOps

- [ ] GitHub Actions
- [ ] Dockerização completa
- [ ] Swagger/OpenAPI
- [ ] README final
- [ ] Testes de integração

---

# Como executar o projeto

## Subir infraestrutura local

```bash
docker compose up -d
```

---

## Executar o student-service

```bash
cd student-service
./mvnw spring-boot:run
```

---

# Serviços locais disponíveis

## RabbitMQ

```text
http://localhost:15672
```

Usuário:

```text
guest
```

Senha:

```text
guest
```

---

## PostgreSQL

| Serviço | Porta |
|---|---|
| student-db | 5433 |
| classroom-db | 5434 |
| activity-db | 5435 |
| grade-db | 5436 |

---

# Objetivos de aprendizado do projeto

Este projeto está sendo utilizado para consolidar conhecimentos em:

- Java moderno
- Spring Boot
- Microsserviços
- APIs REST
- DTO Pattern
- Bean Validation
- Testes automatizados
- Tratamento global de exceções
- Docker
- PostgreSQL
- RabbitMQ
- Arquitetura backend
- Boas práticas de engenharia de software
- DevOps básico

---

# Observações

O projeto ainda está em desenvolvimento e parte da lógica atual utiliza dados simulados em memória para fins de aprendizado incremental e construção gradual da arquitetura.