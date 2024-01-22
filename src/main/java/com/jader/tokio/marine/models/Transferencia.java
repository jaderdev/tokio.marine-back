package com.jader.tokio.marine.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;
import java.math.BigDecimal;
import java.util.Date;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder()
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean agendada = true;

    @Column(columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9]{10}$")
    @Length(min = 10, max = 10)
    private String contaOrigem;

    @NotBlank(message = "É obrigatório informar a conta de destino")
    @Column(nullable = false, columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9]{10}$")
    @Length(min = 10, max = 10)
    private String contaDestino;

    @Column(nullable = false, precision=10, scale=3)
    private BigDecimal taxa;

    @Column(nullable = false, precision=10, scale=3)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date dataTransferencia;

    @ReadOnlyProperty
    private Date dataCriacao = new Date();

    public int getDateInterval(){
        if(getDataTransferencia().getTime() < getDataCriacao().getTime()){
            throw new RuntimeException("A data de transferência não deve ser menor que a data de criação!");
        }

        long startTime = dataCriacao.getTime();
        long endTime = dataTransferencia.getTime();

         long intervalMilliseconds = endTime - startTime;
         long interval = intervalMilliseconds / (24 * 60 * 60 * 1000);
        return (int) interval;
    }
}
