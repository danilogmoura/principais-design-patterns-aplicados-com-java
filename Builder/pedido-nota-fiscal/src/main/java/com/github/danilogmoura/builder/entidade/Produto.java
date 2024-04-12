package com.github.danilogmoura.builder.entidade;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String nome;

    private BigDecimal preco;

    private boolean ativo = false;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", preco=" + preco +
               ", ativo=" + ativo +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
