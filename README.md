
Sistema de Gestão de Brinquedos - Empresa XYZ

Este é um projeto de sistema de gerenciamento de brinquedos para uma empresa que atende crianças de até 12 anos. O sistema foi desenvolvido utilizando o framework Spring Security MVC em Java, configurado com Maven, e usa o banco de dados PostgreSQL. O projeto permite que os usuários registrem novos brinquedos, consultem a lista de brinquedos, atualizem informações e excluam registros, implementando todas as operações CRUD (Create, Read, Update, Delete).


Funcionalidades do Sistema
•	Cadastro de brinquedos: Permite que novos brinquedos sejam registrados no sistema.
•	Consulta de brinquedos: Os brinquedos cadastrados podem ser consultados pelo nome ou ID.
•	Atualização de brinquedos: Permite que os brinquedos cadastrados tenham suas informações atualizadas.
•	Exclusão de brinquedos: Brinquedos podem ser removidos do sistema.
•	Autenticação e Autorização: O sistema implementa um controle de acesso via Spring Security, com login e registro de novos usuários.

Tecnologias Utilizadas
•	Linguagem: Java 17
•	Framework: Spring Boot e Spring Security
•	Banco de Dados: PostgreSQL
•	Segurança: Criptografia de senha com BCrypt via Spring Security
•	Gerenciador de Dependências: Maven
•	IDE Utilizada: Eclipse IDE
•	Outras Dependências: Lombok para reduzir o código boilerplate.

Desenvolvimento do Aplicativo
Estrutura do Projeto
A estrutura do projeto foi desenvolvida utilizando o padrão MVC (Model-View-Controller), onde:
•	Model: Contém as entidades que representam as tabelas no banco de dados. Por exemplo, a entidade Brinquedo representa a tabela de brinquedos no banco de dados PostgreSQL.
•	View: Usa o mecanismo de templates Thymeleaf para renderizar as páginas HTML que o usuário final interage.
•	Controller: Contém as classes responsáveis por receber as requisições HTTP e enviar respostas adequadas, como carregar a lista de brinquedos, ou salvar um novo brinquedo no banco de dados.

Endpoints CRUD
Os endpoints implementados seguem as operações básicas do CRUD:
•	Read (Consultar brinquedo): GET /brinquedos/{id}
•	Update (Atualizar brinquedo): PUT /brinquedos/edit/{id}
•	Delete (Excluir brinquedo): DELETE /brinquedos/delete/{id}

Configuração do Banco de Dados

A configuração do banco de dados é realizada no arquivo application.properties.
 

Implementação da Tela de Login e Segurança
Para proteger as rotas sensíveis do sistema, como as operações de criação, edição e exclusão de brinquedos, foi implementado o Spring Security, garantindo que apenas usuários autenticados possam acessar essas funcionalidades. A configuração do banco de dados é realizada no arquivo


Implementação do Spring Security
A classe SecurityConfig.java foi criada para configurar o Spring Security:
 

Tela de Login Customizada
O Spring Security permite customizar a tela de login, em vez de utilizar o formulário padrão. O arquivo login.html foi criado usando Thymeleaf e serve como página de autenticação.
 
 
Exemplo de Acesso às Rotas Protegidas
Ao tentar acessar qualquer rota protegida, como /brinquedos/new, o sistema redirecionará para a página de login. Se o login for bem-sucedido, o usuário poderá acessar as funcionalidades CRUD:
1.	Página de Login: Insira o nome de usuário e a senha.
2.	Acesso às funcionalidades CRUD: Após o login, você será redirecionado para as páginas de criação, edição ou exclusão de brinquedos.
Exemplo:
•	Acesse: http://localhost:8080/brinquedos/new
•	Ao ser redirecionado para a página de login, insira as credenciais.
•	Após autenticação, você poderá acessar o formulário de criação de um novo brinquedo.

Implementação da Tela de Registro (Sign Up)
Além da tela de login, foi implementada uma página de registro para permitir que novos usuários se cadastrem.
•	Rota de registro: /signup
•	Tela de registro (HTML): signup.html

Exemplo de Registro:
1.	Acesse a rota /signup.
2.	Preencha o formulário com nome de usuário e senha.
3.	O usuário será registrado no banco de dados e redirecionado para a página de login.
Deploy do Projeto
O projeto foi implementado com as configurações de segurança e as funcionalidades CRUD. Ele pode ser feito o deploy na plataforma do AZURE.

Nesses dois link temos a parte 1 e a parte 2 do projeto.
brinquedos-f3ejckbffhbyhzd5.brazilsouth-01.azurewebsites.net
brinquedopart2-e7ddhcgsavekbbge.brazilsouth-01.azurewebsites.net
Como Executar o Projeto Localmente
1.	Clone o repositório do GitHub.
2.	Configure o PostgreSQL com as credenciais adequadas no arquivo application.yml.
3.	Compile e execute o projeto na IDE escolhida (Eclipse).
4.	Acesse as rotas via navegador: /login, /signup, /brinquedos/new.


 

 
![image](https://github.com/user-attachments/assets/167398a5-8aa8-403e-8c06-0f108d453751)
