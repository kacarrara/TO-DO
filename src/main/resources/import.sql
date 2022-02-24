-- Inserir usuários ao iniciar
INSERT INTO USUARIO  (NOME, EMAIL) VALUES  ('Karina Diego Carrara', 'karinadcarrara@hotmail.com');
INSERT INTO USUARIO  (NOME, EMAIL) VALUES  ('Ivo', 'ivo@gmail.com');
INSERT INTO USUARIO  (NOME, EMAIL) VALUES  ('Marcos Araujo', 'marcos_araujo@gmail.com');

-- Inserir categorias ao iniciar
INSERT INTO CATEGORIA (DESCRICAO) VALUES  ('Viagem');
INSERT INTO CATEGORIA (DESCRICAO) VALUES  ('Trabalho');
INSERT INTO CATEGORIA (DESCRICAO) VALUES  ('Projetos');

-- Inserir tarefas ao iniciar
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-05-02', 'ABERTA', 'Viajar para praia', 1);
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-06-15', 'FAZENDO', 'lista de projetos Spring Boot', 2);
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-07-01', 'FINALIZADA', 'Finalizar meu primeiro projeto com Spring Boot', 3);


INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-05-02', 'ABERTA', 'Trabalhando com novos Projetos', 1);
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-06-15', 'ABERTA', 'Criando novos trabalhos', 2);
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-07-01', 'FAZENDO', 'Criar fluxo do Spring', 3);
INSERT INTO TAREFA (DATA_TAREFA, STATUS, TAREFA, CATEGORIA_ID) VALUES ('2019-07-01', 'FINALIZADA', 'Teste completo', 3);

-- Definir usuários e tarefas ao iniciar
INSERT INTO USUARIOS_TAREFAS VALUES (1, 1), (1, 2), (2, 2), (3, 3), (4, 1), (5, 2), (6, 2), (7, 3);

-- JOIN para consultar os dados inseridos:
-- SELECT t.*, u.*, c.*
-- FROM tarefa t
-- LEFT JOIN usuarios_tarefas uf ON uf.tarefa_id = t.id
-- LEFT JOIN usuario u ON uf.usuario_id = u.id
-- LEFT JOIN categoria c ON c.id = t.categoria_id



