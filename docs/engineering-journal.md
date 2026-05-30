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

