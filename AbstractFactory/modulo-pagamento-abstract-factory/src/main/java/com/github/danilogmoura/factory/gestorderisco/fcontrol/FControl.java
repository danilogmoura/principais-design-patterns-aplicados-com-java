package com.github.danilogmoura.factory.gestorderisco.fcontrol;

import com.github.danilogmoura.factory.gestorderisco.AlertaDeRiscoException;
import com.github.danilogmoura.factory.gestorderisco.GestorDeRisco;

import java.math.BigDecimal;

public class FControl implements GestorDeRisco {

    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) {
        if (cartao.startsWith("7777")) {
            throw new AlertaDeRiscoException("Cartão suspeito.");
        }
    }
}