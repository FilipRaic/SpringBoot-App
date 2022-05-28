DROP TABLE IF EXISTS hardware;
CREATE TABLE hardware (
    id      IDENTITY PRIMARY KEY,
    code    VARCHAR(255) NOT NULL UNIQUE,
    name    VARCHAR(255) NOT NULL,
    type    VARCHAR(255) NOT NULL,
    amount  INT NOT NULL,
    price   DOUBLE NOT NULL
);

DROP TABLE IF EXISTS review;
CREATE TABLE review (
    id          IDENTITY PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    text        VARCHAR(624) NOT NULL,
    rating      INT NOT NULL,
    hardwareid  LONG
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id          IDENTITY PRIMARY KEY,
    username    VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    id              IDENTITY PRIMARY KEY,
    authority_name  VARCHAR(255)
);

DROP TABLE IF EXISTS user_authority;
CREATE TABLE user_authority (
    user_id      LONG NOT NULL,
    authority_id LONG NOT NULL
);