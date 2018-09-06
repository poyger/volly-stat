CREATE TABLE players (
 id SERIAL PRIMARY KEY,
 player_name VARCHAR NOT NULL
);


INSERT INTO players (player_name) VALUES
 ('Poyan'),
 ('Pejman'),
 ('Reza P'),
 ('Reza B'),
 ('Sirus'),
 ('Mohsen');

select * from players;