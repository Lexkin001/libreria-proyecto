--liquibase formatted sql
--changeset Carlos-Bliblioteca:1

CREATE TABLE libro (
  id SERIAL PRIMARY KEY ,
  nombre VARCHAR(255),
  descripcion VARCHAR(255),
  unidades INTEGER,
  autor_id int,
  disponible BOOLEAN,
  CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES autor(id)
);