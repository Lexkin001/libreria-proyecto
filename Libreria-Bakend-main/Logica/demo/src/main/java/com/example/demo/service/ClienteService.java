package com.example.demo.service;

import com.example.demo.dto.ClienteDto;
import com.example.demo.model.Autor;
import com.example.demo.model.Cliente;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClienteService {
    ClienteDto create (ClienteDto clienteDto);
    ClienteDto update (ClienteDto clienteDto);
    void delete (Long id);

    Page<Cliente> read(Integer pageSize, Integer pageNumber);

    Cliente findById(Long id);

}
