CREATE TABLE IF NOT EXISTS CUSTOMER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    fone VARCHAR(20) NOT NULL,
    cnpj VARCHAR(30) NOT NULL UNIQUE,
    company_regular BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS address (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cep INT NOT NULL,
    state VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    road VARCHAR(255) NOT NULL,
    house_number VARCHAR(50) NOT NULL
);

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
CREATE TABLE IF NOT EXISTS registry (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    value DOUBLE NOT NULL,
    paid BOOLEAN NOT NULL,
    collection_point VARCHAR(255) NOT NULL,
    delivery_location VARCHAR(255) NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_registry_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
   
);
INSERT INTO customer (name, fone, cnpj, company_regular) VALUES
('Tech Solutions Ltda', '(11) 98765-4321', '12345678000195', TRUE),
('Mercado do Bairro', '(21) 99876-5432', '98765432000186', TRUE),
('Padaria Estrela', '(31) 98765-1234', '45678912000134', FALSE),
('Transportes Rápidos ME', '(41) 91234-5678', '65432198000176', TRUE);

INSERT INTO address (cep, state, city, neighborhood, road, house_number) VALUES
(12345678, 'SP', 'São Paulo', 'Centro', 'Avenida Paulista', '1000'),
(54321987, 'RJ', 'Rio de Janeiro', 'Copacabana', 'Rua Barata Ribeiro', '305'),
(87654321, 'MG', 'Belo Horizonte', 'Savassi', 'Rua da Bahia', '1200'),
(23456789, 'PR', 'Curitiba', 'Batel', 'Avenida do Batel', '500');

INSERT INTO user (name, user_category, cpf, email, date_birth, endereco_id) VALUES
('João Silva', 'Admin', 123456789, 'joao.silva@email.com', '1985-05-15', 1),
('Maria Oliveira', 'Gerente', 987654329, 'maria.oliveira@email.com', '1990-08-22', 2),
('Carlos Souza', 'Operador', 456789145, 'carlos.souza@email.com', '1988-11-30', 3),
('Ana Santos', 'Supervisor', 321698701, 'ana.santos@email.com', '1992-03-10', 4);

INSERT INTO registry (data, value, paid, collection_point, delivery_location, customer_id) VALUES
('2023-01-15', 1500.75, TRUE, 'Centro de Distribuição SP', 'Avenida Paulista, 1000', 1),
('2023-02-20', 2300.50, FALSE, 'Armazém RJ', 'Rua Barata Ribeiro, 305', 2),
('2023-03-10', 1800.25, TRUE, 'Galpão MG', 'Rua da Bahia, 1200', 3),
('2023-04-05', 3200.00, FALSE, 'Depósito PR', 'Avenida do Batel, 500', 4);