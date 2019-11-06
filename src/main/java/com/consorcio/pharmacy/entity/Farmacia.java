package com.consorcio.pharmacy.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Farmacia implements Serializable {

    private static final long serialVersionUID = -1175645088678517066L;

    private String fecha;
    private String local_id;
    private String local_nombre;
    private String comuna_nombre;
    private String localidad_nombre;
    private String local_direccion;
    private String funcionamiento_hora_apertura;
    private String funcionamiento_hora_cierre;
    private String local_telefono;
    private String local_lat;
    private String local_lng;
    private String funcionamiento_dia;
    private String fk_region;
    private String fk_comuna;
}
