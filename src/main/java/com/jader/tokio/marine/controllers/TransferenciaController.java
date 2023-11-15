package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.repositories.ITransferenciaRepository;
import com.jader.tokio.marine.transferencias.models.Transferencia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TransferenciaController {
    @Autowired
    private ITransferenciaRepository repository;

    @GetMapping("/transferencias")
    public List<Transferencia> getAllTransferencias() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping("/transferencias/{id}")
    public ResponseEntity<Transferencia> getTransferenciaById(
            @PathVariable(value="id") String tranferenciaId){
        return ResponseEntity.of(repository.findById(tranferenciaId));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/transferencias")
    public Transferencia addTransferencia(@Valid @RequestBody Transferencia transferencia ){
        return repository.save(transferencia);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
      public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
