package com.example.demo.controller;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.model.Prestamo;
import com.example.demo.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request.mapping}/v4")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PrestamoController {
    private final PrestamoService service;
    @CrossOrigin(value = "*")
    @PostMapping("/create-prestamo")
    public PrestamoDto create(@RequestBody PrestamoDto prestamoDto){
        return service.create(prestamoDto);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/update-prestamo")
    public PrestamoDto update(@RequestBody PrestamoDto prestamoDto){
        return service.update(prestamoDto);
    }
    @CrossOrigin(value = "*")
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @CrossOrigin(value = "*")
    @GetMapping("/read")
    Page<Prestamo> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        log.info("Se creo servicio ageable");
        return service.read(pageSize, pageNumber);

    }

    @CrossOrigin(value = "*")
    @GetMapping("/getById/{id}")
    public ResponseEntity<Prestamo> getFormularioById(@PathVariable Long id) {
        try {
            Prestamo prestamo = service.findById(id);
            return new ResponseEntity<>(prestamo, HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
