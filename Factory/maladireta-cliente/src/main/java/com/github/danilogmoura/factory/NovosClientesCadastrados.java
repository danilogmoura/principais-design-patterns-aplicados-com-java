package com.github.danilogmoura.factory;

import com.github.danilogmoura.factory.maladireta.MalaDiretaCSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Scanner;

public class NovosClientesCadastrados {

    private static final Logger logger = LoggerFactory.getLogger(NovosClientesCadastrados.class);

    public static void main(String[] args) {
        Path arquivoContatos = Path.of("Factory/maladireta-cliente/src/main/resources/files/contatos.csv");

        System.out.println("Informe a mensagem para o e-mail");
        var mensagem = new Scanner(System.in).nextLine();

        new MalaDiretaCSV(arquivoContatos).enviarEmail(mensagem);
        logger.info("Mala direta emviada!");
    }
}