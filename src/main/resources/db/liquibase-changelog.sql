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
  team_name VARCHAR
);

--changeset vollystat:5
CREATE TABLE player_team_game (
  id SERIAL PRIMARY KEY,
  player_id INTEGER REFERENCES players(id),
  team_id INTEGER REFERENCES team(id) ON DELETE CASCADE,
  game_id INTEGER REFERENCES game(id) ON DELETE CASCADE
);

--changeset vollystat:6
CREATE TABLE game_result (
  game_id INTEGER REFERENCES game(id) ON DELETE CASCADE,
  team1_id INTEGER,
  team2_id INTEGER,
  team1_set_win INTEGER,
  team2_set_win INTEGER,
  team_won INTEGER
);

--changeset vollystat:7
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
 ('Nuri'),
 ('Sayed'),
 ('Mahan'),
 ('Shahram');