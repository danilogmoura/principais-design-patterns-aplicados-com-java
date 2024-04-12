package com.github.danilogmoura.builder.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;

abstract class NotaFiscal {

    private final String numero;
    private final LocalDate dataEmissao;
    private final Pedido pedido;

    protected NotaFiscal(String numero, LocalDate dataEmissao, Pedido pedido) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.pedido = pedido;
    }

    abstract Imposto getValorImposto();

    public String getNumero() {
        return numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal impostoDevido() {
        return getValorImposto().getPorcentagemImposto()
                       .multiply(pedido.getValorTotal());
    }
}
