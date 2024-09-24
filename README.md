# BankApp

Trabalho Final de disciplina de Banco de Dados, orientado por Daniel Alencar.

**Descrição**

Projeto em Java que possui interface com tabelas de um Banco de Dados para serviços financeiros, modelado na disciplina de Banco de Dados.

Obs: Não é uma API, então todo o fluxo existe apenas de forma programada. O intuito do projeto é operar diretamente com código SQL e construir um Mapeamento Objeto-Relacional (ORM) a partir de bibliotecas padrões do Java.

**Instruções de instalação**

**Requisitos de sistema**

* Java SE JDK 17.x
* Postgres 16.x

**Instalação da aplicação**

1. Inicialize um banco de dados em PostgreSQL com o nome `bank_db` e especifique o host, porta e credenciais na classe `DAO.ConexaoDB`
2. Entre na pasta `src` da aplicação
3. Execute o comando `javac -cp .:./postgresql.jar Main.java` para compilar a aplicação
4. Execute o comando `java -cp .:./postgresql.jar Main` para iniciar a aplicação

**Docker Compose**

Se você tiver Docker instalado, você poderá executar o projeto usando docker compose

1. Entre no diretório em que o `docker-compose.yml` está localizado
2. Execute o comando `docker-compose up --build` para construir e iniciar os containers