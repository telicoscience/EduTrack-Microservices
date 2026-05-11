# Arquitetura - EduTrack Microservices

## Visão geral

Arquitetura de microsserviços orientada a domínio, com persistência separada por serviço e integração síncrona (HTTP) + assíncrona (RabbitMQ).

## Serviços e responsabilidades

- **student-service**: CRUD de alunos.
- **classroom-service**: CRUD de turmas e matrícula de alunos.
- **activity-service**: CRUD de atividades por turma.
- **grade-service**: lançamento de notas, cálculo de média e boletim simples.
- **notification-service**: consumo de eventos (`student.created`, `activity.created`, `grade.created`) e logging.
- **api-gateway**: porta de entrada única (`/api/*`) para os clientes.

## Comunicação

- **HTTP (REST)**
  - classroom-service valida aluno consultando student-service.
  - grade-service valida aluno e atividade consultando student-service/activity-service.
- **RabbitMQ**
  - student-service publica `student.created`.
  - activity-service publica `activity.created`.
  - grade-service publica `grade.created`.
  - notification-service consome todos os eventos.

## Persistência

Cada serviço de domínio possui seu próprio banco PostgreSQL:

- `student-db`
- `classroom-db`
- `activity-db`
- `grade-db`

## Fases de entrega

1. Base + student-service
2. classroom-service
3. activity-service
4. grade-service
5. Mensageria
6. Gateway
7. Testes
8. DevOps/documentação final
