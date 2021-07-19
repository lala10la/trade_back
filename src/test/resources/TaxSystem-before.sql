TRUNCATE tax_systems CASCADE;

INSERT INTO tax_systems (id, name, sort_number)
VALUES (1, 'ОСН', '1'),
       (2, 'УСН.Доход', '2'),
       (3, 'УСН.Доход-Расход', '3');

SELECT setval('tax_systems_id_seq', max(id))
FROM tax_systems;