package com.example.demo.controller;

import com.example.demo.dto.AutorDto;
import com.example.demo.model.Autor;
import com.example.demo.model.Cliente;
import com.example.demo.service.AutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${request.mapping}/v1")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AutorController {
    private final AutorService autorService;


    @CrossOrigin(value = "*")
    @PostMapping("/create-autor")
    private AutorDto create(@RequestBody AutorDto autorDto){
        log.info("Se creo servico create");
        return autorService.create(autorDto);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/update-autor")
    private AutorDto update(@RequestBody AutorDto autorDto){
        log.info("Se creo servico update");
        return autorService.update(autorDto);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {

        autorService.delete(id);

    }
    @CrossOrigin(value = "*")
    @GetMapping("/read")
    Page<Autor> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        log.info("Se creo servicio ageable");
        return autorService.read(pageSize, pageNumber);

    }
    @CrossOrigin(value = "*")
    @GetMapping("/getById/{id}")
    public ResponseEntity<Autor> getFormularioById(@PathVariable Long id) {
        try {
            Autor autor = autorService.findById(id);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
