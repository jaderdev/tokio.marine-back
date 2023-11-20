package com.jader.tokio.marine.services;

import com.jader.tokio.marine.transferencias.models.Transferencia;

import java.util.List;
import java.util.Optional;

public interface ITransferenciaService {
    Transferencia save(Transferencia transferencia);

    Optional<Transferencia> findById(String tranferenciaId);

    List<Transferencia> findAll();
}
