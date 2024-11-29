package com.example.demo.service.impl;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.dto.transformer.PrestamoTransformer;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Libro;
import com.example.demo.model.Prestamo;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.PrestamoRepository;
import com.example.demo.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoTransformer transformer;
    private final PrestamoRepository repository;
    private final LibroRepository libroRepository;

    @Override
    public PrestamoDto create(PrestamoDto prestamoDto) {
        Long libroId = prestamoDto.getLibroId();
        Libro libroA = libroRepository.findById(libroId).get();
        if (libroA == null || libroA.getUnidades() <= 0) {
            throw new ValidationException(
                    "No se ha encontrado el libro con el ID  " + prestamoDto.getLibroId(),
                    404,
                    "Not found",
                    "El ID/Codigo que usted agrego no se encuentra en  la tabla libros");


        }
        Prestamo prestamo = transformer.pretamoTransformerFroDto(prestamoDto);
            Optional<Libro> libroOptional = libroRepository.findById(prestamo.getLibroId());

            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
                if (libro.getUnidades() > 0) {
                    libro.setUnidades(libro.getUnidades() - 1);
                    if (libro.getUnidades() == 0) {
                        libro.setDisponible(false);
                    } else {
                        libro.setDisponible(true);
                    }
                    libroRepository.save(libro);
                }
            }


            prestamoDto = transformer.pretamoTransformerFroModel(repository.save(prestamo));
            return prestamoDto;

    }


    @Override
    public PrestamoDto update(PrestamoDto prestamoDto) {
        Prestamo prestamo = transformer.pretamoTransformerFroDto(prestamoDto);
        prestamoDto = transformer.pretamoTransformerFroModel(repository.save(prestamo));
        return prestamoDto;
    }

    @Override
    public void delete(Long id) {
        Optional<Prestamo> prestamoOptional = repository.findById(id);
        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();

            // 1. Aumentar el número de unidades del libro
            Optional<Libro> libroOptional = libroRepository.findById(prestamo.getLibroId());
            libroOptional.ifPresent(libro -> {
                libro.setUnidades(libro.getUnidades() + 1);
                libro.setDisponible(true); // El libro siempre estará disponible al devolverlo
                libroRepository.save(libro);
            });

            // 2. Eliminar el préstamo de la base de datos
            repository.deleteById(id);

        }
    }


    @Override
    public Page<Prestamo> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Prestamo findById(Long id) {
        return repository.findById(id).get();

    }
    }

