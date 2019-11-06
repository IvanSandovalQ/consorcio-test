package com.consorcio.pharmacy.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties
public class PropertiesAccessConfiguration {

    private String pathCommunesByRegion;
    private String pathGetPharmacyByCommune;

}
