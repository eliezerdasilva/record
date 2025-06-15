#  📅 record - Sistema de agenda de serviços de fretes
Esse sistema foi desenvolvido para avaliação prática na disciplina de POO II do IFC.

Sistema de gerenciamento de serviços de uma transportadora, desenvolvido em Java com o framework Spring Boot.

O objetivo principal do sistema é facilitar a organização e gerenciamento de fretes. 


---
## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web (API REST)
  - Spring Data JPA (ORM)
  - Bean Validation (validação de campos)
- **Hibernate**
- **MySQL** (banco de dados relacional)
- **Lombok**
- **Maven** (gerenciamento de dependências)
- **Spring tools** (IDE)
- **Insomnia** 
- **ModelMapper**
---  

## 🎯 Funcionalidades

- Cadastro de serviços de fretes
- Edição e remoção de serviços
- Listagem de todos os fretes
- Busca de serviço por ID
- Validação automática de campos obrigatórios
- Busca de cliente por ID
- Cadastro de Usuário/funcionário

## 📂 Estrutura do Projeto

record/<br>
│<br>
├── src/main/java/com/example/record/<br>
│ │<br>
│ ├── controller/ -> Controllers REST responsáveis pelas rotas da API (ex.: RegistryController)<br>
│ ├── service/ -> Camada de regras de negócio (ex.: RegistryService)<br>
│ ├── repository/ -> Camada de acesso a dados com Spring Data JPA (ex.: RegistryRepository)<br>
│ ├── model/ -> Entidades JPA que representam as tabelas do banco (ex.: Registry, User)<br>
│ ├── dtos/ -> Objetos de Transferência de Dados (DTOs) (ex.: RegistryDTO)<br>
│ ├── mapper/ -> Conversores de DTOs para entidades e vice-versa (ex.: RegistryMapper)<br>
│ ├── enums/ -> Enumerações usadas no domínio (ex.: StatusEnum, TipoFreteEnum)<br>
│ └── exception/ -> Tratamento global de exceções e mensagens de erro personalizadas<br>
│<br>
├── src/main/resources/<br>
│ │<br>
│ ├── db/migration/ -> Scripts de migração do banco (ex.: V1__CREATE_TABLE_CUSTOMER.sql) <br>
│ └── application.properties -> Arquivo principal de configuração da aplicação (banco, portas, logs, etc.)<br>
│<br>
├── pow.xql -> (Provavelmente o arquivo de dependências gerado — se não usado, pode ser removido)<br>
│<br>
└── Insomia_2025-05-19.json -> Arquivo de exportação das rotas de teste (Coleção do Insomnia/Postman)<br>


## ⚙️Configuração do Banco de dados 
**Primeiro é necessário criar o banco de dados no mysql!**

- URL de conexão com o banco de dados <br>
spring.datasource.url=jdbc:mysql://localhost:3306/(nomedobanco)

- Usuário e senha do banco<br>
spring.datasource.username=seu_usuario<br>
spring.datasource.password=sua_senha

- Configuração do JPA/Hibernate <br> 
spring.jpa.hibernate.ddl-auto = update     <br>
spring.jpa.show-sql=true               


## 📦 Como Executar o Projeto
### Pré-requisitos
- Java 17 instalado

- MySQL configurado

- Maven instalado
- Em algumas IDE o lombok é necessário baixar. 

### Passos
1️⃣ Clone o repositório:

git clone https://github.com/eliezerdasilva/record.git <Br>
cd record <br>

2️⃣ Configure o banco de dados em application.properties<br>

3️⃣ Execute o banco de dados

3️⃣ Execute o projeto:
mvn spring-boot:run

4️⃣Import o json no Insommia para acessar as api`s


## 👨‍💻 Autor
Eliézer Silva <br>

<p><a href="https://www.linkedin.com/in/eliezer-da-silva/">Linkedin</a></p>
