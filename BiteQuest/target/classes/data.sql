INSERT INTO usuario
            (nome, sobrenome, cpf, email, data_nascimento, senha)
      VALUES
            ('Isabel', 'Novaes de Jesus', '57903074423', 'isabelnjesus@gmail.com', '1989-04-26','isa123'),
            ('Claudio', 'Roberto Mainetti', '34391372363', 'cla.mainetti@gmail.com', '1971-01-19', 'rafa2627'),
            ('José', 'Souza', '22382920203', 'jose.souza@gmail', '1999-01-01', 'teste01'),
            ('Ana', 'Oliveira', '06870865310', 'ana.oliveira@gmail', '2023-01-01', '1234'),
            ('Flavia', 'Cristina Pontes', '68462244919', 'flaviapontes@gmail.com', '2023-01-01', 'jesus@09'),
            ('Ana', 'Silva', '54279281386', 'ana.silva@gmail', '2023-01-01', '6574'),
            ('Carlos', 'Souza', '91470565099', 'carlos.souza@gmail', '2023-01-01', '0923'),
            ('Paulo', 'Oliveira', '76945482316', 'paulo.oliveira@gmail', '2023-01-01', 'abc'),
            ('Pedro', 'Silva', '16116793703', 'pedro.silva@gmail', '2023-01-01', 'cba'),
            ('Lucas', 'Santos', '53853768415', 'lucas.santos@gmail', '2023-01-01', '098'),
            ('Marcos', 'Souza', '33673381415', 'marcos.souza@gmail', '2023-01-01', 'a'),
            ('Marcos', 'Oliveira', '20358229634', 'marcos.oliveira@gmail', '2023-01-01', 'b');


-- Inserir um restaurante
INSERT INTO Restaurante
            (nome, cnpj, cep, endereco, numero, complemento)
      VALUES
      ('Boca Torta', '12345678901234', '12345678', 'R. Membeca', '64', '');

-- Inserir horários de funcionamento para um restaurante
INSERT INTO HorarioFuncionamento
            (dia_semana, horario_abertura, horario_fechamento, restaurante_id)
     VALUES
          ('Segunda', '08:00', '18:00', 1),
          ('Terça', '08:00', '18:00', 1),
          ('Quarta', '08:00', '18:00', 1),
          ('Quinta', '08:00', '18:00', 1),
          ('Sexta', '08:00', '18:00', 1);

-- Inserir cardápios para um restaurante
INSERT INTO Cardapio
            (nome, preco, versao, restaurante_id)
     VALUES
     ('Macarronada', 10.99, 'Versão 1.0', 1);

INSERT INTO Cardapio
            (nome, preco, versao, restaurante_id)
     VALUES
     ('Nome do Cardápio 2', 15.50, 'Versão 2.0', 2);