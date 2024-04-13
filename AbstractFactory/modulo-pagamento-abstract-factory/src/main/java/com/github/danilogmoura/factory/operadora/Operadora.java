package com.github.danilogmoura.factory.operadora;

import java.math.BigDecimal;

public interface Operadora {

    void capturar(String cartao, BigDecimal valor);

    Long confirmar();
}