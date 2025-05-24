CREATE TABLE transacao (
    id BIGSERIAL PRIMARY KEY,
    para_carteira BIGINT NOT NULL,
    de_carteira BIGINT NOT NULL,
    valor_da_transacao DECIMAL(10, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    criando_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizando_at TIMESTAMP,

    FOREIGN KEY (para_carteira) REFERENCES carteira(id),
    FOREIGN KEY (de_carteira) REFERENCES carteira(id)
