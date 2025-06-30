CREATE TABLE registry (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    value DOUBLE NOT NULL,
    paid BOOLEAN NOT NULL,
    collection_point VARCHAR(255),
    delivery_location VARCHAR(255),
    customer_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    fone VARCHAR(255) NOT NULL,
    cnpj VARCHAR(255) NOT NULL UNIQUE,
    company_regular BOOLEAN NOT NULL
);

INSERT INTO customer (name, fone, cnpj, company_regular)
VALUES 
  ('Empresa A', '11999999999', '12345678901234', true),
  ('Transportadora B', '21988888888', '98765432109876', false);
-- Supondo que você já tenha esses customers:
-- INSERT INTO customer (id, name) VALUES (1, 'João'), (2, 'Maria');

INSERT INTO registry (data, value, paid, collection_point, delivery_location, customer_id)
VALUES 
  ('2025-06-10', 150.75, true, 'Centro de Distribuição A', 'Rua das Flores, 123', 1),
  ('2025-06-12', 80.00, false, 'Galpão B', 'Av. Brasil, 456', 2),
  ('2025-06-14', 200.00, true, 'Depósito C', 'Rua Nova, 789', 1);
