package com.consorcio.pharmacy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    //Para llamada de servicios rest (no microservicios)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
