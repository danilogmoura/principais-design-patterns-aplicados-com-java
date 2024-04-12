package com.github.danilogmoura.builder.model;

import com.github.danilogmoura.builder.model.builder.PedidoVendaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PedidoTest {

    @Test
    void deveCalcularValorTotal() {
        var pedidoVenda = new Pedido();

        var cliente = new Cliente();
        cliente.setNome("João");
        cliente.setVip(true);
        pedidoVenda.setCliente(cliente);

        var item1 = new ItemPedido();
        item1.setNome("Calculadora");
        item1.setValorUnitario(new BigDecimal("200"));
        item1.setQuantidade(2);

        var item2 = new ItemPedido();
        item2.setNome("Mochila");
        item2.setValorUnitario(new BigDecimal("200"));
        item2.setQuantidade(1);

        pedidoVenda.adicionaItem(item1);
        pedidoVenda.adicionaItem(item2);

        var valorTotal = new BigDecimal("576").doubleValue();
        Assertions.assertEquals(valorTotal, pedidoVenda.getValorTotal().doubleValue(), 0.0001);
    }

    @Test
    void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
        var pedidoBuilder = new PedidoVendaBuilder()
                                    .comNumero("202")
                                    .comClienteVip("João Silva")
                                    .comItem("Calculadora", "200", 2)
                                    .comItem("Mochila", "200", 1)
                                    .construir();

        var valorTotal = new BigDecimal("576").doubleValue();
        Assertions.assertEquals(valorTotal, pedidoBuilder.getValorTotal().doubleValue(), 0.0001);
    }
}