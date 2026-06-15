# Mentoria Backend

Projeto backend em Java 21 com Spring Boot, Spring Data JPA, MySQL e Swagger/OpenAPI.

## O que foi implementado

- Java 21
- Spring Boot 3.5.14
- Maven
- Spring Web
- Spring Data JPA
- Bean Validation
- Springdoc OpenAPI / Swagger UI
- MySQL Connector/J 5.1.49 para compatibilidade com bancos MySQL antigos
- `application.properties` em formato `.properties`, não YAML
- CRUD para todas as tabelas informadas
- Exclusão lógica: `DELETE` não remove o registro fisicamente; apenas marca o respectivo campo de status como `-1`
- Filtro de consulta: endpoints de busca/listagem não retornam registros com status `-1`
- Status padronizado:
  - `-1` = apagado logicamente
  - `0` = inativo
  - `1` = ativo

## Estrutura principal

```text
src/main/java/br/com/johnny/mentoria
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── id
├── repository
└── service
```

## Banco de dados

Crie o banco:

```sql
CREATE DATABASE mentoria CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Depois execute o arquivo:

```text
src/main/resources/schema.sql
```

O `schema.sql` foi deixado como referência e não será executado automaticamente, porque no `application.properties` está configurado:

```properties
spring.sql.init.mode=never
spring.jpa.hibernate.ddl-auto=none
```

## Configuração do banco

Arquivo:

```text
src/main/resources/application.properties
```

Configuração padrão:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mentoria?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=America/Sao_Paulo
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

Se o seu servidor for MySQL 5.7 ou superior e você quiser usar o conector moderno, troque no `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

E no `application.properties`:

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Como rodar

```bash
mvn spring-boot:run
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints CRUD

Todos os endpoints seguem o padrão:

```text
GET    /api/recurso
GET    /api/recurso/{id}
POST   /api/recurso
PUT    /api/recurso/{id}
DELETE /api/recurso/{id}
```

Recursos simples:

```text
/api/usuarios
/api/clientes
/api/mentores
/api/tecnologias
/api/publicacoes
/api/respostas-publicacoes
/api/metodos-pagamento
/api/pagamentos
/api/avaliacoes
/api/perguntas-cadastro
/api/opcoes-pergunta
/api/respostas-texto
/api/respostas-opcao
```

Recursos com chave composta:

```text
GET    /api/usuarios-tecnologias/{usuarioId}/{tecnologiaId}
PUT    /api/usuarios-tecnologias/{usuarioId}/{tecnologiaId}
DELETE /api/usuarios-tecnologias/{usuarioId}/{tecnologiaId}

GET    /api/publicacoes-tecnologias/{publicacaoId}/{tecnologiaId}
PUT    /api/publicacoes-tecnologias/{publicacaoId}/{tecnologiaId}
DELETE /api/publicacoes-tecnologias/{publicacaoId}/{tecnologiaId}
```

## Exemplos de JSON

### Criar usuário

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "tipoUsuario": 1,
  "dataCadastro": "2026-06-15",
  "status": 1
}
```

### Criar cliente

```json
{
  "stack": "Java, Spring, Angular",
  "descricao": "Cliente buscando mentoria para projeto web",
  "usuarioId": 1,
  "status": 1
}
```

### Criar mentor

```json
{
  "descricao": "Mentor backend Java",
  "precoHora": 150.0,
  "mediaAvaliacao": 5.0,
  "usuarioId": 2,
  "status": 1
}
```

### Criar publicação

```json
{
  "titulo": "Preciso de ajuda com Spring Boot",
  "conteudo": "Projeto com API REST e MySQL",
  "orcamentoMin": 300.00,
  "orcamentoMax": 800.00,
  "dataCriacao": "2026-06-15T10:30:00",
  "usuarioId": 1,
  "status": 1
}
```

### Criar pergunta de cadastro

```json
{
  "enunciado": "Qual sua stack principal?",
  "tipo": "texto",
  "status": 1
}
```

### Criar pergunta de múltipla escolha

```json
{
  "enunciado": "Qual seu nível de experiência?",
  "tipo": "multipla_escolha",
  "status": 1
}
```

## Observação importante sobre senha

A tabela original usa `usuario_senha VARCHAR(45)`. O projeto respeita essa estrutura, mas em produção o ideal é armazenar senha com hash forte, por exemplo BCrypt, e aumentar o tamanho da coluna.
