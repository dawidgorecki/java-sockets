CREATE TABLE users
(
    id          bigint    NOT NULL PRIMARY KEY,
    nick        text      NOT NULL,
    login       text      NOT NULL UNIQUE,
    password    text      NOT NULL,
    insert_time timestamp NOT NULL DEFAULT now()
);

CREATE TABLE vehicles
(
    id          bigint    NOT NULL PRIMARY KEY,
    login       text      NOT NULL REFERENCES users (login),
    brand       text      NOT NULL,
    model       text      NOT NULL,
    insert_time timestamp NOT NULL DEFAULT now()
);

CREATE TABLE insurance_offers
(
    id          bigint    NOT NULL PRIMARY KEY,
    vehicle_id  bigint    NOT NULL REFERENCES vehicles (id),
    insurer     text      NOT NULL,
    price       float     NOT NULL,
    insert_time timestamp NOT NULL DEFAULT now()
);