INSERT INTO medico (crm, nome, especialidade)
VALUES
    ('123456', 'Dr. House', 'Cardiologista'),
    ('234567', 'Dr. Cuddy', 'Endocrinologia'),
    ('345678', 'Dr. Wilson', 'Oncologia'),
    ('456789', 'Dr. Chase', 'Cirurgia'),
    ('567890', 'Dr. Cameron', 'Imunologia'),
    ('678901', 'Dr. Foreman', 'Neurologia');

INSERT INTO consulta (nome_paciente, data_hora, status, medico_id)
VALUES
    ('João', '2023-10-24 10:00:00', 'AGENDADA', 1),
    ('Maria', '2023-10-25 09:30:00', 'AGENDADA', 2),
    ('Pedro', '2023-10-26 14:00:00', 'AGENDADA', 3),
    ('Ana', '2023-10-27 15:30:00', 'CANCELADA', 4),
    ('Carlos', '2023-10-28 10:30:00', 'AGENDADA', 5),
    ('Lucia', '2023-10-29 11:00:00', 'FINALIZADA', 6);
