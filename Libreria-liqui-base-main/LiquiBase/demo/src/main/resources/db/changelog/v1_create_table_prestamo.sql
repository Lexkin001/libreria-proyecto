--liquibase formatted sql
--changeset Carlos-Bliblioteca:1

CREATE TABLE prestamo(
  id SERIAL PRIMARY KEY ,
  fecha TIMESTAMP,
  fechaF TIMESTAMP,
  cliente_id INT,
  libro_id INT,
  CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  CONSTRAINT fk_libro FOREIGN KEY (libro_id) REFERENCES libro(id)
);