package com.example.demo.controller;

import com.example.demo.dto.ClienteDto;
import com.example.demo.model.Autor;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${request.mapping}/v2")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteController {
    private final ClienteService service;

    @CrossOrigin(value = "*")
    @PostMapping("/create-cliente")
    public ClienteDto create (@RequestBody ClienteDto clienteDto){
        return service.create(clienteDto);
    }
    @CrossOrigin(value = "*")
    @PutMapping("/update-cliente")
    public ClienteDto update (@RequestBody ClienteDto clienteDto){
        return service.update(clienteDto);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {

        service.delete(id);

    }
    @CrossOrigin(value = "*")
    @GetMapping("/read")
    Page<Cliente> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        log.info("Se creo servicio ageable");
        return service.read(pageSize, pageNumber);

    }

    @CrossOrigin(value = "*")
    @GetMapping("/getById/{id}")
    public ResponseEntity<Cliente> getFormularioById(@PathVariable Long id) {
        try {
            Cliente cliente = service.findById(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
