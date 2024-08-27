
CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    cpf VARCHAR(45),
    renda_mensal DOUBLE PRECISION,
    saldo DOUBLE PRECISION,
    tipo_conta_id INTEGER REFERENCES tipo_conta(id)
);

CREATE TABLE tipo_conta (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

-- Questão: Há como reduzir?
CREATE TABLE movimentacao_conta (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    dt_criacao Timestamp,
    tipo_movimentacao_saida BIT,
    conta_id INTEGER REFERENCES conta(id)
);