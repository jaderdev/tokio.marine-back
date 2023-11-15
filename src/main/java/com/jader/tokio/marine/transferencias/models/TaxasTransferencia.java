package com.jader.tokio.marine.transferencias.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
public class TaxasTransferencia {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int de;
    @Column(nullable = false)
    private int ate;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private String taxa;
    public TaxasTransferencia() {
    }
}