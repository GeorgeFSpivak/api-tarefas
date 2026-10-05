# Tarefas API

Projeto de estudo desenvolvido em Java com Spring Boot.

Esta API foi criada para praticar a organização de um backend em camadas,
usando controller, service, repository, DTOs, validação, JPA, PostgreSQL e
Docker Compose. O projeto também foi usado para testar o uso de variáveis de
ambiente na configuração da aplicação e do banco de dados.

## Como rodar

Crie um arquivo `.env` usando o `.env.example` como base e informe a senha do
banco nas variáveis `POSTGRES_PASSWORD` e `DB_PASSWORD`.

Depois, suba o banco:

```bash
docker compose up -d
```

E rode a aplicação:

```bash
mvnw.cmd spring-boot:run
```

## Endpoints principais

- `GET /tarefas`
- `GET /tarefas/{id}`
- `POST /tarefas`
- `PATCH /tarefas/{id}`
- `POST /tarefas/{id}/concluir`
- `DELETE /tarefas/{id}`

## Aviso

O código pode conter erros.
