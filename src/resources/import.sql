DROP TABLE customers IF EXISTS;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Bred'), ('Pit'), ('Angelica');


DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 50), ('Bred', 30), ('Solt', 15), ('Soda', 12), ('Tea', 110);

DROP TABLE customers_products IF EXISTS;
CREATE TABLE customers_products (customer_id integer REFERENCES customers (id), product_id integer REFERENCES products (id));
INSERT INTO customers_products VALUES (1, 3), (1, 2), (3, 1), (2, 5), (2, 4), (2, 1), (2, 2), (2, 3), (2, 1);
