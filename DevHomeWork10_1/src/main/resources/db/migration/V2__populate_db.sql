INSERT INTO client (id, name) VALUES
    (1, 'Client 1'),
    (2, 'Client 2'),
    (3, 'Client 3'),
    (4, 'Client 4'),
    (5, 'Client 5'),
    (6, 'Client 6'),
    (7, 'Client 7'),
    (8, 'Client 8'),
    (9, 'Client 9'),
    (10, 'Client 10');

INSERT INTO planet (id, name) VALUES
    ('MARS1', 'Mars'),
    ('VEN2', 'Venus'),
    ('MER3', 'Mercury'),
    ('SAT4', 'Saturn'),
    ('PLUTO5', 'Pluto');

INSERT INTO ticket (id, created_at, client_id, from_planet_id, to_planet_id) VALUES
    (1, '2023-08-09 12:00:00', 1, 'MARS1', 'VEN2'),
    (2, '2023-08-10 14:00:00', 2, 'VEN2', 'MARS1'),
    (3, '2023-08-10 14:00:00', 3, 'VEN2', 'SAT4'),
    (4, '2023-08-10 14:00:00', 4, 'SAT4', 'MARS1'),
    (5, '2023-08-10 14:00:00', 5, 'MER3', 'MARS1'),
    (6, '2023-08-10 14:00:00', 6, 'VEN2', 'MER3'),
    (7, '2023-08-10 14:00:00', 7, 'PLUTO5', 'MARS1'),
    (8, '2023-08-10 14:00:00', 8, 'VEN2', 'PLUTO5'),
    (9, '2023-08-10 14:00:00', 9, 'VEN2', 'PLUTO5'),
    (10, '2023-08-15 09:00:00', 10, 'MARS1', 'PLUTO5');