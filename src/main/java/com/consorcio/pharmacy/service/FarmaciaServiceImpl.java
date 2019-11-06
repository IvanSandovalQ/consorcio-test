package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.client.FarmaciaClientService;
import com.consorcio.pharmacy.dto.FarmaciaDto;
import com.consorcio.pharmacy.entity.Farmacia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmaciaServiceImpl implements FarmaciaService {

    private final FarmaciaClientService farmaciaClientService;

    @Override
    public  List<FarmaciaDto> obtenerFarmaciasPorFiltros(Integer comunaId, String nombre) {
        List<Farmacia> farmacias = this.farmaciaClientService.obtenerFarmacias();
        if(null == farmacias || farmacias.isEmpty())
            return new ArrayList<>();
        if(null != comunaId)
            farmacias = farmacias.stream().filter(farmacia -> String.valueOf(comunaId).equalsIgnoreCase(farmacia.getFk_comuna()))
                    .collect(Collectors.toList());
        if(null != nombre)
            farmacias = farmacias.stream().filter(farmacia -> nombre.equalsIgnoreCase(farmacia.getLocal_nombre()))
                    .collect(Collectors.toList());

        List<FarmaciaDto> respuesta = new ArrayList<>();
        farmacias.forEach(farmacia -> respuesta.add(FarmaciaDto.builder()
                .nombre(farmacia.getLocal_nombre())
                .direccion(farmacia.getLocal_direccion())
                .telefono(farmacia.getLocal_telefono())
                .latitud(farmacia.getLocal_lat())
                .longitud(farmacia.getLocal_lng())
                .build()));
        return respuesta;
    }
}
