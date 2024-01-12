USE restaurant_db;

BEGIN;

CREATE TABLE customer (
    phone_number VARCHAR(12) NOT NULL,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    PRIMARY KEY (phone_number)
);

CREATE TABLE account (
    username VARCHAR(20) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    phone_number VARCHAR(12) NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (phone_number) REFERENCES customer (phone_number)
);

CREATE TABLE ingredient (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    fat_per_serving_size INT NOT NULL,
    protein_per_serving_size INT NOT NULL,
    carbohydrate_per_serving_size INT NOT NULL,
    calories_per_serving_size INT NOT NULL,
    CHECK (fat_per_serving_size >= 0),
    CHECK (protein_per_serving_size >= 0),
    CHECK (carbohydrate_per_serving_size >= 0),
    PRIMARY KEY (id)
);

CREATE TABLE category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE menu_item (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    description VARCHAR(250) NOT NULL,
    price DECIMAL(4, 2) NOT NULL,
    category_id INT NOT NULL,
    CHECK (price > 0.00),
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE menu_item_ingredient (
    menu_item_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    serving_size INT NOT NULL,
    CHECK (serving_size > 0),
    PRIMARY KEY (menu_item_id, ingredient_id),
    FOREIGN KEY (menu_item_id) REFERENCES menu_item (id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient (id)
);

CREATE TABLE favorite_menu_item (
    username VARCHAR(20) NOT NULL,
    menu_item_id INT NOT NULL,
    liked_at DATETIME NOT NULL,
    PRIMARY KEY (username, menu_item_id),
    FOREIGN KEY (username) REFERENCES account (username),
    FOREIGN KEY (menu_item_id) REFERENCES menu_item (id)
);

CREATE TABLE credit_card (
    id INT NOT NULL AUTO_INCREMENT,
    number VARCHAR(16) UNIQUE NOT NULL,
    holder VARCHAR(31) NOT NULL,
    expiration_month INT NOT NULL,
    expiration_year INT NOT NULL,
    PRIMARY KEY (id),
    CHECK (expiration_year >= 2024),
    CHECK (expiration_month >= 1 and expiration_month <= 12)
);

CREATE TABLE account_credit_card (
    username VARCHAR(20) NOT NULL,
    credit_card_id INT NOT NULL,
    PRIMARY KEY (username, credit_card_id),
    FOREIGN KEY (username) REFERENCES account (username),
    FOREIGN KEY (credit_card_id) REFERENCES credit_card (id)
);

CREATE TABLE payment (
    id VARCHAR(32) NOT NULL,
    total DECIMAL(6,2) NOT NULL,
    happened_at DATETIME NOT NULL,
    credit_card_id INT NULL,
    FOREIGN KEY (credit_card_id) REFERENCES credit_card (id) ON DELETE SET NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    salary INT NOT NULL,
    manager_id INT NULL,
    CHECK (salary > 50000),
    PRIMARY KEY (id),
    FOREIGN KEY (manager_id) REFERENCES employee (id)
);

CREATE TABLE employee_schedule (
    employee_id INT NOT NULL,
    weekday INT NOT NULL,
    shift_from TIME NOT NULL,
    shift_to TIME NOT NULL,
    CHECK (weekday >= 1 AND weekday <= 7),
    PRIMARY KEY (employee_id, weekday),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE online_order (
    id INT NOT NULL AUTO_INCREMENT,
    created_at DATETIME NOT NULL,
    completed_at DATETIME NULL,
    tip DECIMAL(5,2) NULL,
    payment_id VARCHAR(32) NULL,
    username VARCHAR(20) NOT NULL,
    employee_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (payment_id) REFERENCES payment (id),
    FOREIGN KEY (username) REFERENCES account (username),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE online_order_info (
    online_order_id INT NOT NULL,
    menu_item_id INT NOT NULL,
    quantity INT NOT NULL,
    CHECK (quantity > 0),
    PRIMARY KEY (online_order_id, menu_item_id),
    FOREIGN KEY (online_order_id) REFERENCES online_order (id),
    FOREIGN KEY (menu_item_id) REFERENCES menu_item (id)
);

COMMIT;