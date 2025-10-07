CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE IF NOT EXISTS products.product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    product_identifier VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    price FLOAT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY(category_id) REFERENCES products.category(id)
);