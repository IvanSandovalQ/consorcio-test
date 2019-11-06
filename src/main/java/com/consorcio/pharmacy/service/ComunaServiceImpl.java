package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.client.ComunaClientService;
import com.consorcio.pharmacy.entity.Comuna;
import com.consorcio.pharmacy.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComunaServiceImpl implements ComunaService {

    private final ComunaClientService comunaClientService;

    /**
     * Obtener Comunas
     *
     * @see 'Este modilo permite obtener las comunas de una region pre-determinada
     * para ello integra servicos externos los cuales permiten obtener esta infoormacion'
     *
     * @return Lista de comunas
     * */
    @Override
    public List<Comuna> obtenerComunas() {
        String comunesResponse = this.comunaClientService.obtenerComunas();
        Document doc = Jsoup.parse(comunesResponse, Constantes.BASE_URI);
        Elements optionElements = doc.select(Constantes.OPTION);

        List<Comuna> communes = new ArrayList<>();
        optionElements.forEach(element ->
            communes.add(Comuna.builder()
                    .id(Integer.valueOf(element.val()))
                    .nombre(element.text())
                    .build())
        );
        return communes;
    }

}
