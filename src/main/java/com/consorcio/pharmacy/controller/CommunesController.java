package com.consorcio.pharmacy.controller;

import com.consorcio.pharmacy.client.CommuneClientService;
import com.consorcio.pharmacy.service.CommuneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommunesController {

    private final CommuneService communeService;

    /**
     * Get Comunes By Region Id
     *
     * @see 'Metodo que obtiene una lista de comunas a travez del identificador
     * de la region a traves de minsal, disponibilizando las comunas para fines
     * de filtro en la busqueda de farmacias'
     *
     * @author BCI
     * @param regionId
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
            value = "/communes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getComunesByRegionId(@RequestParam int regionId) throws Exception {
        return ResponseEntity.ok(this.communeService.getCommunesByRegionId(regionId));
    }


}
