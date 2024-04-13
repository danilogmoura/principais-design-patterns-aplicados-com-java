package com.github.danilogmoura.factory.servico;

import com.github.danilogmoura.factory.boleta.Boleta;
import com.github.danilogmoura.factory.notafiscal.NotaFiscal;

public class Venda {

    private final NotaFiscal notaFiscal;

    private final Boleta boleta;

    public Venda() {
        var lojaFactory = new LojaFactory();
        notaFiscal = lojaFactory.criarNotaFiscal();
        boleta = lojaFactory.criarBoleta();
    }

    public void realizar() {
        notaFiscal.gerar();
        boleta.emitir();
    }
}
