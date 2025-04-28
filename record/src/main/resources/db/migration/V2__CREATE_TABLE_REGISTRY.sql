CREATE TABLE REGISTRY (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    value DOUBLE,
    paid BOOLEAN,
    collection_point VARCHAR(255),
    delevery_location VARCHAR(255),
    customer_id BIGINT,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
);
