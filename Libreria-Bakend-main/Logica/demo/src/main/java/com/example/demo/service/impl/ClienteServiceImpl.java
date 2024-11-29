package com.example.demo.service.impl;

import com.example.demo.dto.ClienteDto;
import com.example.demo.dto.transformer.ClienteTranformer;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
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

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;
    private final ClienteTranformer tranformer;
    @Override
    public ClienteDto create(ClienteDto clienteDto) {
        Cliente cliente = tranformer.clienteTransformerFromDto(clienteDto);
        clienteDto = tranformer.clienteTransformerFromModel(repository.save(cliente));
        return clienteDto;
    }

    @Override
    public ClienteDto update(ClienteDto clienteDto) {
        Cliente cliente = tranformer.clienteTransformerFromDto(clienteDto);
        clienteDto = tranformer.clienteTransformerFromModel(repository.save(cliente));
        return clienteDto;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Page<Cliente> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAll(pageable);

    }

    @Override
    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

}
