CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cpf CHAR(11)
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    fator_risco VARCHAR(45),
    renda_mensal DOUBLE PRECISION,
    pessoa_id INTEGER REFERENCES pessoa(id)
);

CREATE TABLE tipo_conta (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    saldo DOUBLE PRECISION,
    limite_negativo DOUBLE PRECISION,
    client_id INTEGER REFERENCES client(id),
    tipo_conta_id INTEGER REFERENCES tipo_conta(id)
);

CREATE TABLE reserva (
    id SERIAL PRIMARY KEY,
    saldo DOUBLE PRECISION,
    taxa DOUBLE PRECISION,
    reservacol VARCHAR(45),
    conta_id INTEGER REFERENCES conta(id)
);

CREATE TABLE movimentacao_reserva (
    id SERIAL PRIMARY KEY,
    dt_movimentacao VARCHAR(45),
    valor DOUBLE PRECISION,
    tipo_movimentacao VARCHAR(45),
    reserva_id INTEGER REFERENCES reserva(id)
);

CREATE TABLE movimentacao_conta (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    dt_movimentacao VARCHAR(45),
    tipo_movimentacao VARCHAR(45),
    conta_id INTEGER REFERENCES conta(id)
);

CREATE TABLE categoria_cartao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE cartao_credito (
    id SERIAL PRIMARY KEY,
    dt_fechamento VARCHAR(45),
    conta_id INTEGER REFERENCES conta(id),
    categoria_cartao_id INTEGER REFERENCES categoria_cartao(id),
    limite_credito DOUBLE PRECISION
);

CREATE TABLE bandeira_cartao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE cartao_transacao (
    id SERIAL PRIMARY KEY,
    numero_cartao CHAR(20),
    cvc CHAR(3),
    cartao_credito_id INTEGER REFERENCES cartao_credito(id),
    tipo_cartao VARCHAR(45),
    nome_cartao VARCHAR(255),
    tipo_transacao VARCHAR(45),
    is_internacional BIT,
    bandeira_cartao_id INTEGER REFERENCES bandeira_cartao(id)
);

CREATE TABLE movimentacao_cartao (
    id SERIAL PRIMARY KEY,
    dt_movimentacao VARCHAR(45),
    valor DOUBLE PRECISION,
    cartao_transacao_id INTEGER REFERENCES cartao_transacao(id),
    tipo_movimentacao VARCHAR(45)
);

CREATE TABLE corretor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45)
);

CREATE TABLE compra (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    quantidade_parcela INTEGER,
    taxa_parcelamento DOUBLE PRECISION,
    credor VARCHAR(45),
    corretor_id INTEGER REFERENCES corretor(id),
    cartao_transacao_id INTEGER REFERENCES cartao_transacao(id),
    dt_compra VARCHAR(45)
);

CREATE TABLE fatura_cartao (
    id SERIAL PRIMARY KEY,
    mes_referencia VARCHAR(45),
    ano_referencia VARCHAR(45),
    valor DOUBLE PRECISION,
    dt_pagamento VARCHAR(45),
    cartao_credito_id INTEGER REFERENCES cartao_credito(id)
);

CREATE TABLE itens_fatura (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45),
    fatura_cartao_id INTEGER REFERENCES fatura_cartao(id)
);

CREATE TABLE tipo_boleto_customizado (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE boleto_customizado (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION,
    dt_vencimento VARCHAR(45),
    dt_geracao VARCHAR(45),
    codigo_barras VARCHAR(45),
    tipo_boleto_customizado_id INTEGER REFERENCES tipo_boleto_customizado(id),
    fatura_cartao_id INTEGER REFERENCES fatura_cartao(id)
);

CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    valor_total DOUBLE PRECISION,
    dt_pagamento VARCHAR(45),
    fatura_cartao_id INTEGER REFERENCES fatura_cartao(id),
    valor_parcial DOUBLE PRECISION,
    boleto_customizado_id INTEGER REFERENCES boleto_customizado(id)
);