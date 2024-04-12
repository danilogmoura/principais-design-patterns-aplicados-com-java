package com.github.danilogmoura.builder.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private final List<ItemPedido> itens = new ArrayList<>();
    private final String numero;
    private final Cliente cliente;

    public Pedido(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionaProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que 0");
        }

        itens.add(new ItemPedido(produto, quantidade));
    }

    public BigDecimal getValorTotal() {
        return getItens().stream()
                       .map(ItemPedido::valorTotal)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getValorItens() {
        return getItens().stream()
                       .mapToInt(ItemPedido::getQuantidade)
                       .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(numero, pedido.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
