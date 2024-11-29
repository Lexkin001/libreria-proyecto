package com.example.demo.service;

import com.example.demo.dto.LibroDto;
import com.example.demo.model.Libro;
import org.springframework.data.domain.Page;

public interface LibroService {

    LibroDto create (LibroDto libroDto);
    LibroDto update (LibroDto libroDto);
    void delete (Long id);
    Page<Libro> read(Integer pageSize, Integer pageNumber);
    Libro findById(Long id);

}
