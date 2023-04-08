create database alkemy;
use alkemy;

select * from genero;
insert into genero(id, activo, imagen, nombre)
values(1, 1, null, 'Terror');
insert into genero(id, activo, imagen, nombre)
values(2, 1, null, 'Comedia');
insert into genero(id, activo, imagen, nombre)
values(3, 1, null, 'Bizarro');
insert into genero(id, activo, imagen, nombre)
values(4, 1, null, 'Suspenso');
insert into genero(id, activo, imagen, nombre)
values(5, 0, null, 'Drama');

select * from pelicula;
insert into pelicula(id, activo, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(1, 1, 3, '1998-04-21', null, 'Matrix', 5);
insert into pelicula(id, activo, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(2, 1, 4, '2001-08-14', null, 'El exorcista', 1);
insert into pelicula(id, activo, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(3, 1, 5, '2023-04-21', null, 'Pinocho', 4);
insert into pelicula(id, activo, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(4, 1, 1, '1965-12-01', null, 'La naranja mecánica', 2);
insert into pelicula(id, activo, calificacion, fecha_de_creacion, imagen, titulo, genero_id)
values(5, 0, 2, '1988-12-25', null, 'Bañeros locos', 3);

select * from personaje;
select * from personaje;
insert into personaje(id, activo, edad, historia, imagen, nombre, peso)
values(1, 1, 25, 'asdasdsadasdsadasd', null,'Diego Maradona', 48);
insert into personaje(id, activo,  edad, historia, imagen, nombre, peso)
values(2, 1, 47, 'asdasdsadasdsadasd', null,'Mario Super', 78);
insert into personaje(id, activo,  edad, historia, imagen, nombre, peso)
values(3, 1, 17, 'asdasdsadasdsadasd', null,'Peperino Pómoro', 66);
insert into personaje(id, activo,  edad, historia, imagen, nombre, peso)
values(4, 1, 63, 'asdasdsadasdsadasd', null,'Juan Valdés', 95);
insert into personaje(id, activo,  edad, historia, imagen, nombre, peso)
values(5, 0, 55, 'asdasdsadasdsadasd', null,'Duke Nuken', 75);

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