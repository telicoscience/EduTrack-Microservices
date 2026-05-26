# EduTrack Microservices

Sistema educacional desenvolvido com arquitetura de microsserviços utilizando Java e Spring Boot.

---

## Objetivo

Este projeto foi desenhado como um projeto de portfólio para demonstrar competências de backend moderno utilizando:

- Java moderno
- Spring Boot
- APIs REST
- Microsserviços
- Docker
- PostgreSQL
- Mensageria
- Arquitetura em camadas

O foco do projeto é construir uma aplicação pequena, porém arquiteturalmente sólida, explicável em entrevistas técnicas e evolutiva ao longo do tempo.

---

## Stack Tecnológica

### Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

### Banco de Dados

- PostgreSQL

### Microsserviços e Infraestrutura

- RabbitMQ
- Spring Cloud Gateway
- Docker
- Docker Compose

### Testes

- JUnit
- Mockito

### Documentação

- OpenAPI / Swagger

### DevOps

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

Atualmente o projeto possui o `student-service` parcialmente implementado.

## Funcionalidades já implementadas

- Estrutura inicial Spring Boot
- Endpoints REST básicos
- Controller Layer
- Service Layer
- Injeção de Dependência
- Serialização automática JSON
- Organização em camadas
- Modelo orientado a objetos inicial

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
GET /students/search?name=joao
```

### Exemplo

```http
GET /students/search?name=ana
```

### Resposta

```json
[
  {
    "id": 1,
    "name": "ana"
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

# Conceitos já implementados

O projeto já demonstra:

- REST APIs
- Spring Controllers
- Service Layer
- Dependency Injection
- Inversion of Control (IoC)
- JSON Serialization
- Path Variables
- Query Parameters
- Request Body
- Arquitetura em camadas
- Programação Orientada a Objetos
- Docker Compose inicial

---

# Roadmap Técnico

## Sprint 1 — student-service

- [x] Criar estrutura Spring Boot
- [x] Criar endpoints REST iniciais
- [x] Criar model `Student`
- [x] Criar Service Layer
- [x] Injeção de dependência
- [ ] DTOs
- [ ] Validação
- [ ] Testes
- [ ] Integração com PostgreSQL

---

## Sprint 2 — classroom-service

- [ ] CRUD de turmas
- [ ] Matrículas
- [ ] Relacionamento aluno/turma

---

## Sprint 3 — activity-service

- [ ] Cadastro de atividades
- [ ] Tipos de atividade
- [ ] Integração com turmas

---

## Sprint 4 — grade-service

- [ ] Lançamento de notas
- [ ] Cálculo de médias
- [ ] Histórico acadêmico

---

## Sprint 5 — RabbitMQ

- [ ] Eventos entre serviços
- [ ] Publicação e consumo de mensagens

---

## Sprint 6 — notification-service

- [ ] Consumo de eventos
- [ ] Simulação de notificações

---

## Sprint 7 — API Gateway

- [ ] Gateway centralizado
- [ ] Roteamento de serviços

---

## Sprint 8 — Qualidade e DevOps

- [ ] Testes automatizados
- [ ] GitHub Actions
- [ ] Dockerização completa
- [ ] Swagger/OpenAPI
- [ ] README final

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
- Docker
- PostgreSQL
- RabbitMQ
- Arquitetura backend
- Boas práticas de engenharia de software
- DevOps básico

---

# Observações

O projeto ainda está em desenvolvimento e parte da lógica atual utiliza dados simulados em memória para fins de aprendizado incremental e construção gradual da arquitetura.