INSERT INTO cardapios (descricao_prato, preco)
VALUES
('Cardápio 1', 126.48),
('Cardápio 2', 204.48),
('Cardápio 3', 64.90);

INSERT INTO pratos (nome, descricao, preco, cardapio_id)
VALUES
('Carbonara', 'Massa preparada com ovos, variedade de queijos, toucinho, pimenta-preta e banha, azeite ou manteiga.', 42.00, 1),
('Feijoada', 'É servida com farofa, arroz branco, couve refogada e laranja fatiada', 54.99, 1),
('Strogonoff de frango', 'Arroz, frango, cebola e batata palha', 29.49, 1),
('Baião de dois', 'arroz com o feijão fradinho. A carne-seca, o queijo-coalho e a manteiga de garrafa', 65.49, 2),
('parmegiana', 'bife frito, composto por um pedaço de carne fatiado, empanado com farinha de trigo e ovos (clara de ovo), coberto com queijo do tipo parmesão e bastante molho de tomate ', 39.00, 2),
('Picanha com aligot', 'Arroz, picanha uruguaia servida com aligot l', 99.99, 2),
('Petit gateau', 'Bolo de chocolate, acompanhado de sorvete de creme', 29.00, 3),
('Salada de frutas', 'Mix de frutas, com frutas da estação ', 20.00, 3),
('Sorvetes', 'Bolas de sorvetes de sabores aleatorios', 15.90, 3);



