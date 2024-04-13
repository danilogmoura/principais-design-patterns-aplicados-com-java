package com.github.danilogmoura.factory.servico;

import com.github.danilogmoura.factory.boleta.Boleta;
import com.github.danilogmoura.factory.notafiscal.NotaFiscal;

import java.io.IOException;
import java.util.Properties;

public class LojaFactory implements ModuloVendaFactory {

    private final Properties properties = new Properties();

    public LojaFactory() {
        try (var inputStream = LojaFactory.class.getResourceAsStream("/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new InvalidConfigurationException("Arquivo 'config.properties' não encontrado", e);
        }

        if (!properties.contains("nfe") || !properties.contains("boleta")) {
            throw new InvalidConfigurationException("Propriedades do arquivo 'config.properties' inválidas");
        }
    }

    @Override
    public NotaFiscal criarNotaFiscal() {
        try {
            return (NotaFiscal) Class.forName(properties.getProperty("nfe")).getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InstanceCreationException("Erro ao criar a instância", e);
        }
    }

    @Override
    public Boleta criarBoleta() {
        try {
            return (Boleta) Class.forName(properties.getProperty("boleta")).getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new InstanceCreationException("Erro ao criar a instância", e);
        }
    }
}
