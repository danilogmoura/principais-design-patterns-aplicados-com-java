package com.github.danilogmoura.observer.model.builder;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.model.Pessoa;
import com.github.danilogmoura.observer.model.TipoLancamento;

import java.math.BigDecimal;
import java.util.Date;

public class LancamentoBuilder {

    private final Lancamento instancia;

    public LancamentoBuilder() {
        this.instancia = new Lancamento();
    }

    public static LancamentoBuilder crairLancamento() {
        return new LancamentoBuilder();
    }

    public LancamentoBuilder comPessoa(String nome, String email, String telefone) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setTelefone(telefone);
        this.instancia.setPessoa(pessoa);

        return this;
    }

    public LancamentoBuilder comDescricao(String descricao) {
        this.instancia.setDescricao(descricao);
        return this;
    }

    public LancamentoBuilder comValor(BigDecimal valor) {
        this.instancia.setValor(valor);
        return this;
    }

    public LancamentoBuilder doTipo(TipoLancamento tipo) {
        this.instancia.setTipo(tipo);
        return this;
    }

    public LancamentoBuilder comDataVencimento(Date dataVencimento) {
        this.instancia.setDataVencimento(dataVencimento);
        return this;
    }

    public Lancamento criar() {
        return this.instancia;
    }
}
