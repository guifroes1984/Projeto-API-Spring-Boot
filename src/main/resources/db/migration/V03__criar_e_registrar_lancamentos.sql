CREATE TABLE lancamento (
	id BIGSERIAL PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	idcategoria BIGINT NOT NULL,
	idpessoa BIGINT NOT NULL,
	FOREIGN KEY(idcategoria) REFERENCES categoria(id),
	FOREIGN KEY(idpessoa) REFERENCES pessoa(id)
);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, idcategoria, idpessoa)
VALUES ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1),
       ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'DESPESA', 2, 2),
       ('Top Club', '2017-06-10', null, 120, null, 'RECEITA', 3, 3),
       ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'RECEITA', 3, 4),
       ('DMAE', '2017-06-10', null, 200.30, null, 'DESPESA', 3, 5),
       ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'RECEITA', 4, 1),
       ('Bahamas', '2017-06-10', null, 500, null, 'RECEITA', 1, 2),
       ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'DESPESA', 4, 3),
       ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 4),
       ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'RECEITA', 5, 5),
       ('Café', '2017-06-10', null, 8.32, null, 'DESPESA', 1, 1),
       ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'DESPESA', 5, 2),
       ('Instrumentos', '2017-06-10', null, 1040.32, null, 'DESPESA', 4, 3),
       ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'DESPESA', 4, 4),
       ('Lanche', '2017-06-10', null, 10.20, null, 'DESPESA', 4, 5);