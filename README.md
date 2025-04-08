# ⚡ Desafio Bolt Energy - Importação e Consulta de Usinas

Este projeto foi desenvolvido como parte do processo seletivo da Bolt Energy. Ele realiza o download, processamento e persistência de dados de usinas geradoras de energia a partir de um arquivo CSV disponibilizado pela ANEEL, e expõe uma API REST para consulta.

---

## 🚀 Tecnologias Utilizadas

- **Kotlin**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **PostgreSQL 15.3**
- **Flyway 10.15.0**
- **JDK 21**
- **Docker (para o banco de dados)**

---

## 🛠️ Funcionalidades

- ⏬ Download automático do CSV da ANEEL
- 🧮 Processamento de mais de 350 mil registros
- 🗂️ Persistência em banco com validação de dados
- 🔁 Agendamento automático mensal da atualização
- 📊 Endpoint `/usinas/top5` que retorna as 5 usinas com maior potência

---

## 📦 Requisitos para rodar o projeto

- JDK 21+
- Maven 3.8+
- Docker (para rodar o PostgreSQL localmente)

---

## 🐳 Subindo o banco de dados com Docker

```bash
docker run --name pg15 -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:15.3
