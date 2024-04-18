package com.github.danilogmoura.proxy.contatos;

import com.github.danilogmoura.proxy.repository.Contatos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContatosXMLTest {


    @Test
    void deveRetornarContato() {
        Contatos contatos = new ContatosProxyXML("contatos1.xml", "contatos2.xml");
        String nome = contatos.buscarPor("jose@email.com");
        assertEquals("José Santos", nome);
    }
}