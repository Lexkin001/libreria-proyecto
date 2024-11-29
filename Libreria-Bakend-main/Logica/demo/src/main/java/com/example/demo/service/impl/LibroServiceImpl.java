package com.example.demo.service.impl;

import com.example.demo.dto.LibroDto;
import com.example.demo.dto.transformer.LibroTransformer;
import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LibroServiceImpl implements LibroService {
    final LibroTransformer transformer;
    final LibroRepository repository;
    @Override
    public LibroDto create(LibroDto libroDto) {
        Libro libro = transformer.libroTransformerFromDto(libroDto);
        libro.setDisponible(libro.getUnidades() > 0); // Actualizar la disponibilidad
        libroDto = transformer.libroTransformerFromModel(repository.save(libro));
        return libroDto;
    }

    @Override
    public LibroDto update(LibroDto libroDto) {
        Libro libro = transformer.libroTransformerFromDto(libroDto);
        libro.setDisponible(libro.getUnidades() > 0); // Actualizar la disponibilidad
        libroDto = transformer.libroTransformerFromModel(repository.save(libro));
        return libroDto;
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Page<Libro> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Libro findById(Long id) {
        return repository.findById(id).get();
    }
}
