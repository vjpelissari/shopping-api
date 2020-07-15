# shopping-api
API feita em Java para apresentação de um teste.


# Resumo e Status 
A aplicação consiste em fazer uma API para simular uma loja virtual e deve conter:

- Cadastro dos clientes - OK
- Cadastro dos produtos - OK
- Cadastro dos pedidos - Em andamento.


# Tecnologias e frameworks utilizados

- Sprint Boot (STS)
  Desenvolvimento da Aplicação

- Maven
  Gerenciador de Pacotes

- H2 
  Banco de dados em memória

- JPA 
  Para a camada de persistencia

- Postman
  Para testes na API

- Spring Security
  Utilizado para fazer a parte de autenticação da API

- GIT
  Para controle de versão.


# Pacotes criados:

- com.jantorno.shopping:
- com.jantorno.shopping.config
- com.jantorno.shopping.domain
- com.jantorno.shopping.handler
- com.jantorno.shopping.repository
- com.jantorno.shopping.resources
- com.jantorno.shopping.services
- com.jantorno.shopping.services.exceptions


# Exemplos de Endpoints da API

- GET - http://localhost:8080/produtos/
  Retorna uma lista com informações de todos os produtos

- GET - http://localhost:8080/produtos/1
  Retorna informações do produto de código 1

- GET - http://localhost:8080/clientes/
  Retorna uma lista com informações de todos os clientes

- GET - http://localhost:8080/clientes/
  Retorna uma lista com informações de todos os produtos

- POST - http://localhost:8080/produtos/
  Inclui um Produto

- POST - http://localhost:8080/clientes/
  Inclui um Cliente

- PUT - http://localhost:8080/produtos
  Atualiza dados de um cliente existente

- DELETE - http://localhost:8080/produtos/3
  Exclui o produto de ID 3


# Exemplo de retorno de erro pela API

 {
    "titulo": "O Cliente não pôde ser encontrado",
    "status": 404,
    "timestamp": 1593989802773,
    "mensagemDesenvolvedor": "http://erros.shopping.com/404"
 }
