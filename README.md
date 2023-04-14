
# Sistema Financeiro em Spring

Esse projeto foi desenvolvido durante o desafio do programa Jovens Profissionais e 40+ da empresa Minsait.

## Sobre o Desafio

O desafio é dividido em duas partes:

* Back-End: Criar uma API REST que possibilite o CRUD de Clientes e a criação, leitura e deleção de Empréstimos. As tecnologias utilizadas foram: Spring Boot 3.7.4, Java 8, H2 Database e Hibernate/JPA;

* Front-End: Criar uma SPA para consumir a API construída no back-end e mostrar na tela a listagem de Clientes com as operações CRUD. As tecnologias utilizadas foram: Angular 15, Bootstrap 5.3 e Sweetalert2.

Você pode encontrar o link do Front-End aqui: https://github.com/Gabriel-Sasaki/SistemaFinanceiroAngular

# Endpoints

## Clientes

#### POST
/api/v1/clientes

#### GET
/api/v1/clientes\
/api/v1/clientes/{cpf}

#### PUT
/api/v1/clientes/{cpf}

#### DELETE
/api/v1/cliente/{cpf}

## Empréstimos

#### POST
/api/v1/clientes/{cpf}/emprestimos

#### GET
/api/v1/clientes/{cpf}/emprestimos
/api/v1/clientes/{cpf}/emprestimos/{id}

#### PUT
/api/v1/clientes/{cpf}/emprestimos

#### DELETE
/api/v1/cliente/{cpf}/emprestimos/{id}
