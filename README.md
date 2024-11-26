## Arquitetura Hexagonal na Prática, com Kotlin e SpringBoot

**Projeto feito com Kotlin no Java 17 e Spring Framework 3.2.3

## Sobre o Projeto

Este projeto consiste em uma aplicação simples de CRUD (Create, Read, Update e Delete) com produtor e consumidor kafka,
aplicando na prática a arquitetura hexagonal e
utilizando "ArchUnit" para proteção dessa arquitetura. A aplicação foi dividida em 3 pacotes principais: '
application', 'ports' e 'adapters', fora o pacote 'config' onde foi configurado manualmente as beans da camada 'service'
e configuração do kafka.

## Tecnologias utilizadas

- Kotlin
- Gradle
- Spring Boot
- Mongo DB
- Open Feign
- JUnit 5
- WireMock
- Kafka
- ArchUnit

## Iniciando projeto

Para iniciar a aplicação execute a seguinte ação na pasta do projeto

    ./gradlew bootRun

Instale as dependências do gradle com o comando:

    ./gradlew dependencies

## Autor

**João Vitor Neves Marques** <br>
e-mail: jvneves_marq@hotmail.com <br>
Linkedin: https://www.linkedin.com/in/jvneves/
