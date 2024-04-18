package com.github.danilogmoura.strategy.service;

import com.github.danilogmoura.strategy.model.Cliente;

import java.math.BigDecimal;

public interface CalculadoraPremioSeguro {

    BigDecimal calcular(Cliente cliente, BigDecimal valorVeiculo);
}
