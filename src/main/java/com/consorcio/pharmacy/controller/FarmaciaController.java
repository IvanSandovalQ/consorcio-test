package com.consorcio.pharmacy.controller;

import com.consorcio.pharmacy.dto.FarmaciaDto;
import com.consorcio.pharmacy.service.ComunaService;
import com.consorcio.pharmacy.service.FarmaciaService;
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
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    /**
     * Obtener Farmacias Por Filtros
     *
     * @see 'Operacion que obtiene una lista de farmacias segun identificador de comuna
     * [comunaId] y/o nombre de la farmacia [nombreLocal] de no filtrar la data
     * simplemente arrojara todas las farmacias encontradas'
     *
     * @author BCI
     * @return ResponseEntity<List<String>>
     */
    @ApiOperation(
            "Operacion que obtiene una lista de farmacias segun identificador de comuna \n" +
            " [comunaId] y/o nombre de la farmacia [nombreLocal] de no filtrar la data\n" +
            " simplemente arrojara todas las farmacias encontradas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Solicitud OK"),
            @ApiResponse(code = 400, message= "Error en los datos ingresados"),
            @ApiResponse(code = 500, message= "Error de servidor")})
    @GetMapping(
            value = "/farmacias",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FarmaciaDto>> obtenerFarmaciasPorFiltros(@RequestParam(required=false) Integer comunaId,
                                                                        @RequestParam(required=false) String nombreLocal) throws Exception {
        return ResponseEntity.ok(this.farmaciaService.obtenerFarmaciasPorFiltros(comunaId, nombreLocal));
    }

}
