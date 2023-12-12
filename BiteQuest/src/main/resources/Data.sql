-- Inserir usuários
INSERT INTO usuario (nome, sobrenome, cpf, email, data_nascimento, senha, has_dono, restaurante_id) VALUES
('Isabel', 'Novaes de Jesus', '57903074423', 'isabelnjesus@gmail.com', '1989-04-26', '$2a$10$0/TKTGxdREbWaWjWYhwf6e9P1fPOAMMNqEnZgOG95jnSkHSfkkIrC', false, NULL),
('Claudio', 'Roberto Mainetti', '34391372363', 'cla.mainetti@gmail.com', '1971-01-19', 'rafa2627', false, NULL);
-- ... outros usuários ...

-- Inserir restaurantes
INSERT INTO restaurante (nome, cnpj, cep, endereco, numero, complemento, descricao, tipo) VALUES
('Boca Torta', '12345678901234', '12345678', 'R. Membeca', '64', 'casa na arvore', 'portão branco', 'residencia');
-- ... outros restaurantes ...

-- Inserir cardápios
INSERT INTO cardapio (nome, preco, versao, deleted, restaurante_id) VALUES
('Macarronada', 10.99, 'Versão 1.0', false, 1),
('Nome do Cardápio 2', 15.50, 'Versão 2.0', false, 1);
-- ... outros cardápios ...
