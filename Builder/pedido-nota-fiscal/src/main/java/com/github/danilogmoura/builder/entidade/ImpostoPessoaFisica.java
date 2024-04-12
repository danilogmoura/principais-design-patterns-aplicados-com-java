package com.github.danilogmoura.builder.entidade;

import java.math.BigDecimal;

public class ImpostoPessoaFisica implements Imposto {

    private final BigDecimal percentual = new BigDecimal("0.07");

    @Override
    public BigDecimal getPorcentagemImposto() {
        return this.percentual;
    }
}
