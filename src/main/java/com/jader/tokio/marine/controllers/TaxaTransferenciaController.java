package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.repositories.ITaxasTransferenciaRepository;
import com.jader.tokio.marine.services.ITransferenciaService;
import com.jader.tokio.marine.transferencias.models.TaxasTransferencia;
import com.jader.tokio.marine.transferencias.models.Transferencia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaxaTransferenciaController {
    @Autowired
    private ITaxasTransferenciaRepository repository;

    @GetMapping("/taxas/transferencia")
    public ResponseEntity<List<TaxasTransferencia>> getAllTaxaTransferencias() {
        return new ResponseEntity<List<TaxasTransferencia>>(repository.findAll(),HttpStatus.OK);
    }
}
