package com.github.danilogmoura.observer.senders;

import com.github.danilogmoura.observer.model.Lancamento;

import java.util.List;

public class EnviadorEmail {

    public void enviar(List<Lancamento> lancamentosVencidos) {
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando e-mail para " + lancamento.getPessoa().getEmail());
        }
    }
}
