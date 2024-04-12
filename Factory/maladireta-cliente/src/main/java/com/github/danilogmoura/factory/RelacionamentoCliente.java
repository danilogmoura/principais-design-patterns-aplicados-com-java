package com.github.danilogmoura.factory;

import com.github.danilogmoura.factory.maladireta.MalaDiretaXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Scanner;

public class RelacionamentoCliente {

    private static final Logger logger = LoggerFactory.getLogger(RelacionamentoCliente.class);

    public static void main(String[] args) {
        Path arquivoContatos = Path.of("Factory/maladireta-cliente/src/main/resources/files/contatos.xml");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a mensagem para o e-mail: ");
        var mensagem = scanner.nextLine();

        new MalaDiretaXML(arquivoContatos).enviarEmail(mensagem);
        logger.info("Mala direta emviada!");
    }
}
