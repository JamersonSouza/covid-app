# Projeto Covid19 API

Este é um projeto que consome a covid19api e utiliza autenticação de usuários com JWT, também foi utilizado o ModelMapper para manipulação de dto's, JPA para persistência e MySQL como banco de dados.


### Instatação

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina: 

* Git
* JDK 8 ou Superior
* Maven
* Visual Studio Code
* MySQL 

Em seguida, execute os seguintes comandos em seu terminal para clonar o repositório projeto:

> git clone https://github.com/JamersonSouza/covid-app.git

> code . //para abrir o projeto no VsCode

### Configuração

* **Banco de dados**: será necessário alterar algumas informações no arquivo **application.yml** como por exemplo:  _USERNAME_ e _PASSWORD_ insira seu usuário e senha do banco de dados configurado na instalação do MySQL. Não esqueça que será necessário criar um banco de dados. Sendo assim, abra o MySQL WorkBench e execute o comando:

> CREATE DATABASE covidApp

### Utilização
A API suporta os seguintes endpoints:

* /user/cadastro: registra um novo usuário com as informações fornecidas no corpo da solicitação (UserRequestDTO).

* /user/login: autentica um usuário com as credenciais fornecidas no corpo da solicitação e retorna um token JWT.

* /api-covid/resumo: retorna um resumo dos casos de COVID-19 de todo o mundo e dos países.

* /api-covid/countries/{country}: retorna informações de um determinado país passado como parâmetro pelo o usuário.

* /api-covid/salvar: salva as informações de comparação feita pelo usuário no banco de dados.

Para acessar os endpoints protegidos por autenticação JWT, você deve incluir um cabeçalho de autorização em sua solicitação:

> Authorization: Bearer seu-token-jwt-aqui

### Tecnologias Utilizadas
* Spring Boot
* Spring Security
* JWT
* Lombok
* ModelMapper
* Banco de Dados (MySQL)

### Melhorias que podem ser implementadas

* Inserir funcionalidade que retornem as comparações que o usuário salvou no banco de dados.
* Método para exclusão de conta do usuário.
* Criar perfils de usuário, atualmente a aplicação conta apenas com um usuário padrão, sem a utilização de Enum para criar outros tipos.
* Tratar melhor os erros da aplicação.
* Melhoria nas validações existentes.
* Implementar testes unitários.
* Disponibilizar a API na AWS e o Front-end na vercel.
* Gerar relatórios em pdf, caso o usuário deseje.
* Realizar a captura do ID do usuário no front-end ao salvar a comparação.
