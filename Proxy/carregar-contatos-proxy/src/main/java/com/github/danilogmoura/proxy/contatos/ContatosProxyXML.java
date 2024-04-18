package com.github.danilogmoura.proxy.contatos;

import com.github.danilogmoura.proxy.repository.Contatos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ContatosProxyXML implements Contatos {

    private static final Logger logger = LoggerFactory.getLogger(ContatosProxyXML.class);

    private final List<String> files;
    private final Random random = new Random();

    public ContatosProxyXML(String... nomesArquivos) {
        this.files = new ArrayList<>(Arrays.asList(nomesArquivos));
    }


    @Override
    public String buscarPor(String email) {
        var numberOfFiles = files.size();
        for (int i = 0; i < numberOfFiles; i++) {
            var index = random.nextInt(files.size());

            var fileName = files.remove(index);
            var contatosXML = new ContatosXML(fileName);
            var contactName = contatosXML.buscarPor(email);

            logger.debug("index: {}", index);
            if (contactName != null) {
                return contactName;
            }
        }

        throw new IllegalArgumentException("Contato não foi encontrado, insira um e-mail cadastrado");
    }
}