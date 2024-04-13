package com.github.danilogmoura.factory.notafiscal;

import java.math.BigDecimal;

public interface NotaFiscal {

    void gerar();

    BigDecimal calcularImposto();
}
