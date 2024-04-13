package com.github.danilogmoura.factory.gestorderisco;

import java.math.BigDecimal;

public interface GestorDeRisco {

    void avaliarRisco(String cartao, BigDecimal valor);
}