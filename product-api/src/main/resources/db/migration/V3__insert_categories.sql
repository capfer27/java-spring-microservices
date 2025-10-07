INSERT INTO products.category (id, name)
VALUES (1, 'Electronics')
ON CONFLICT (id)
DO UPDATE SET
    name = EXCLUDED.name
RETURNING id;

INSERT INTO products.category (id, name) VALUES (2, 'Furnitures')
ON CONFLICT (id)
DO UPDATE SET
    name = EXCLUDED.name
RETURNING id;
INSERT INTO products.category (id, name) VALUES (3, 'Toys')
ON CONFLICT (id)
DO UPDATE SET
    name = EXCLUDED.name
RETURNING id;