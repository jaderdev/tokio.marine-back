package com.jader.tokio.marine.services;

import com.jader.tokio.marine.Application;
import com.jader.tokio.marine.models.Transferencia;
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
        Transferencia transferencia = Transferencia.builder()
                .valor(new BigDecimal("1000.00"))
                .contaDestino("3409834578")
                .contaOrigem("0000000000")
                .build();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, 12);

        calendar.set(Calendar.DATE, 20);
        transferencia.setDataCriacao(calendar.getTime());

        calendar.set(Calendar.DATE, 30);
        transferencia.setDataTransferencia(calendar.getTime());

        transferencia.setAgendada(true);
        transferencia.setTaxa(new BigDecimal("0.1"));
        Transferencia result = service.save(transferencia);

        Assert.assertNotNull(result);
    }
}