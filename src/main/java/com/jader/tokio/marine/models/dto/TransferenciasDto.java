package com.jader.tokio.marine.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
public class TransferenciasDto {
    private Long id;
    private boolean agendada;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal taxa;
    private BigDecimal valor;
    private Date dataTransferencia;
    private Date dataCriacao;
}
