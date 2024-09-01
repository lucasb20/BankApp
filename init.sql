
CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    cpf CHAR(11) UNIQUE,
    renda_mensal DOUBLE PRECISION,
    saldo DOUBLE PRECISION
);

CREATE TABLE movimentacao_conta (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    dt_criacao Timestamp,
    tipo_movimentacao_saida BIT,
    conta_id INTEGER REFERENCES conta(id)
);

CREATE TABLE cartao_de_credito (
    id SERIAL PRIMARY KEY,
    dt_fechamento Timestamp,
    dt_limite Timestamp,
    limite_credito DOUBLE PRECISION,
    conta_id INTEGER REFERENCES conta(id),
    numero_cartao CHAR(16),
    cvc smallint,
    tipo_cartao_fisico BIT
);

CREATE TABLE movimentacao_credito (
    id SERIAL PRIMARY KEY,
    dt_criacao Timestamp,
    valor DOUBLE PRECISION,
    quantidade_de_parcelas smallint,
    cartao_de_credito_id INTEGER REFERENCES cartao_de_credito(id)
);

CREATE TABLE fatura (
    id SERIAL PRIMARY KEY,
    valor_total DOUBLE PRECISION,
    dt_criacao Timestamp,
    cartao_de_credito_id INTEGER REFERENCES cartao_de_credito(id),
    is_paid bit
);