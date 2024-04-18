package com.github.danilogmoura.strategy.service;

import com.github.danilogmoura.strategy.service.premio.CalculadoraPremioSeguroParaCarro;
import com.github.danilogmoura.strategy.service.premio.CalculadoraPremioSeguroParaMoto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TipoVeiculo {
    CARRO("Carro") {
        @Override
        public CalculadoraPremioSeguro getCalculadoraPremio() {
            return new CalculadoraPremioSeguroParaCarro();
        }
    }, MOTO("Moto") {
        @Override
        public CalculadoraPremioSeguro getCalculadoraPremio() {
            return new CalculadoraPremioSeguroParaMoto();
        }
    };

    private final String nome;

    TipoVeiculo(String nome) {
        this.nome = nome;
    }

    public static TipoVeiculo get(int value) {
        return TipoVeiculo.values()[value - 1];
    }

    public static List<String> menu() {
        return IntStream.range(0, values().length)
            .mapToObj(i -> (i + 1) + " - " + values()[i].getNome())
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private String getNome() {
        return this.nome;
    }

    public abstract CalculadoraPremioSeguro getCalculadoraPremio();
}
