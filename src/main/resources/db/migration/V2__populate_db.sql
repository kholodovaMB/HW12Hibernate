INSERT INTO client (name) VALUES
('Maryna'), ('Olga'), ('Dima'), ('Petro'), ('Mariya'),
('Katerina'), ('Andriy'), ('Pavlo'), ('Olena'), ('Igor');

INSERT INTO planet (id, name) VALUES
('MARS', 'Mars'), ('VEN', 'Venus'), ('EARTH', 'Earth'), ('JUP', 'Jupiter'), ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
(NOW(), 1, 'MARS', 'VEN'), (NOW(), 2, 'EARTH', 'MARS'), (NOW(), 3, 'VEN', 'SAT'),
(NOW(), 4, 'MARS', 'EARTH'), (NOW(), 5, 'SAT', 'JUP'),
(NOW(), 6, 'JUP', 'MARS'), (NOW(), 7, 'EARTH', 'SAT'),
(NOW(), 8, 'VEN', 'EARTH'), (NOW(), 9, 'JUP', 'VEN'), (NOW(), 10, 'EARTH', 'JUP');