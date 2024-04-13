package com.github.danilogmoura.factory.operadora.cielo;

import com.github.danilogmoura.factory.operadora.CapturaNaoAutorizadaException;
import com.github.danilogmoura.factory.operadora.Operadora;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Random;

public class Cielo implements Operadora {

    private static final Logger logger = LoggerFactory.getLogger(Cielo.class);

    private final Random rand = new Random();
    private Long codigoConfirmacao = -1L;

    @Override
    public void capturar(String cartao, BigDecimal valor) {
        if (cartao.startsWith("5555")) {
            throw new CapturaNaoAutorizadaException("Número de cartão inválido!");
        }
        this.codigoConfirmacao = rand.nextLong() * 1000;
    }

    @Override
    public Long confirmar() {
        logger.info("Fazendo o débito na conta do cliente via Cielo");
        return this.codigoConfirmacao;
    }
}