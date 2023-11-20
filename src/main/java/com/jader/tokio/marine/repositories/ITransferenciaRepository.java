package com.jader.tokio.marine.repositories;

import com.jader.tokio.marine.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferenciaRepository extends JpaRepository<Transferencia, String> {
}
