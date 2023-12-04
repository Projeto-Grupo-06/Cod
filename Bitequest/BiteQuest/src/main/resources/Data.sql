-- Inserir usuários
INSERT INTO usuario (nome, sobrenome, cpf, email, data_nascimento, senha, has_dono, restaurante_id) VALUES
('Isabel', 'Novaes de Jesus', '57903074423', 'isabelnjesus@gmail.com', '1989-04-26', 'isa123', false, NULL),
('Claudio', 'Roberto Mainetti', '34391372363', 'cla.mainetti@gmail.com', '1971-01-19', 'rafa2627', false, NULL);
-- ... outros usuários ...

-- Inserir restaurantes
INSERT INTO restaurante (nome, cnpj, cep, endereco, numero, complemento) VALUES
('Boca Torta', '12345678901234', '12345678', 'R. Membeca', '64', '');
-- ... outros restaurantes ...

-- Inserir horários de funcionamento
INSERT INTO horario_funcionamento (dia_semana, horario_abertura, horario_fechamento, restaurante_id) VALUES
(1, '08:00', '18:00', 1), -- 1 representa Segunda-feira
(2, '08:00', '18:00', 1); -- 2 representa Terça-feira
-- ... outros horários ...

-- Inserir cardápios
INSERT INTO cardapio (nome, preco, versao, deleted, restaurante_id) VALUES
('Macarronada', 10.99, 'Versão 1.0', false, 1),
('Nome do Cardápio 2', 15.50, 'Versão 2.0', false, 1);
-- ... outros cardápios ...
