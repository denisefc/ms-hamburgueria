CREATE TABLE produto(
    id BIGINT AUTO_INCREMENT,
    nome TEXT NOT NULL,
    preco DOUBLE NOT NULL,
    promocao TEXT,
    promocao_id BIGINT,

    primary key (id)
)