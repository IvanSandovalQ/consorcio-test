package com.consorcio.pharmacy.service;

import com.consorcio.pharmacy.entity.Commune;

import java.util.List;

public interface CommuneService {

    List<Commune> getCommunesByRegionId(int regionId);

}
