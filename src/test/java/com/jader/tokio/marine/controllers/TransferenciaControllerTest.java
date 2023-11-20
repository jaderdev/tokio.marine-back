package com.jader.tokio.marine.controllers;

import com.jader.tokio.marine.Application;
import com.jader.tokio.marine.models.Transferencia;
import jakarta.inject.Inject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransferenciaControllerTest {

    @Inject
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Inject
    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    void getAllTransferencias() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(
                getRootUrl()+"/transferencias",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    void getTransferenciaById() {
        Transferencia transferencia = testRestTemplate.getForObject(
                getRootUrl()+"/transferencia/1", Transferencia.class);
        Assert.assertNotNull(transferencia);
    }

    @Test
    void addTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.setTaxa(new BigDecimal("0.1"));
        transferencia.setValor(new BigDecimal("100.00"));
        transferencia.setContaDestino("09823423098");
        transferencia.setContaOrigem("09823423098");
        transferencia.setDataTransferencia(new Date());
        transferencia.setDataCriacao(new Date());

        ResponseEntity<Transferencia> response = testRestTemplate.postForEntity(
                getRootUrl()+"/transferencia",transferencia, Transferencia.class);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
    }
}