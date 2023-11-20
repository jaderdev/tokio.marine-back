package com.jader.tokio.marine.services;

import com.jader.tokio.marine.repositories.ITaxasTransferenciaRepository;
import com.jader.tokio.marine.repositories.ITransferenciaRepository;
import com.jader.tokio.marine.transferencias.models.TaxasTransferencia;
import com.jader.tokio.marine.transferencias.models.Transferencia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService implements ITransferenciaService {

    Logger log = LoggerFactory.getLogger(Transferencia.class);
    @Autowired
    private ITransferenciaRepository repository;

    @Autowired
    private ITaxasTransferenciaRepository taxasRepository;

    public Transferencia save( Transferencia transferencia){
        transferencia.setTaxa(getTaxaFromTransferencia(transferencia));
        return this.repository.save(transferencia);
    }

    private BigDecimal getTaxaFromTransferencia(Transferencia transferencia){
        int interval = transferencia.getDateInterval();
        List<TaxasTransferencia> taxa = this.taxasRepository.findAll().stream().filter((taxasTransferencia) ->
                ( interval >= taxasTransferencia.getDe() && interval <= taxasTransferencia.getAte())).toList();

        if(taxa.isEmpty()){
            throw new RuntimeException("Não foi encontrada taxa aplicável!");
        }

        BigDecimal valor  = new BigDecimal(taxa.get(0).getTaxa());

        return valor;
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
