package com.github.danilogmoura.strategy.service.premio;

import com.github.danilogmoura.strategy.model.Cliente;
import com.github.danilogmoura.strategy.service.CalculadoraPremioSeguro;

import java.math.BigDecimal;

public class CalculadoraPremioSeguroParaCarro implements CalculadoraPremioSeguro {
    @Override
    public BigDecimal calcular(Cliente cliente, BigDecimal valorVeiculo) {
        BigDecimal taxaPremio = new BigDecimal("0.03");
        BigDecimal premioSeguro = valorVeiculo.multiply(taxaPremio);

        BigDecimal taxaIdade = new BigDecimal("0.005");
        BigDecimal taxaIdadeExtra = taxaIdade.multiply(new BigDecimal(cliente.getIdade()));

        return premioSeguro.add(premioSeguro.multiply(taxaIdadeExtra));
    }
}
