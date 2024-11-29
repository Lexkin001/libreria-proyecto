package com.example.demo.dto.transformer;

import com.example.demo.dto.LibroDto;
import com.example.demo.model.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroTransformer {

    public Libro libroTransformerFromDto(LibroDto libroDto){
        if (libroDto == null)return null;

        Libro libro = new Libro();
        libro.setId(libroDto.getId());
        libro.setNombre(libroDto.getNombre());
        libro.setDescripcion(libroDto.getDescripcion());
        libro.setUnidades(libroDto.getUnidades());
        libro.setAutorId(libroDto.getAutorId());
        libro.setDisponible(libroDto.getDisponible());
        return libro;
    }
    public LibroDto libroTransformerFromModel(Libro libro){
        if (libro == null)return null;

        LibroDto dto = new LibroDto();
        dto.setId(libro.getId());
        dto.setNombre(libro.getNombre());
        dto.setDescripcion(libro.getDescripcion());
        dto.setUnidades(libro.getUnidades());
        dto.setAutorId(libro.getAutorId());
        dto.setDisponible(libro.getDisponible());
        return dto;
    }
}
