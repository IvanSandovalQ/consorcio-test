package com.consorcio.pharmacy.client;

import com.consorcio.pharmacy.entity.Farmacia;

import java.util.List;

public interface FarmaciaClientService {

    /**
     * Obtener Farmacias
     *
     * @see 'Este permite obtener farmacias por la comuna seleccionada
     * y/o por nombre de la farmacia obteniendo una lista de farmacias
     * esto a travez del consumo del servicio
     * https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion'
     * */
    List<Farmacia> obtenerFarmacias();
}
