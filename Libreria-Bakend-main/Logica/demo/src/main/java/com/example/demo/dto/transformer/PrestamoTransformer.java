package com.example.demo.dto.transformer;

import com.example.demo.dto.PrestamoDto;
import com.example.demo.model.Prestamo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PrestamoTransformer {
    public Prestamo pretamoTransformerFroDto (PrestamoDto prestamoDto){
        if (prestamoDto == null)return null;

        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoDto.getId());
        prestamo.setFecha(prestamoDto.getFecha());
        prestamo.setFechaF(prestamoDto.getFechaF());
        prestamo.setClienteId(prestamoDto.getClienteId());
        prestamo.setLibroId(prestamoDto.getLibroId());


        return prestamo;
    }
    public PrestamoDto pretamoTransformerFroModel (Prestamo prestamo){
        if(prestamo == null)return null;

        PrestamoDto dto = new PrestamoDto();
        dto.setId(prestamo.getId());
        dto.setFecha(prestamo.getFecha());
        dto.setFechaF(prestamo.getFechaF());
        dto.setClienteId(prestamo.getClienteId());
        dto.setLibroId(prestamo.getLibroId());



        return dto;
    }
}
