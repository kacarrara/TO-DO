# APP TO-DO

Aplicativo de listagem de tarefas feita em Spring Boot .
Autora: Karina Diego Carrara
Tecnologias:
•	Linguagem de programação JAVA
•	Banco de dados em memória H2
•	Lombok Project
•	Spring Boot
•	Spring Data JPA



Endpoints desenvolvidos:



Categorias:
•	GET:
Lista todas as categorias: http://localhost:8080/app/categorias/todas
Busca uma categoria: http://localhost:8080/app/categorias/buscar/{id}
Remove uma categoria: http://localhost:8080/app/categorias/delete/{id}
•	POST:
Salva uma categoria: http://localhost:8080/app/categorias/salvar




Tarefas:
•	GET:
Lista todas as tarefas: http://localhost:8080/app/tarefas/todas
Busca uma tarefa: http://localhost:8080/app/tarefas/buscar/{id}
Remove uma tarefa: http://localhost:8080/app/tarefas/delete/{id}
Inicia uma tarefa: http://localhost:8080/app/tarefas/fazer/{id}
Finaliza uma tarefa: http://localhost:8080/ap/tarefas/finalizar/{id}
Busca tarefa por categoria: http://localhost:8080/app/por-categoria/{idcategoria}
Busca tarefa por usuário: http://localhost:8080/app/por-usuario/{idcusuario}
Busca tarefa por data: http://localhost:8080/app/por-data
Cadastrar nova tarefa: http://localhost:8080/app/cadastrarnovatarefa
•	PUT:
Alterar uma tarefa: http://localhost:8080/app/alterartarefa
•	POST:
Salva uma Tarefa: http://localhost:8080/app/tarefas/salvar



Usuários:
•	GET:
Lista todos os usuários: http://localhost:8080/app/usuários/todos
Busca um usuário: http://localhost:8080/app/usuários/buscar/{id}
Remove um usuário: http://localhost:8080/app/usuários/delete/{id}
•	POST:
Salva um usuário: "http://localhost:8080/app/usuários/salvar"



JSON’S:

USUARIO: JSON: { "id":value, "email":"value@value", "nome":"value" }
TAREFA: JSON: { "id":value, "tarefa":"value", "categorias":{"id":"value"}, "usuarios":[{"id":"value"}] }
CATEGORIA: JSON: { "id":value, "descricao":"value" }


