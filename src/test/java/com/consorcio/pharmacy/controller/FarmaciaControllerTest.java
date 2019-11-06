package com.consorcio.pharmacy.controller;

import com.consorcio.pharmacy.dto.FarmaciaDto;
import com.consorcio.pharmacy.service.FarmaciaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class FarmaciaControllerTest {

    @Mock
    private FarmaciaService service;

    @InjectMocks
    private FarmaciaController controller;

    @Test
    public void obtenerFarmaciasPorFiltros() throws Exception {

        Mockito.doReturn(new ArrayList<>())
                .when(this.service)
                .obtenerFarmaciasPorFiltros(null, null);

        ResponseEntity<List<FarmaciaDto>> respuesta = this.controller.obtenerFarmaciasPorFiltros(null, null);
        Assert.assertEquals(new ResponseEntity(new ArrayList<>(), HttpStatus.OK), respuesta);
    }

}
