package com.github.danilogmoura.builder.model.builder;

import com.github.danilogmoura.builder.model.Cliente;
import com.github.danilogmoura.builder.model.ItemPedido;
import com.github.danilogmoura.builder.model.Pedido;

import java.math.BigDecimal;

public class PedidoVendaBuilder {

    private final Pedido instancia;

    public PedidoVendaBuilder() {
        this.instancia = new Pedido();
    }

    public Pedido construir() {
        return this.instancia;
    }

    public PedidoVendaBuilder comClienteVip(String nome) {
        definirCliente(nome, true);
        return this;
    }

    public PedidoVendaBuilder comClienteNormal(String nome) {
        definirCliente(nome, false);
        return this;
    }

    private void definirCliente(String nome, boolean vip) {
        var cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setVip(vip);
        this.instancia.setCliente(cliente);
    }

    public PedidoVendaBuilder comItem(String nome, String valorUnitario, Integer quantidade) {
        var item = new ItemPedido();
        item.setNome(nome);
        item.setValorUnitario(new BigDecimal(valorUnitario));
        item.setQuantidade(quantidade);
        this.instancia.adicionaItem(item);
        return this;
    }

    public PedidoVendaBuilder comNumero(String numero) {
        this.instancia.setNumero(numero);
        return this;
    }
}
