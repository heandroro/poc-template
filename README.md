# poc-template

Serviço teste

## Stack

| Camada        | Tecnologia                                        |
| ------------- | ------------------------------------------------- |
| Linguagem     | Java 21                                           |
| Framework     | Spring Boot 3.5.0                                 |
| Persistência  | Spring Data JPA + PostgreSQL                      |
| Mapeamento    | MapStruct 1.6                                     |

## Estrutura de Módulos

```
poc-template/
├── core/                    # Regras de negócio — zero dependências de framework
├── infra-api/               # Adaptador REST de entrada (Spring Web MVC)
├── infra-postgres/          # Adaptador de persistência relacional (JPA)
└── application/             # Spring Boot bootstrapper + configuração global
```

## Rodando Localmente

Pré-requisitos: Docker

```bash
# Subir infraestrutura
docker compose up -d

# Build & run
./mvnw clean package -pl application -am
java -jar application/target/application-1.0.0-SNAPSHOT.jar
```

## Namespace

Pacote base: `com.yamaniha.java`

## Arquitetura

Este projeto segue a **Arquitetura Hexagonal** com layout **Flat Multi-Módulo Maven**.
Consulte o [AGENT.md](./AGENT.md) para as regras arquiteturais completas.
