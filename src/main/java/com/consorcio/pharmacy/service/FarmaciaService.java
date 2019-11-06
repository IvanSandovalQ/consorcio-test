package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.dto.FarmaciaDto;

import java.util.List;

public interface FarmaciaService {

    List<FarmaciaDto> obtenerFarmaciasPorFiltros(Integer comunaId, String nombre);

}
