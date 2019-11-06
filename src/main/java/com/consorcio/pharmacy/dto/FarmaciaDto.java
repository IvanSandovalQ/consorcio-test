package com.consorcio.pharmacy.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FarmaciaDto implements Serializable {

    private static final long serialVersionUID = -1175645088678517066L;

    private String nombre;
    private String direccion;
    private String telefono;
    private String latitud;
    private String longitud;
}
