package com.jader.tokio.marine.models.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaxasTransferenciaDTO {
    private Integer id;
    private int de;
    private int ate;
    private String valor;
    private String taxa;
}
