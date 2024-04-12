package com.github.danilogmoura.factory.maladireta;

import com.github.danilogmoura.factory.entidade.Cliente;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MalaDiretaXML extends MalaDireta<Cliente> {

    private final Path path;

    public MalaDiretaXML(Path path) {
        if (!Files.isRegularFile(path) || !Files.exists(path)) {
            throw new FileDoesNotExistException("Arquivo não existe");
        }
        this.path = path;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cliente> todosContatos() {
        XStream xstream = new XStream();
        xstream.allowTypes(new Class[]{Cliente.class});
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Cliente.class);

        try (var reader = Files.newBufferedReader(path)) {
            return (List<Cliente>) xstream.fromXML(reader);
        } catch (IOException e) {
            throw new FileProcessingException("Fala ao processar arquivo XML", e);
        }
    }
}
