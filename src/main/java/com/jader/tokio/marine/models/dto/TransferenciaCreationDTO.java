package com.jader.tokio.marine.models.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class TransferenciaCreationDTO {
    private Long id;
    private boolean agendada;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal taxa;
    private BigDecimal valor;
    private Date dataTransferencia;
    private Date dataCriacao;
}
