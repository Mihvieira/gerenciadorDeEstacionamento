# Gerenciador de Estacionamento

Este projeto consiste na criação de uma API para gerenciamento de estacionamento. Ele permite registrar a entrada e saída de veículos, calcular o tempo de permanência e o valor a ser cobrado.

A API foi desenvolvida utilizando GraphQL, o que permite consultas flexíveis e eficientes, possibilitando que os clientes obtenham exatamente os dados de que precisam em uma única requisição.

Esse projeto foi inspirado no desafio criado pela FCAMARA no link a seguir: [https://github.com/fcamarasantos/backend-test-java](Desafio).

## Funcionalidades

- Cadastro de empresa de estacionamento
- Cadastro de veículos e vagas
- Cadastro de registro de entrada e saída
- Consulta de veículos e vagas desocupadas/ocupadas
- Consulta de entradas e saídas com sua duração e valor cobrado

## Tecnologias Utilizadas

- Java 21 ou superior
- Spring Boot
- Spring Data JPA
- GraphQL
- H2 Database (para testes)
- Maven

## Configurações Necessárias

### Pré-requisitos

- Java 21 ou superior
- Maven

## Executando a Aplicação

1. Clone o repositório:

```
git clone https://github.com/Mihvieira/gerenciadorDeEstacionamento
cd gerenciadorDeEstacionamento
```

2. Compile e execute a aplicação usando Maven:

```
mvn clean install
mvn spring-boot:run
```

3. Acesse o console H2 para verificar o banco de dados:

* URL: <http://localhost:8080/h2-console>
* JDBC URL: jdbc:h2:mem:testdb
* User Name: sa
* Password: (deixe em branco)

## Chamadas dos Serviços

* Listar Estacionamentos
```
query {
  estacionamentos {
    id
    dadosEmpresa {
      nome
      cnpj
      telefone
    }
    endereco {
      logradouro
      bairro
      cidade
      uf
      complemento
      numero
    }
    qtdMaxMotos
    qtdMaxCarros
    precoPorHora
  }
}
```

* Buscar Estacionamento por ID

```
query($id: ID!) {
  estacionamentoPorId(id: $id) {
    id
    dadosEmpresa {
      nome
      cnpj
      telefone
    }
    endereco {
      logradouro
      bairro
      cidade
      uf
      complemento
      numero
    }
    qtdMaxMotos
    qtdMaxCarros
    precoPorHora
  }
}
```

##  Mutações (Mutations)

* Criar Estacionamento

```
mutation($input: EstacionamentoInput!) {
  criarEstacionamento(input: $input) {
    id
    dadosEmpresa {
      nome
      cnpj
      telefone
    }
    endereco {
      logradouro
      bairro
      cidade
      uf
      complemento
      numero
    }
    qtdMaxMotos
    qtdMaxCarros
    precoPorHora
  }
}
```

* Atualizar Estacionamento

```
mutation($id: ID!, $input: EstacionamentoInput!) {
  atualizarEstacionamento(id: $id, input: $input) {
    id
    dadosEmpresa {
      nome
      cnpj
      telefone
    }
    endereco {
      logradouro
      bairro
      cidade
      uf
      complemento
      numero
    }
    qtdMaxMotos
    qtdMaxCarros
    precoPorHora
  }
}
```

* Excluir Estacionamento

```
mutation($id: ID!) {
  excluirEstacionamento(id: $id)
}
```

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça o push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
