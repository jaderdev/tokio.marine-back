package com.jader.tokio.marine.repositories;

import com.jader.tokio.marine.transferencias.models.TaxasTransferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaxasTransferenciaRepository extends JpaRepository<TaxasTransferencia, Long> {
}
