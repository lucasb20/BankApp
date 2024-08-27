
CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45),
    cpf CHAR(11),
    renda_mensal DOUBLE PRECISION,
    saldo DOUBLE PRECISION,
    tipo_conta_id INTEGER REFERENCES tipo_conta(id)
);

CREATE TABLE tipo_conta (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
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
    limite_credito DOUBLE PRECISION,
    conta_id INTEGER REFERENCES conta(id),
    numero_cartao CHAR(16),
    cvc smallint,
    tipo_cartao_fisico BIT,
)

CREATE TABLE movimentacao_credito (
    id SERIAL PRIMARY KEY,
    dt_criacao Timestamp,
    valor DOUBLE PRECISION,
    cartao_de_credito_id INTEGER REFERENCES cartao_de_credito(id),
)

CREATE TABLE compra (
    id SERIAL PRIMARY KEY,
    dt_criacao Timestamp,
    valor DOUBLE PRECISION,
    taxa_id INTEGER REFERENCES taxa(id)
)

CREATE TABLE taxa (
    id SERIAL PRIMARY KEY,
    quantidade_de_parcela smallint,
    porcentagem smallint
)