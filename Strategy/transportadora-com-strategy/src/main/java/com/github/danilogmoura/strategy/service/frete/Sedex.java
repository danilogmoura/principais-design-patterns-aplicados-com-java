package com.github.danilogmoura.strategy.service.frete;

import com.github.danilogmoura.strategy.service.Frete;

public class Sedex implements Frete {

    public double calcularPreco(int distancia) {
        return distancia * 1.45 + 12;
    }
}
