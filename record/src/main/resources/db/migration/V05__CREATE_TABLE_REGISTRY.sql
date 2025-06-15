CREATE TABLE IF NOT EXISTS registry (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    value DOUBLE NOT NULL,
    paid BOOLEAN NOT NULL,
    collection_point VARCHAR(255) NOT NULL,
    delivery_location VARCHAR(255) NOT NULL,
    customer_id BIGINT NOT NULL,
    driver_id BIGINT NOT NULL,
    CONSTRAINT fk_registry_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT fk_registry_driver FOREIGN KEY (driver_id) REFERENCES driver(id)
);