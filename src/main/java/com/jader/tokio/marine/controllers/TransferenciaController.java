package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.mappers.Mapper;
import com.jader.tokio.marine.models.dto.TransferenciaCreationDTO;
import com.jader.tokio.marine.models.dto.TransferenciaIdDTO;
import com.jader.tokio.marine.models.dto.TransferenciasDto;
import com.jader.tokio.marine.services.ITransferenciaService;
import com.jader.tokio.marine.models.Transferencia;
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
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "${cors}", maxAge = 3600)
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {
    @Autowired
    private ITransferenciaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TransferenciasDto>> getAllTransferencias() {
        return new ResponseEntity<List<TransferenciasDto>>(
                    service.findAll().stream().map(mapper::toTransferenciaDto).collect(toList()),
                HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TransferenciasDto> getTransferenciaById(
            @PathVariable(value="id") String tranferenciaId){
        Transferencia transferencia = service.findById(tranferenciaId).orElse(null);
        if(transferencia != null){
            return new ResponseEntity<TransferenciasDto>(mapper.toTransferenciaDto(transferencia),HttpStatus.OK);
        }
        return new ResponseEntity<TransferenciasDto>((TransferenciasDto) null,HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping
    @ResponseBody
    public ResponseEntity<TransferenciaIdDTO> addTransferencia(
            @Valid @RequestBody TransferenciaCreationDTO transferenciaDto ){
        Transferencia transferencia = mapper.toTransferencia(transferenciaDto);
        service.save(transferencia);
        return new ResponseEntity<TransferenciaIdDTO>(new TransferenciaIdDTO(transferencia.getId()),HttpStatus.OK);
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
