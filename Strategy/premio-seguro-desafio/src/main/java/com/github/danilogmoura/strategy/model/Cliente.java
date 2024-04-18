package com.github.danilogmoura.strategy.model;

public class Cliente {

    private final String nome;
    private final int idade;
    private final Sexo sexo;

    public Cliente(String nome, int idade, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public enum Sexo {
        MASCULINO,
        FEMININO;

        public static Sexo get(int value) {
            return Sexo.values()[value - 1];
        }
    }
}


