-- Inserir usuários
INSERT INTO usuario (nome, sobrenome, cpf, email, data_nascimento, senha) VALUES
('Isabel', 'Novaes de Jesus', '57903074423', 'isabelnjesus@gmail.com', '1989-04-26', 'hoje123'),
('Claudio', 'Roberto Mainetti', '34391372363', 'cla.mainetti@gmail.com', '1971-01-19', 'rafa2627');
-- ... outros usuários ...

-- Inserir restaurantes
INSERT INTO restaurante (id, nome, cnpj, cep, endereco, numero, complemento, descricao, tipo, comentario, usuario_id) VALUES
(1, 'Boca Torta', '12345678901234', '12345678', 'R. Membeca', '64', 'casa na arvore', 'portão branco', 'residencia', 'Comentário sobre o restaurante', 1);
-- ... outros restaurantes ...

-- ... outras associações ...

-- Inserir Cardapio no restaurante 'Boca Torta'
INSERT INTO cardapio (imagem, restaurante_id) VALUES ('imagem_do_cardapio.jpg', 1);
