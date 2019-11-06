package com.consorcio.pharmacy.client;

import com.consorcio.pharmacy.configuration.PropertiesAccessConfiguration;
import com.consorcio.pharmacy.exception.BusinessConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommuneClient implements CommuneClientService {

    private final RestTemplate restTemplate;
    private final PropertiesAccessConfiguration properties;

    /**
     * Get Communes
     *
     * @see 'Metodo que realiza busqueda de comunas por identificador de region
     * este se comunica con el servicio
     *  {midastest.minsal.cl operacion}
     *      -> maps_obtener_comunas_por_regiones
     *
     * al cual le envia el codigo de region para obtener la lista esperada'
     *
     * @param regionId 'Numero identificador de la region'
     * @return Lista de comunas de la region
     * */
    @Override
    public String getCommunes(int regionId) {
        try {
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("reg_id", regionId);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(parts, headers);

            ResponseEntity<String> response = this.restTemplate.exchange(
                    this.properties.getPathCommunesByRegion(),
                    HttpMethod.POST,
                    request,
                    String.class);
            return response.getBody();
        } catch(HttpClientErrorException httpceex) {
            log.error(" ######### [ERROR CONEXION] ######### ");
            log.error("Error al obtener respuesta de servicio -> "+ this.properties.getPathCommunesByRegion());
            throw new BusinessConnectionException(
                    httpceex,
                    HttpStatus.FAILED_DEPENDENCY,
                    "Error al obtener respuesta de servicio -> "+ this.properties.getPathCommunesByRegion());
        } catch(Exception ex) {
            log.error(" ######### [ERROR INTERNO] ######### ");
            log.error(ex.getMessage(), ex);
            throw new BusinessConnectionException(
                    ex,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error Interno del Sistema");
        }

    }
}
