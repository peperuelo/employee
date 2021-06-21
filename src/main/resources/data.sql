INSERT INTO Position (position_id, name)
VALUES (1, 'dev');

INSERT INTO Position (position_id, name)
VALUES (2, 'qa');

INSERT INTO Position (position_id, name)
VALUES (4, 'mierda');


INSERT INTO Person (person_id,name, last_name, address, cellphone, city_name)  VALUES (1,'Camilo','Ruiz','cra','124','Medellin');
INSERT INTO Person (person_id,name, last_name, address, cellphone, city_name)  VALUES (2,'Andres','Escobar','cra','1244','Envigado');
INSERT INTO Person (person_id,name, last_name, address, cellphone, city_name)  VALUES (3,'luis','perez','cra','124','Medellin');
INSERT INTO Person (person_id,name, last_name, address, cellphone, city_name)  VALUES (4,'pedro','castro','cra','1244','Envigado');

INSERT INTO Employee (id, person, position, salary) VALUES (1,1,1,2000);
INSERT INTO Employee (id, person, position, salary) VALUES (2,2,1,1000);
INSERT INTO Employee (id, person, position, salary) VALUES (4,3,2,1500);
INSERT INTO Employee (id, person, position, salary) VALUES (5,4,2,1000);