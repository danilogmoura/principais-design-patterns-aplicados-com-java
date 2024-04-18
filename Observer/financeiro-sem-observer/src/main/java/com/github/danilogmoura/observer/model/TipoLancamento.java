package com.github.danilogmoura.observer.model;

public enum TipoLancamento {

    DESPESA("Despesa"),
    RECEITA("Receita");

    private final String descricao;

    TipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
