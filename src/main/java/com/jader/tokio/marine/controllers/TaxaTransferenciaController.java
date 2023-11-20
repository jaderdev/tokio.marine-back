package com.jader.tokio.marine.controllers;

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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaxaTransferenciaController {
    @Autowired
    private ITaxasTransferenciaRepository repository;

    @GetMapping("/taxas/transferencia")
    public ResponseEntity<List<TaxasTransferencia>> getAllTaxaTransferencias() {
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }
}
