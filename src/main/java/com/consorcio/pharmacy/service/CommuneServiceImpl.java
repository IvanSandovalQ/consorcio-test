package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.client.CommuneClientService;
import com.consorcio.pharmacy.entity.Commune;
import com.consorcio.pharmacy.util.Constants;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommuneServiceImpl implements CommuneService {

    private final CommuneClientService communeClientService;

    @Override
    public List<Commune> getCommunesByRegionId(int regionId) {
        String comunesResponse = this.communeClientService.getCommunes(regionId);
        Document doc = Jsoup.parse(comunesResponse, Constants.BASE_URI);
        Elements optionElements = doc.select(Constants.OPTION);

        List<Commune> communes = new ArrayList<>();
        optionElements.forEach(element ->
            communes.add(Commune.builder()
                    .id(Integer.valueOf(element.val()))
                    .name(element.text())
                    .build())
        );
        return communes;
    }

}
