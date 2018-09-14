--liquibase formatted sql

--changeset vollystat:2
CREATE TABLE players (
 id SERIAL PRIMARY KEY,
 player_name VARCHAR NOT NULL UNIQUE
);

--changeset vollystat:3
CREATE TABLE game (
 id SERIAL PRIMARY KEY,
 date DATE NOT NULL UNIQUE
);

--changeset vollystat:4
CREATE TABLE team (
  id SERIAL PRIMARY KEY,
  game_id INTEGER REFERENCES game(id) ON DELETE CASCADE,
  team_name CHAR,
  player_id INTEGER REFERENCES players(id)
);

--changeset vollystat:5
CREATE TABLE game_result (
  game_id INTEGER REFERENCES game(id) ON DELETE CASCADE,
  team1_id INTEGER,
  team2_id INTEGER,
  team1_set_win_id INTEGER,
  team2_set_win INTEGER,
  team_won INTEGER
);

--changeset vollystat:6
INSERT INTO players (player_name) VALUES
 ('Poyan'),
 ('Pejman'),
 ('Reza P'),
 ('Reza B'),
 ('Sirus'),
 ('Mohsen'),
 ('Maks'),
 ('Oskan'),
 ('Saman'),
 ('Hedi'),
 ('Zafari'),
 ('Nima'),
 ('Sayed'),
 ('Mahan'),
 ('Shahram');