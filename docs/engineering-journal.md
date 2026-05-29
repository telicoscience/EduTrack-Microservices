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