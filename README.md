<h1 align="center"> Plan Api </h1>

<p align="center">
   Uma aplicação utilizando Java e Spring Boot de uma API REST, onde manter cadastro de beneficiários de um plano de saúde, de acordo com o diagrama de classe abaixo:
</p>

## Diagrama de classe
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/49403c21-a3ca-49fc-96d2-6c1a9b4b8482)<br>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Desenvolvimento</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Instruções</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Acessando o banco de dados H2 database</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>
<br>

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java
- Spring Boot
- H2 Database
- Postman
- SpringToolSuite4
- Git e Github
<br>

## 🧠 Desenvolvimento

O projeto foi desenvolvido, seguindo o diagrama de classe OneToMany, onde um beneficiário pode ter muitos documentos, e um documento um beneficiário.
O projeto foi desenvolvido em Spring Boot na versão 3 e Java na versão 17, sendo criado o projeto base no __Spring initializl__, com Maven Project como gerenciador de dependências.
A aplicação foi estudada e estruturada em pastas, seguindo a base de orientação a objetos e recursos do Java e Spring Boot.
Foram realizados testes em cada implementação de método no projeto, para validar todas as requisições REST solicitadas para a API.
Foi utilizado o H2 database, como banco de dados, para guardar dados, criar tabelas e relacionamento entre as tabelas.
Todos os beneficiários e documentos, estão com implementação para gerar ID´s automáticos, sem a precisão de inseri-los manualmente.
Utilizado o JPA, para Serealizar os dados em JSON para o banco de dados, e não haver inconsistência de dados ao enviar ao banco de dados.
Os nome das classes estão em ingês sendo benefiary para beneficiário e document para documento.
Para realizar os end points da aplicação, foi utilizado o Postman.

## ⚙️ Instruções

Para executar o projeto, utilizar a IDE SpringToolSuite4, expandir a pasta test, expandir a pasta src/main/java, expandir o pacote com.clientesaude.test, clicar com o botão direito no arquivo __TestApplication.java__,
ir até a opção Run As e escolher a opção Spring Boot App.

![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/29611bd0-0a65-474f-843f-4214ae61c46d)<br>

Para verificar se o projeto está funcionando corretamente, digite no campo de link do nagevador ou no Postman `http://localhost:8080`

### Requisições HTTP

Código  | Descrição
--- | ------
200 | OK
400 | Bad Request - Requisição Inválida
404 | Not Found - Não encontrado
500 | Internal Server Error - Erro interno do servidor

#### Método GET
Método GET `http://localhost:8080/beneficiaries`
Esta requisição irá retornar e listar dados de todos os beneficiários cadastrados no banco de dados

Há dois usuários cadastrados em "Hard code" para teste da API. Eles estão implementados no código, para verificação
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/5cb60b0b-a1df-4d1c-9914-4738fe2a38e8)<br>
Ao enviar a requisição para o banco de dados, ele retornou todos os usuários cadastrado no sistema
<br>

Método GET `http://localhost:8080/beneficiaries/id`
Esta requisição retorna um beneficiário a partir do seu id passado por parâmetro
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/aee7a2ba-35d4-43e1-9ff5-9b123ed8a47d)<br>
Ao enviar a requisição para o banco de dados, ele retornou o usuário cadastrado com o id 2 no sistema
<br>

Método GET `http://localhost:8080/beneficiaries/id/documents`
Esta requisição retorna todos os documentos de um beneficiários a partir do seu id passado por parâmetro
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/309055ad-ac25-44b1-9f1e-51c4d31dddbc)<br>
Ao enviar a requisição para o banco de dados, ele retornou todos os documentos do usuário cadastrado com o id 1 no sistema
<br>

#### Método POST
Método POST `http://localhost:8080/beneficiaries`
Esta requisição irá cadastrar um novo beneficiário com seus documentos


##### Exemplo de código
```
    {
	"name": "João",
	"phone": "(11)9999-9999",
	"dateOfBirth": "2000-10-15",
	"inclusionDate": "2002-07-18",
	"updateDate": "2002-07-18",
	"documents": [
		{
			"documentType": "RG",
			"description": "12.345.789.0",
			"inclusionDate": "2002-07-18",
			"updateDate": "2002-07-18"
		},
		
		{
			"documentType": "CPF",
			"description": "124.345.789.00",
			"inclusionDate": "2002-07-18",
			"updateDate": "2002-07-18"
		}
	]
}
```
Na requisição POST, é necessário realizar algumas configurações no Postman:

1° Verificar se na aba Headers está marcada a opção __Content-Type__
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/a4a60e05-e0f7-4b74-8ba4-38da7bb1abe0) <br>
2° Copiar o código de exemplo e colar na aba body. Marcando as opções raw e selecionando JSON
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/8439f5d2-7553-4cb2-bf6e-2de2c81d2775)
<br>

Após os procedimentos, enviar a requisição com os dados

![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/3759a089-bcbf-454f-ac28-70279b5d1b65)<br>

Ao enviar a requisição para o banco de dados, ele enviou os dados que foram cadastrado no body.

Ao listar os beneficiarios;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/6f3af895-c70a-4031-b0e1-23a4e94a8cc2)<br>

Listar os documentos do beneficiários;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/af329aec-9fad-472c-b46f-af5887d145bb)
<br>

#### Método PUT
Método PUT `http://localhost:8080/beneficiaries/{id}`
Esta requisição irá atualizar dados de um beneficiário, através do id passado por parâmetro

##### Exemplo de código
```
   {
        "name": "Maria Brown da Silva",
        "phone": "11999999999",
        "dateOfBirth": "2000-10-05",
        "inclusionDate": "2002-10-10",
        "updateDate": "2022-02-22",
        "documents": [
            {
                "id": 1,
                "documentType": "RG",
                "description": "12345678",
                "inclusionDate": "2000-10-05",
                "updateDate": "2001-07-10"
            },
            {
                "id": 3,
                "documentType": "CPF",
                "description": "777777777",
                "inclusionDate": "2021-01-12",
                "updateDate": "2021-01-12"
            }
        ]
    }
```

Dados de um beneficiário, antes de utilizar o método PUT;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/2c43a587-193c-4e75-9213-134c4184342b)<br>

Atualizando os dados;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/2cf1dd78-939b-40c4-bff5-a3ec7b6eb23a)

<br>

#### Método Delete
Método Delete `http://localhost:8080/beneficiaries/{id}`
Esta requisição irá retornar um beneficiário do sistema de cadastro, passando seu id como parâmetro

Ao enviar a requisição, os dados são apagados do body;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/d9382314-2dc8-4640-825e-4a9017a2ab0b)<br>

Listando todos os usuários;
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/e869c429-6eae-45a7-add0-624906517bf8)
<br>

## Acessando o banco de dados H2 database

Para acessar o banco de dados H2, digite na aba de link do navegador: `http://localhost:8080/h2-console`
Irá aparecer uma tela como esta:

![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/1f3d2a76-6fbb-455c-9745-aabdeeb37aea)<br>

Os dados de usuários, são padrões do H2, e estão no arquivo `application-test.properties`
Não é necessário alterar dados, somente clicar em conect

Há as duas tabelas criadas pelo o H2, __BENEFICIARY__ e __TB_DOCUMENT__
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/c2cf8245-27ab-45a7-8fa8-4adc189d28d8)<br>

Para executar comandos SQL, basta clicar em uma tabela e depois clicar em Run
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/fa3a1aef-7a8a-46c2-b15d-04b2bdeacde7)<br>

Para executar a outra tabela, basta clicar em clear e clicar em uma tabela e depois clicar em Run
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/bb436809-5d15-43c0-857c-ed370ef91331)
<br>


## :memo: Licença

Esse projeto está sob a licença MIT.

---
