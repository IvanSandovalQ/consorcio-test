package com.consorcio.pharmacy.entity;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class Commune implements Serializable {

    private static final long serialVersionUID = -6674755210780885857L;

    private int id;
    private String name;
}
