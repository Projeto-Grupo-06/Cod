-- Inserir usuários
INSERT INTO usuario (nome, sobrenome, cpf, email, data_nascimento, senha) VALUES
('Isabel', 'Novaes1 de Jesus', '57903074423', 'isabelnjesus@gmail.com', '1989-04-26', 'Hoje123!'),
('Claudio', 'Roberto Mainetti', '34391372363', 'cla.mainetti@gmail.com', '1971-01-19', 'rafa2627R!');

-- Inserir restaurantes
INSERT INTO restaurante (id, nome, cnpj, cep, endereco, numero, complemento, descricao, tipo, usuario_id) VALUES
(1, 'Kome Moema', '12345678901234', '12345678', 'R. Membeca', '64', 'casa na arvore', 'portão branco', 'residencia', 1);

-- Inserir Cardapio no restaurante 'Boca Torta'
INSERT INTO cardapio (imagem, restaurante_id) VALUES ('imagem_do_cardapio.jpg', 1);
