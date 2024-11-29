package com.example.demo.service;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.model.Prestamo;
import org.springframework.data.domain.Page;

public interface PrestamoService {
    PrestamoDto create (PrestamoDto prestamoDto);
    PrestamoDto update (PrestamoDto prestamoDto);
    void delete (Long id);
    Page<Prestamo> read(Integer pageSize, Integer pageNumber);
    Prestamo findById(Long id);

}
