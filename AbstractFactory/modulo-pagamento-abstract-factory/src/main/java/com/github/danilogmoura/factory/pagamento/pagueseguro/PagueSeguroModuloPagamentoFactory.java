package com.github.danilogmoura.factory.pagamento.pagueseguro;

import com.github.danilogmoura.factory.gestorderisco.GestorDeRisco;
import com.github.danilogmoura.factory.gestorderisco.fcontrol.FControl;
import com.github.danilogmoura.factory.operadora.Operadora;
import com.github.danilogmoura.factory.operadora.cielo.Cielo;
import com.github.danilogmoura.factory.pagamento.ModuloPagamentoFactory;

public class PagueSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {
    @Override
    public Operadora newOperadora() {
        return new Cielo();
    }

    @Override
    public GestorDeRisco newGestorDeRisco() {
        return new FControl();
    }
}
