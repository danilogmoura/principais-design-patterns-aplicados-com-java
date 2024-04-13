package com.github.danilogmoura.factory.servico;

import com.github.danilogmoura.factory.boleta.Boleta;
import com.github.danilogmoura.factory.notafiscal.NotaFiscal;

public interface ModuloVendaFactory {

    NotaFiscal criarNotaFiscal();

    Boleta criarBoleta();
}
