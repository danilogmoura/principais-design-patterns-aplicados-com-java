package com.github.danilogmoura.strategy.service.premio;

import com.github.danilogmoura.strategy.model.Cliente;
import com.github.danilogmoura.strategy.service.CalculadoraPremioSeguro;

import java.math.BigDecimal;

public class CalculadoraPremioSeguroParaMoto implements CalculadoraPremioSeguro {
    @Override
    public BigDecimal calcular(Cliente cliente, BigDecimal valorVeiculo) {
        BigDecimal taxaPremio = new BigDecimal("0.05");
        BigDecimal premioSeguro = valorVeiculo.multiply(taxaPremio);

        BigDecimal taxaIdade = new BigDecimal("0.01");
        BigDecimal taxaIdadeExtra = taxaIdade.multiply(new BigDecimal(cliente.getIdade()));

        if (cliente.getSexo().equals(Cliente.Sexo.MASCULINO)) {
            BigDecimal taxaSexo = new BigDecimal("0.005");
            premioSeguro = premioSeguro.add(premioSeguro.multiply(taxaSexo));
        }

        return premioSeguro.add(premioSeguro.multiply(taxaIdadeExtra));
    }
}
