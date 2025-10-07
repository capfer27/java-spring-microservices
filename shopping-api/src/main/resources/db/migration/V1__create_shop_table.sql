CREATE SCHEMA IF NOT EXISTS shopping;

CREATE TABLE IF NOT EXISTS shopping.shop(
    id BIGSERIAL PRIMARY KEY,
    user_identifier VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL,
    total FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS shopping.item(
    shop_id BIGSERIAL REFERENCES shopping.shop(id),
    product_identifier VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL
);