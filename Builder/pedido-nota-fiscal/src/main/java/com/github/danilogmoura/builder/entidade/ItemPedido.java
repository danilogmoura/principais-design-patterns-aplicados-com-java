package com.github.danilogmoura.builder.entidade;

import java.math.BigDecimal;

public class ItemPedido {

    private final Produto produto;

    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal valorTotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(getQuantidade()));
    }
}
