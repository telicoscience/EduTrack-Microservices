# EduTrack Microservices

Sistema educacional desenvolvido com arquitetura de microsserviços em Java e Spring Boot.

## Objetivo

Este projeto foi desenhado para ser um **portfólio realista para vaga júnior**: escopo pequeno, entregável e explicável em entrevista, mas com fundamentos de arquitetura moderna.

## Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- RabbitMQ
- Spring Cloud Gateway
- Docker / Docker Compose
- JUnit + Mockito
- OpenAPI/Swagger
- GitHub Actions

## Microsserviços previstos

1. **student-service**: gestão de alunos
2. **classroom-service**: gestão de turmas e matrículas
3. **activity-service**: gestão de atividades avaliativas
4. **grade-service**: lançamento de notas e cálculo de média
5. **notification-service**: consumo de eventos para notificações (simuladas)
6. **api-gateway**: roteamento centralizado para os serviços

## O que o projeto demonstra

- CRUD com Spring Boot
- Separação por domínio
- Comunicação HTTP entre serviços
- Mensageria com RabbitMQ
- Banco PostgreSQL por serviço
- API Gateway
- Docker Compose
- Testes automatizados
- Pipeline CI com GitHub Actions

## Ordem recomendada de desenvolvimento

1. student-service
2. classroom-service
3. activity-service
4. grade-service
5. RabbitMQ
6. notification-service
7. api-gateway
8. testes
9. Docker completo
10. README final com prints e exemplos

## Roadmap por sprints

Consulte os detalhes em `docs/architecture.md` e `docs/endpoints.md`.

## Como iniciar infraestrutura local

> Neste momento o repositório está com o **esqueleto inicial**. Os serviços serão adicionados progressivamente.

```bash
docker compose up -d
```

Serviços de infraestrutura já disponíveis:

- RabbitMQ: `http://localhost:15672` (user: `guest`, senha: `guest`)
- PostgreSQL por domínio:
  - `student-db` porta `5433`
  - `classroom-db` porta `5434`
  - `activity-db` porta `5435`
  - `grade-db` porta `5436`

## Estrutura do repositório

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
