CREATE TABLE carteira (
    id BIGSERIAL PRIMARY KEY,
    saldo DECIMAL(10, 2) NOT NULL,
    usuario_id BIGINT NOT NULL UNIQUE,
    pin_id BIGINT NOT NULL UNIQUE,
    criando_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizando_at TIMESTAMP,

    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (pin_id) REFERENCES pin(id)
);