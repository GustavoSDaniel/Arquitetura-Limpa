CREATE TABLE pin (
    id BIGSERIAL PRIMARY KEY,
    pin VARCHAR(50) NOT NULL,
    quantidade_de_tentativa INT NOT NULL,
    bloqueado BOOLEAN NOT NULL,
    criando_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizando_at TIMESTAMP
);