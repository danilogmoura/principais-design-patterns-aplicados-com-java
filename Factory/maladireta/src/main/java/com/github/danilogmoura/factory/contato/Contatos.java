package com.github.danilogmoura.factory.contato;

import au.com.bytecode.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Contatos {

    private static final Path RESOURCES_PATH = Path.of("Factory\\maladireta\\src\\main\\resources\\files");

    public List<Contato> recuperarContatosCSV(String nomeArquivo) throws IOException {
        Path arquivo = RESOURCES_PATH.resolve(nomeArquivo);

        if (!Files.exists(arquivo)) {
            throw new IOException("Arquivo não existe");
        }

        try (var reader = Files.newBufferedReader(arquivo)) {
            List<Contato> contatos = new ArrayList<>();

            CSVReader csvReader = new CSVReader(reader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
            }
            return contatos;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Contato> recuperarContatosXML(String nomeArquivo) throws IOException {
        Path arquivo = RESOURCES_PATH.resolve(nomeArquivo);

        if (!Files.exists(arquivo)) {
            throw new IOException("Arquivo não existe");
        }

        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        try (var reader = Files.newBufferedReader(arquivo)) {
            return (List<Contato>) xstream.fromXML(reader);
        }
    }
}
