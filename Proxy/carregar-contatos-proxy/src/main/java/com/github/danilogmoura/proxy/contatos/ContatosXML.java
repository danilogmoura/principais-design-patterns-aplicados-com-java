package com.github.danilogmoura.proxy.contatos;

import com.github.danilogmoura.proxy.model.Contato;
import com.github.danilogmoura.proxy.repository.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContatosXML implements Contatos {

    private static final Logger logger = LoggerFactory.getLogger(ContatosXML.class);

    private final Map<String, String> contatosEmCache = new HashMap<>();

    @SuppressWarnings("unchecked")
    public ContatosXML(String... nomesArquivos) {
        XStream xstream = new XStream();

        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        for (String nomeArquivo : nomesArquivos) {
            logger.debug("Carregando arquivo: {}", nomeArquivo);
            List<Contato> contatosCarregados = (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + nomeArquivo));
            for (Contato contato : contatosCarregados) {
                contatosEmCache.put(contato.getEmail(), contato.getNome());
            }
        }
    }

    @Override
    public String buscarPor(String email) {
        return contatosEmCache.get(email);
    }
}