--liquibase formatted sql

--changeset vollystat:1
CREATE TABLE players (
 id SERIAL PRIMARY KEY,
 player_name VARCHAR NOT NULL UNIQUE
);

--changeset vollystat:2
INSERT INTO players (player_name) VALUES
 ('Poyan'),
 ('Pejman'),
 ('Reza P'),
 ('Reza B'),
 ('Sirus'),
 ('Mohsen'),
 ('Maks'),
 ('Shahram');

--changeset vollystat:3
INSERT INTO players (player_name) VALUES
 ('Mahan'),
 ('Oskan'),
 ('Hedi'),
 ('Saman');

--changeset vollystat:4
INSERT INTO players (player_name) VALUES
 ('Zafari');

--changeset vollystat:5
INSERT INTO players (player_name) VALUES
 ('Nima');