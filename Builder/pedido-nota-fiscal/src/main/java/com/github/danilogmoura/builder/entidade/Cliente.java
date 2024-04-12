package com.github.danilogmoura.builder.entidade;

public class Cliente {

    private final ClienteVip clienteVip;
    private String nome;

    public Cliente(String nome, ClienteVip clienteVip) {
        this.nome = nome;
        this.clienteVip = clienteVip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteVip isVip() {
        return clienteVip;
    }

    public enum ClienteVip {
        SIM, NAO
    }
}