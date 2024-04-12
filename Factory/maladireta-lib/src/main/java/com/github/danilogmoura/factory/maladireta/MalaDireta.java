package com.github.danilogmoura.factory.maladireta;


import com.github.danilogmoura.factory.contato.Contatos;
import com.github.danilogmoura.factory.contato.IContato;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class MalaDireta<T extends IContato> implements Contatos<T> {

    private static final Logger logger = LoggerFactory.getLogger(MalaDireta.class);

    public void enviarEmail(String mensagem) {
        logger.info("Conectando no servidor SMTP...");
        logger.info("Mensagem a ser enviada: {}", mensagem);

        for (T contato : todosContatos()) {
            logger.info("From: <contato@algaworks.com>");
            logger.info("To: [{}] <{}>", contato.getNome(), contato.getEmail());
            logger.info(mensagem);
            logger.info("");
        }
    }
}