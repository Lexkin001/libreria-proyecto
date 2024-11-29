package com.example.demo.controller;

import com.example.demo.dto.LibroDto;
import com.example.demo.model.Autor;
import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request.mapping}/v3")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LibroController {
    final LibroService service;

    @CrossOrigin(value = "*")
    @PostMapping("/create-libro")
    public LibroDto create(@RequestBody LibroDto libroDto){
        return service.create(libroDto);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/update-libro")
    public LibroDto update(@RequestBody LibroDto libroDto){
        return service.update(libroDto);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @CrossOrigin(value = "*")
    @GetMapping("/read")
    Page<Libro> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        log.info("Se creo servicio ageable");
        return service.read(pageSize, pageNumber);

    }

    @CrossOrigin(value = "*")
    @GetMapping("/getById/{id}")
    public ResponseEntity<Libro> getFormularioById(@PathVariable Long id) {
        try {
            Libro libro = service.findById(id);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
