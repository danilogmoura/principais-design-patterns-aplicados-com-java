package com.github.danilogmoura.factory.pagamento;

import com.github.danilogmoura.factory.gestorderisco.GestorDeRisco;
import com.github.danilogmoura.factory.operadora.Operadora;

import java.math.BigDecimal;

public class Pagamento {

    private final Operadora operadora;
    private final GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamento) {
        this.operadora = moduloPagamento.newOperadora();
        this.gestorDeRisco = moduloPagamento.newGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor) {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }
}