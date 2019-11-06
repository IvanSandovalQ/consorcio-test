package com.consorcio.pharmacy.controller;

import com.consorcio.pharmacy.service.ComunaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ComunaController {

    private final ComunaService comunaService;

    /**
     * Obtener Comunas
     *
     * @see 'Metodo que obtiene una lista de comunas a travez del identificador
     * de una region pre-determinada, este integra servicio de minsal, disponibilizando las comunas para fines
     * de filtro en la busqueda de farmacias'
     *
     * @author BCI
     * @return ResponseEntity<List<String>>
     */
    @ApiOperation(
            "Metodo que obtiene una lista de comunas a travez del identificador \n" +
            "de la region a traves de minsal")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Solicitud OK"),
            @ApiResponse(code = 400, message= "Error en los datos ingresados"),
            @ApiResponse(code = 500, message= "Error de servidor")})
    @GetMapping(
            value = "/comunas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerComunas() throws Exception {
        return ResponseEntity.ok(this.comunaService.obtenerComunas());
    }

}
