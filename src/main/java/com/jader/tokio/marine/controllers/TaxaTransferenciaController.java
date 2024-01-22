package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.mappers.Mapper;
import com.jader.tokio.marine.models.dto.TaxasTransferenciaDTO;
import com.jader.tokio.marine.repositories.ITaxasTransferenciaRepository;
import com.jader.tokio.marine.models.TaxasTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "${cors}", maxAge = 3600)
@RestController
@RequestMapping("/api/taxas/transferencia")
public class TaxaTransferenciaController {
    @Autowired
    private ITaxasTransferenciaRepository repository;
    @Autowired
    Mapper mapper;

    @GetMapping
    public ResponseEntity<List<TaxasTransferenciaDTO>> getAllTaxaTransferencias() {
        return new ResponseEntity<>(
                repository.findAll().stream().map(mapper::toTaxaTransferenciaDTO).collect(toList())
                ,HttpStatus.OK);
    }
}
