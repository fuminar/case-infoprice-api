Projeto desenvolvido para o InfoPrice Fullstack Test
====================================================

Projeto Back-End.

Instalação
----------
É necessário o maven instalado (apt-get install maven)

1. `mvn install` para instalar as dependências
2. `mvn spring-boot:run` para rodar a aplicação
3. A aplicação utiliza Lombok, portanto é necessário ter o plugin instalado na IDE
4. Api responde pela url: [http://localhost:8080](http://localhost:8080)


Tecnologias
-----------
Java8, Spring-Boot, Jpa/Hibernate, Hyper Structured Query Language Database (HSQLDB)

Code Style
-----------
São utilizados os plugins checkStyle e PMD para checagem de estilo de código.
Utilize o seguinte comando para rodar a checagem:

1. `mvn process-classes` para rodar a checagem


Testes
------
1. `mvn test` para executar os testes
