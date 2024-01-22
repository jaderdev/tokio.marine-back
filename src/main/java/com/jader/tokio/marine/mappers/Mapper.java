package com.jader.tokio.marine.mappers;

import com.jader.tokio.marine.models.TaxasTransferencia;
import com.jader.tokio.marine.models.Transferencia;
import com.jader.tokio.marine.models.dto.TaxasTransferenciaDTO;
import com.jader.tokio.marine.models.dto.TransferenciaCreationDTO;
import com.jader.tokio.marine.models.dto.TransferenciasDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public TransferenciasDto toTransferenciaDto(Transferencia t){
        return TransferenciasDto.builder()
                .id(t.getId())
                .dataTransferencia(t.getDataTransferencia())
                .taxa(t.getTaxa())
                .valor(t.getValor())
                .contaDestino(t.getContaDestino())
                .contaOrigem(t.getContaOrigem())
                .dataCriacao(t.getDataCriacao())
                .agendada(t.isAgendada())
                .build();
    }

    public Transferencia toTransferencia(TransferenciaCreationDTO t) {
        return Transferencia.builder()
                .id(t.getId())
                .dataTransferencia(t.getDataTransferencia())
                .taxa(t.getTaxa())
                .valor(t.getValor())
                .contaDestino(t.getContaDestino())
                .contaOrigem(t.getContaOrigem())
                .dataCriacao(t.getDataCriacao())
                .agendada(t.isAgendada())
                .build();
    }

    public TaxasTransferenciaDTO toTaxaTransferenciaDTO(TaxasTransferencia t) {
        return TaxasTransferenciaDTO.builder()
                .id(t.getId())
                .de(t.getDe())
                .ate(t.getAte())
                .valor(t.getValor())
                .taxa(t.getTaxa())
                .build();
    }
}
