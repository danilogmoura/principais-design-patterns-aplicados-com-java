package com.github.danilogmoura.strategy;

import com.github.danilogmoura.strategy.model.Cliente;
import com.github.danilogmoura.strategy.service.TipoVeiculo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nome: ");
        var nome = scanner.next();

        System.out.print("Idade: ");
        var idade = scanner.nextInt();

        System.out.print("Sexo (1 - M / 2 - F): ");
        var sexo = Cliente.Sexo.get(scanner.nextInt());

        var cliente = new Cliente(nome, idade, sexo);

        String continuar = "s";
        while ("s".equalsIgnoreCase(continuar)) {
            System.out.println("Tipo de veículo: ");
            TipoVeiculo.menu().forEach(System.out::println);
            var tipoVeiculo = scanner.nextInt();
            var calculadoraPremioSeguro = TipoVeiculo.get(tipoVeiculo);

            System.out.print("Valor do veículo: ");
            var valorVeiculo = new BigDecimal(scanner.next());
            var premioSeguro = calculadoraPremioSeguro.getCalculadoraPremio().calcular(cliente, valorVeiculo);

            System.out.printf("O prêmio do seguro para %s é de R$%.2f%n", cliente.getNome(), premioSeguro);

            System.out.println("Calcular para um novo veículo? (s - Sim / n - Não) ");
            continuar = scanner.next();
        }
    }
}
