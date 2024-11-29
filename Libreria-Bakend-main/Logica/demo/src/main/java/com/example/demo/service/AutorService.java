package com.example.demo.service;

import com.example.demo.dto.AutorDto;
import com.example.demo.model.Autor;
import com.example.demo.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AutorService {

    AutorDto create (AutorDto autorDto);
    AutorDto update (AutorDto autorDto);

    void delete (Long id);

    Page<Autor>read(Integer pageSize, Integer pageNumber);

    Autor findById(Long id);

}
