package com.jader.tokio.marine.transferencias.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@Table(name = "transferencias")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean agendada = true;

    @Column(nullable = true, columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9]{10}$")
    @Length(min = 10, max = 10)
    private String contaOrigem;

    @NotBlank(message = "É obrigatório informar a conta de destino")
    @Column(nullable = false, columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9]{10}$")
    @Length(min = 10, max = 10)
    private String contaDestino;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal taxa;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date dataTransferencia;

    @ReadOnlyProperty
    private Date dataCriacao = new Date();

    public int getDateInterval(){
        long startTime = dataCriacao.getTime();
        long endTime = dataTransferencia.getTime();

         long intervalMilliseconds = endTime - startTime;
         long interval = intervalMilliseconds / (24 * 60 * 60 * 1000);
        return (int) interval;
    }
}
