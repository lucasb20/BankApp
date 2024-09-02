CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cpf CHAR(11) UNIQUE
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    fator_risco VARCHAR(45),
    renda_mensal DOUBLE PRECISION,
    pessoa_id INTEGER REFERENCES pessoa(id)
);

CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    saldo DOUBLE PRECISION,
    limite_negativo DOUBLE PRECISION,
    client_id INTEGER REFERENCES client(id),
    tipo_conta_id INTEGER REFERENCES tipo_conta(id)
);

CREATE TABLE tipo_conta (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE reserva (
    id SERIAL PRIMARY KEY,
    saldo DOUBLE PRECISION,
    taxa DOUBLE PRECISION,
    reservacol VARCHAR(45),
    conta_id INTEGER REFERENCES conta(id),
);

CREATE TABLE movimentacao_reserva (
    id SERIAL PRIMARY KEY,
    dt_movimentacao Timestamp,
    valor DOUBLE PRECISION,
    tipo_movimentacao VARCHAR(45),
    reserva_id INTEGER REFERENCES reserva(id),
);

CREATE TABLE movimentacao_conta (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    dt_movimentacao Timestamp,
    tipo_movimentacao VARCHAR(45),
    conta_id INTEGER REFERENCES conta(id)
);

CREATE TABLE categoria_cartao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE cartao_credito (
    id SERIAL PRIMARY KEY,
    dt_fechamento Timestamp,
    conta_id INTEGER REFERENCES conta(id),
    categoria_cartao_id INTEGER REFERENCES categoria_cartao(id)
);