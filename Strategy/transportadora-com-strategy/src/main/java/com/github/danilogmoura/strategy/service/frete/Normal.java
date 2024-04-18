package com.github.danilogmoura.strategy.service.frete;

import com.github.danilogmoura.strategy.service.Frete;

public class Normal implements Frete {

    @Override
    public double calcularPreco(int distancia) {
        return distancia * 1.25 + 10;
    }
}
