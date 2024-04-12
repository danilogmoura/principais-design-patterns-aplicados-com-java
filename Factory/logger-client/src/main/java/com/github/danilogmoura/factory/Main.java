package com.github.danilogmoura.factory;

import com.github.danilogmoura.factory.logger.ConsoleLogger;
import com.github.danilogmoura.factory.servico.CalculadoraDeImpostos;

public class Main {

    public static void main(String[] args) {
        var calculadoraDeImpostos = new CalculadoraDeImpostos(new ConsoleLogger());
        calculadoraDeImpostos.calcular(19);
    }
}