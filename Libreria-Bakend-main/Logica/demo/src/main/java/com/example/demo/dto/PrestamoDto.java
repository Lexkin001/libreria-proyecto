package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto {
    private Long id;
    private Timestamp fecha;
    private Timestamp fechaF;
    private Long clienteId;
    private Long libroId;

}
