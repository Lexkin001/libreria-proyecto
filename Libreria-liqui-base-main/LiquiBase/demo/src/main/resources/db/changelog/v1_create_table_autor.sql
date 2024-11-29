--liquibase formatted sql
--changeset Carlos-Bliblioteca:1

CREATE TABLE autor(
  id SERIAL PRIMARY KEY ,
  nombre VARCHAR(255),
  edad INTEGER,
  libro VARCHAR


);