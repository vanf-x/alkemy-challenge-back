create database alkemy;
use alkemy;

select * from genero;
insert into genero(id, imagen, nombre)
values(1, null, 'Terror');
insert into genero(id, imagen, nombre)
values(2, null, 'Comedia');
insert into genero(id, imagen, nombre)
values(3, null, 'Historia');
insert into genero(id, imagen, nombre)
values(4, null, 'Drama');
insert into genero(id, imagen, nombre)
values(5, null, 'Suspenso');

select * from pelicula;
insert into pelicula(id, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(1, 3, '1998-04-21', null, 'Matrix', 5);
insert into pelicula(id, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(2, 4, '2001-08-14', null, 'El exorcista', 1);
insert into pelicula(id, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(3, 5, '2023-04-21', null, 'El club de la pelea', 4);
insert into pelicula(id, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(4, 1, '1965-12-01', null, 'La naranja mecánica', 2);
insert into pelicula(id, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(5, 2, '1988-12-25', null, 'Pulp Fiction', 3);

select * from personaje;
insert into personaje(id, edad, historia, imagen, nombre, peso)
values(1, 25, 'asdasdsadasdsadasd', null,'Diego Maradona', 48);
insert into personaje(id, edad, historia, imagen, nombre, peso)
values(2, 47, 'asdasdsadasdsadasd', null,'Mario Super', 78);
insert into personaje(id, edad, historia, imagen, nombre, peso)
values(3, 17, 'asdasdsadasdsadasd', null,'Alfredo Terecoechea', 66);
insert into personaje(id, edad, historia, imagen, nombre, peso)
values(4, 63, 'asdasdsadasdsadasd', null,'Peperino Pómoro', 95);
insert into personaje(id, edad, historia, imagen, nombre, peso)
values(5, 55, 'asdasdsadasdsadasd', null,'Francisco Maure', 75);

--
INSERT INTO personaje_pelicula (personaje_id, pelicula_id)
VALUES (1, 3);
INSERT INTO personaje_pelicula (personaje_id, pelicula_id)
VALUES (2, 5);
INSERT INTO personaje_pelicula (personaje_id, pelicula_id)
VALUES (3, 5);
INSERT INTO personaje_pelicula (personaje_id, pelicula_id)
VALUES (4, 5);
INSERT INTO personaje_pelicula (personaje_id, pelicula_id)
VALUES (4, 4);
--
-- qué personajes en película con id = 2
--
SELECT p.*
FROM personaje p
         JOIN personaje_pelicula pp ON p.id = pp.personaje_id
         JOIN pelicula pel ON pel.id = pp.pelicula_id
WHERE pel.id = 2