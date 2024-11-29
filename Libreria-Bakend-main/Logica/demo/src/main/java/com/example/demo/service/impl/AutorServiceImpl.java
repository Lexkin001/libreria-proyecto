package com.example.demo.service.impl;

import com.example.demo.dto.AutorDto;
import com.example.demo.dto.transformer.AutorTransformer;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import com.example.demo.service.AutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AutorServiceImpl implements AutorService {
    private final AutorRepository repository;
    private final AutorTransformer transformer;
    @Override
    public AutorDto create(AutorDto autorDto) {
        log.info("Se creo metodo create");
        Autor autor = transformer.autorTransformerFromDto(autorDto);
        autorDto = transformer.autorDtoTranformeFromModel(repository.save(autor));
        return autorDto;
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AutorDto update(AutorDto autorDto) {
        log.info("Se creo metodo update");
        Autor autor = transformer.autorTransformerFromDto(autorDto);
        autorDto = transformer.autorDtoTranformeFromModel(repository.save(autor));
        return autorDto;
    }



    @Override
    public Page<Autor> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAll(pageable);

    }

    @Override
    public Autor findById(Long id) {
        return repository.findById(id).get();
    }

}
