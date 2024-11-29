package com.example.demo.dto.transformer;

import com.example.demo.dto.AutorDto;
import com.example.demo.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorTransformer {

    public Autor autorTransformerFromDto(AutorDto autorDto){
        if (autorDto == null)return null;

        Autor autor =new Autor();
        autor.setId(autorDto.getId());
        autor.setNombre(autorDto.getNombre());
        autor.setEdad(autorDto.getEdad());
        autor.setLibro(autorDto.getLibro());

        return autor;
    }

    public AutorDto autorDtoTranformeFromModel(Autor autor){
        if (autor == null)return null;


        AutorDto dto = new AutorDto();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setEdad(autor.getEdad());
        dto.setLibro(autor.getLibro());

        return dto;
    }
}
