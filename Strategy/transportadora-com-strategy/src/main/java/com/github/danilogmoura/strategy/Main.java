package com.github.danilogmoura.strategy;

import com.github.danilogmoura.strategy.service.Frete;
import com.github.danilogmoura.strategy.service.TipoFrete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe a distância: ");
            int distancia = entrada.nextInt();
            System.out.print("Qual o tipo de frete (1) Normal, (2) Sedex: ");
            int opcaoFrete = entrada.nextInt();
            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1];

            Frete frete = tipoFrete.getFrete();
            double preco = frete.calcularPreco(distancia);
            System.out.printf("O valor total é de R$%.2f", preco);
        }
    }
}
