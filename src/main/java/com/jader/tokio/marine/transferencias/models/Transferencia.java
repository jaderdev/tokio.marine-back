package com.jader.tokio.marine.transferencias.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.math.BigDecimal;
import java.util.Date;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@Table(name = "transferencias")
public class Transferencia {
    // TODO: Verificar como validar os tamanhos
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank(message = "Deve-se informar se a transferência é agendada ou não")
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean agendada = true;

    @NotBlank(message = "É obrigatório informar a conta de origem")
    @Column(nullable = false, columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9a-zA-z]{10}$")
    @Length(min = 10, max = 10)
    private String contaOrigem;

    @NotBlank(message = "É obrigatório informar a conta de destino")
    @Column(nullable = false, columnDefinition = "varchar(10)")
    @Pattern(regexp = "^[0-9a-zA-z]{10}$")
    @Length(min = 10, max = 10)
    private String contaDestino;

    @NotBlank(message = "É obrigatório informar a taxa")
    @Column(nullable = false)
    private BigDecimal taxa;

    @NotBlank(message = "É obrigatório informar o valor da transferência")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotBlank(message = "É obrigatório informar a data em que acontecerá a transferência")
    @Column(nullable = false)
    private Date dataTransferencia;

    @ReadOnlyProperty
    private Date dataCriacao = new Date();
}
