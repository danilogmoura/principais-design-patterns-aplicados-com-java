package com.github.danilogmoura.builder.entidade;

import java.time.LocalDate;

public class NotaFiscalPessoaFisica extends NotaFiscal {

    protected NotaFiscalPessoaFisica(String numero, LocalDate dataEmissao, Pedido pedido) {
        super(numero, dataEmissao, pedido);
    }

    @Override
    Imposto getValorImposto() {
        return new ImpostoPessoaFisica();
    }
}
