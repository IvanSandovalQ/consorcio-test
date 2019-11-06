package com.consorcio.pharmacy.client;

public interface ComunaClientService {

    /**
     * Obtener Comunas
     *
     * @see 'Metodo que realiza busqueda de comunas por identificador de region
     * este se comunica con el servicio
     *  {midastest.minsal.cl operacion}
     *      -> maps_obtener_comunas_por_regiones
     *
     * al cual le envia el codigo de region para obtener la lista esperada'
     *
     * @return Lista de comunas de la region
     * */
    String obtenerComunas();
}
