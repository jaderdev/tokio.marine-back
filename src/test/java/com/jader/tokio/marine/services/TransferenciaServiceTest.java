package com.jader.tokio.marine.services;

import com.jader.tokio.marine.Application;
import com.jader.tokio.marine.transferencias.models.Transferencia;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
class TransferenciaServiceTest {
    @Autowired
    ITransferenciaService service;
    @Test
    void save() {
        Transferencia transferencia = new Transferencia();
        transferencia.setValor(new BigDecimal("1000.00"));
        transferencia.setContaDestino("3409834578");
        transferencia.setContaOrigem("0000000000");
        transferencia.setDataTransferencia(new Date(2023, Calendar.DECEMBER,30));
        transferencia.setDataCriacao(new Date(2023, Calendar.DECEMBER,20));
        transferencia.setAgendada(true);
        transferencia.setTaxa(new BigDecimal("0.1"));
        Transferencia result = service.save(transferencia);

        Assert.assertNotNull(result);
    }
}