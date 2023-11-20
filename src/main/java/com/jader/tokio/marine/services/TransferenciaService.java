package com.jader.tokio.marine.services;

import com.jader.tokio.marine.repositories.ITaxasTransferenciaRepository;
import com.jader.tokio.marine.repositories.ITransferenciaRepository;
import com.jader.tokio.marine.models.TaxasTransferencia;
import com.jader.tokio.marine.models.Transferencia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService implements ITransferenciaService {
    @Autowired
    private ITransferenciaRepository repository;

    @Autowired
    private ITaxasTransferenciaRepository taxasRepository;

    public Transferencia save( Transferencia transferencia){
        transferencia.setTaxa(getTaxaFromTransferencia(transferencia));
        return this.repository.save(transferencia);
    }

    private BigDecimal getTaxaFromTransferencia(@Valid Transferencia transferencia){
        int interval = transferencia.getDateInterval();
        List<TaxasTransferencia> taxa = this.taxasRepository.findAll().stream().filter((taxasTransferencia) ->
                ( interval >= taxasTransferencia.getDe() && interval <= taxasTransferencia.getAte())).toList();

        if(taxa.isEmpty()){
            throw new RuntimeException("Não foi encontrada taxa aplicável! Número de dias maior que o limite "+
                    "ou menor que zero");
        }

        return new BigDecimal(taxa.get(0).getTaxa());
    }
    @Override
    public Optional<Transferencia> findById(String tranferenciaId) {
        return repository.findById(tranferenciaId);
    }

    @Override
    public List<Transferencia> findAll() {
        return repository.findAll();
    }
}
