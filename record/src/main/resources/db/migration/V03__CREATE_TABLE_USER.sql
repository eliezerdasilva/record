CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    user_category VARCHAR(50) NOT NULL,
    cpf INT NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    date_birth DATE NOT NULL,
    endereco_id BIGINT,
    CONSTRAINT fk_user_address FOREIGN KEY (endereco_id) REFERENCES address(id)
);
