# 2026-05-29

## Problema
Erro de persistência ao salvar Student.

## Sintoma
HTTP 500 durante POST /students.

## Causa
Tabela criada sem auto incremento na coluna id.

## Solução
Recriação da tabela pelo Hibernate.

## Aprendizado
Diferença entre mapeamento JPA e schema físico do banco.

## PUT Student Endpoint

# 30-05-2026

### Problema

Aplicação não iniciava após implementação do endpoint PUT.

### Investigação

Após corrigir problemas de conexão com PostgreSQL, o Spring continuava falhando durante o startup.

### Causa

Erro de sintaxe na anotação:

@PutMapping("/{id")

faltando a chave de fechamento.

### Solução

Corrigido para:

@PutMapping("/{id}")

### Aprendizado

Aprendi a interpretar mensagens de erro do Spring MVC relacionadas ao mapeamento de rotas.

## Student Update Endpoint

### Objetivo
Implementar atualização de alunos com persistência real.

### Implementação
- Criado endpoint `PUT /students/{id}`
- Reutilizado `CreateStudentRequest` como DTO de entrada
- Atualização feita no `StudentService`
- Persistência feita via `StudentRepository.save()`

### Problemas encontrados
- Erro de rota por falta de `}` em `@PutMapping("/{id}")`
- Erro de digitação em `@RequestBody`
- Erro recorrente de conexão quando o PostgreSQL não estava rodando

### Aprendizados
- `PUT` representa atualização de recurso em APIs REST
- `save()` no JPA pode inserir ou atualizar
- Logs do Spring indicam problemas de rota, injeção, banco e validação


