# shopping-api
API feita em Java para apresentação de um teste.


# Resumo e Status 
A aplicação consiste em fazer uma API para simular uma loja virtual e deve ter:

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


# Explicação dos pacotes criados:

- com.jantorno.shopping:
  contem a classe de inicial para iniciar a execução do projeto.

- com.jantorno.shopping.config:
  contem a classe com a configuração das regras de autenticação (utilizado o Spring Security)

- com.jantorno.shopping.domain:
  pacote que contem as classes de model da aplicação (Cliente, Produto).
 
- com.jantorno.shopping.handler:
  contem uma classe handler responsável por detalhar o erro de uma forma amigável para o usuário da api, de acordo com a exption lançada.

- com.jantorno.shopping.repository:
  pacote que contem o padrão Repository para realizar a persistencia com o banco de dados.

- com.jantorno.shopping.resources:
  contem os controllers da aplicação, responsaveis pelo mapeamento dos recursos da API.

- com.jantorno.shopping.services:
  classes que contem a regra de negócio da aplicação

- com.jantorno.shopping.services.exceptions:
  classes de exceptions.


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
