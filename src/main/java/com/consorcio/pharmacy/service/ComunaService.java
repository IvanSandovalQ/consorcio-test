package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.entity.Comuna;
import java.util.List;

public interface ComunaService {

    /**
     * Obtener Comunas
     *
     * @see 'Este modilo permite obtener las comunas de una region pre-determinada
     * para ello integra servicos externos los cuales permiten obtener esta infoormacion'
     *
     * @return Lista de comunas
     * */
    List<Comuna> obtenerComunas();

}
