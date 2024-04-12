package com.github.danilogmoura.factory;

import com.github.danilogmoura.factory.maladireta.MalaDireta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Principal {

    private static final Logger logger = LoggerFactory.getLogger(Principal.class);

    public static void main(String[] args) {
        System.out.println("Informe a mensagem para o e-mail");
        var mensagem = new Scanner(System.in).nextLine();

        new MalaDireta().enviarEmail("contatos.csv", mensagem);
        logger.info("Mala direta emviada!");
    }
}
