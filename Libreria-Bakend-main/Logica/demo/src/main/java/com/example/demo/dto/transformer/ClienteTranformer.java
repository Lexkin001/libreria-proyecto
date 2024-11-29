package com.example.demo.dto.transformer;

import com.example.demo.dto.ClienteDto;
import com.example.demo.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteTranformer {
    public Cliente clienteTransformerFromDto (ClienteDto clienteDto){
        if (clienteDto == null)return null;

        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setTelefono(clienteDto.getTelefono());
        return cliente;
    }
    public ClienteDto clienteTransformerFromModel(Cliente cliente){
        if (cliente == null)return null;
        ClienteDto dto= new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }
}
