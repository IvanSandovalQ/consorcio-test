package com.consorcio.pharmacy.client;

import com.consorcio.pharmacy.configuration.PropertiesAccessConfiguration;
import com.consorcio.pharmacy.entity.Farmacia;
import com.consorcio.pharmacy.exception.ErrorConexionNegocioException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class FarmaciaClient implements FarmaciaClientService {

    private final RestTemplate restTemplate;
    private final PropertiesAccessConfiguration properties;

    /**
     * Obtener Farmacias
     *
     * @see 'Este permite obtener farmacias por la comuna seleccionada
     * y/o por nombre de la farmacia obteniendo una lista de farmacias
     * esto a travez del consumo del servicio
     * https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion'
     * */
    @Override
    public List<Farmacia> obtenerFarmacias() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity request = new HttpEntity<>(headers);
            ResponseEntity<String> response = this.restTemplate.exchange(
                    this.properties.getPathGetPharmacyByCommune(),
                    HttpMethod.GET,
                    request,
                    String.class);
            Farmacia[] parser = new Gson().fromJson(response.getBody(), Farmacia[].class);
            return Arrays.stream(parser).collect(Collectors.toList());
        } catch(HttpClientErrorException httpceex) {
            log.error(" ######### [ERROR CONEXION] ######### ");
            log.error("Error al obtener respuesta de servicio -> "+ this.properties.getPathGetPharmacyByCommune());
            throw new ErrorConexionNegocioException(
                    httpceex,
                    HttpStatus.FAILED_DEPENDENCY,
                    "Error al obtener respuesta de servicio -> "+ this.properties.getPathGetPharmacyByCommune());
        } catch(Exception ex) {
            log.error(" ######### [ERROR INTERNO] ######### ");
            log.error(ex.getMessage(), ex);
            throw new ErrorConexionNegocioException(
                    ex,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error Interno del Sistema");
        }

    }

}
