package com.github.danilogmoura.observer.senders;

import com.github.danilogmoura.observer.model.Lancamento;

import java.util.List;

public class EnviadorSMS {

    public void enviar(List<Lancamento> lancamentosVencidos) {
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
        }
    }
}
