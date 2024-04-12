package com.github.danilogmoura.factory.maladireta;


import com.github.danilogmoura.factory.contato.Contato;
import com.github.danilogmoura.factory.contato.Contatos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class MalaDireta {

    private static final Logger logger = LoggerFactory.getLogger(MalaDireta.class);

    public void enviarEmail(String nomeArquivo, String mensagem) {
        Contatos contatosRepositorio = new Contatos();

        try {
            List<Contato> contatos = contatosRepositorio.recuperarContatosCSV(nomeArquivo);

            logger.info("Conectando no servidor SMTP...");
            logger.info("Mensagem a ser enviada: {}", mensagem);

            for (Contato contato : contatos) {
                logger.info("From: <contato@algaworks.com>");
                logger.info("To: [{}] <{}>\n", contato.getNome(), contato.getEmail());
                logger.info(mensagem);
            }
        } catch (IOException e) {
            logger.error("Erro na leitura do arquivo", e);
        }
    }
}