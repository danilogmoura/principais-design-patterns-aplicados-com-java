package com.github.danilogmoura.factory.servico;


import com.github.danilogmoura.factory.logger.Logger;

public class CalculadoraDeImpostos {

    private final Logger logger;

    public CalculadoraDeImpostos(Logger logger) {
        this.logger = logger;
    }

    public void calcular(double valor) {
        // Aqui teria uma lógica para calcular impostos sobre o valor passado

        // no fim, o programador gostaria de deixar registrado o valor calculado
        logger.log("Imposto calculado para o valor R$" + valor);
    }
}