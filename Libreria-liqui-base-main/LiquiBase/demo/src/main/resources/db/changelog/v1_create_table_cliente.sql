--liquibase formatted sql
--changeset Carlos-Bliblioteca:1

CREATE TABLE cliente(
    id SERIAL PRIMARY KEY ,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    telefono BIGINT


);