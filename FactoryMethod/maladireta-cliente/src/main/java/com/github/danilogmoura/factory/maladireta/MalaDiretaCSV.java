package com.github.danilogmoura.factory.maladireta;

import au.com.bytecode.opencsv.CSVReader;
import com.github.danilogmoura.factory.entidade.Cliente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MalaDiretaCSV extends MalaDireta<Cliente> {

    private final Path path;

    public MalaDiretaCSV(Path path) {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            throw new FileDoesNotExistException("Arquivo não existe");
        }

        this.path = path;
    }

    @Override
    public List<Cliente> todosContatos() {
        try (var reader = Files.newBufferedReader(path)) {
            List<Cliente> contatos = new ArrayList<>();

            CSVReader csvReader = new CSVReader(reader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Cliente(nextLine[0].trim(), nextLine[1].trim()));
            }
            return contatos;
        } catch (IOException e) {
            throw new FileProcessingException("Fala ao processar arquivo CSV", e);
        }
    }
}
