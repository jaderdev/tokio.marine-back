package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.services.ITransferenciaService;
import com.jader.tokio.marine.transferencias.models.Transferencia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TransferenciaController {
    @Autowired
    private ITransferenciaService service;

    @GetMapping("/transferencias")
    public ResponseEntity<List<Transferencia>> getAllTransferencias() {
        return new ResponseEntity<List<Transferencia>>(service.findAll(),HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping("/transferencias/{id}")
    public ResponseEntity<Transferencia> getTransferenciaById(
            @PathVariable(value="id") String tranferenciaId){
        return new ResponseEntity(service.findById(tranferenciaId),HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping("/transferencias")
    public ResponseEntity<Transferencia> addTransferencia(@Valid @RequestBody Transferencia transferencia ){
        return new ResponseEntity<Transferencia>(service.save(transferencia),HttpStatus.OK);
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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
      public Map<String, String> handleRuntimeException(
      RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error",ex.getMessage());
        return errors;
    }
}
