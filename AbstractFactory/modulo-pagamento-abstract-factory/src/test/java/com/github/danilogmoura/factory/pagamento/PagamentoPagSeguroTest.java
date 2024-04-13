package com.github.danilogmoura.factory.pagamento;


import com.github.danilogmoura.factory.gestorderisco.AlertaDeRiscoException;
import com.github.danilogmoura.factory.operadora.CapturaNaoAutorizadaException;
import com.github.danilogmoura.factory.pagamento.pagueseguro.PagueSeguroModuloPagamentoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagamentoViaPagSeguroTest {

    private Pagamento pagamento;

    @BeforeEach
    void init() {
        pagamento = new Pagamento(new PagueSeguroModuloPagamentoFactory());
    }

    @Test
    void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        assertNotNull(codigoAutorizacao);
    }


    @Test
    void deveNegarCaptura_cartaoInvalido() {
        assertThrows(CapturaNaoAutorizadaException.class,
                () -> pagamento.autorizar("5555.2222", new BigDecimal("2000")));
    }

    @Test
    void deveGerarAlertaDeRisco() {
        assertThrows(AlertaDeRiscoException.class,
                () -> pagamento.autorizar("7777.2222", new BigDecimal("5500")));
    }
}