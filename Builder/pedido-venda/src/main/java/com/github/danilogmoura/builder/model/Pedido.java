package com.github.danilogmoura.builder.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private String numero;
    private Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionaItem(ItemPedido item) {
        this.itens.add(item);
    }

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
        }

        if (cliente.isVip()) {
            valorTotal = valorTotal.multiply(new BigDecimal("0.96"));
        }

        return valorTotal;
    }

}