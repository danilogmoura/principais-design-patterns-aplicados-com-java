package com.github.danilogmoura.observer.observer;

import com.github.danilogmoura.observer.model.Lancamento;
import com.github.danilogmoura.observer.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailListener implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(EmailListener.class);

    private final Subject subject;

    public EmailListener(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        for (Lancamento lancamento : subject.getLancamentosVencidos()) {
            logger.info("Enviando e-mail para {}", lancamento.getPessoa().getEmail());
        }
    }
}
