package com.github.danilogmoura.factory.pagamento;

import com.github.danilogmoura.factory.gestorderisco.GestorDeRisco;
import com.github.danilogmoura.factory.operadora.Operadora;

public interface ModuloPagamentoFactory {

    Operadora newOperadora();

    GestorDeRisco newGestorDeRisco();
}
