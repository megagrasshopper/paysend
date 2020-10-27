----------- User -----------
CREATE TABLE users
(
    login    VARCHAR(255) NOT NULL,
    password TEXT NOT NULL,
    balance   NUMERIC(10,2) NOT NULL DEFAULT 0,
    PRIMARY  KEY (login)
);
